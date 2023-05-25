/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2023 Atlan Pte. Ltd. */
package com.atlan.generators;

import com.atlan.Atlan;
import com.atlan.api.TypeDefsEndpoint;
import com.atlan.model.enums.AtlanTypeCategory;
import com.atlan.model.typedefs.*;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ModelGeneratorV2 {

    static {
        Atlan.setBaseUrl(System.getenv("ATLAN_BASE_URL"));
        Atlan.setApiToken(System.getenv("ATLAN_API_KEY"));
    }

    private static final String TEMPLATES_DIRECTORY =
            "src" + File.separator + "generate" + File.separator + "resources" + File.separator + "templates";

    private static final Map<String, EnumGenerator> enumCache = new HashMap<>();
    private static final Map<String, StructGenerator> structCache = new HashMap<>();
    private static final Map<String, AssetGenerator> assetCache = new HashMap<>();
    private static final Map<String, Set<SearchFieldGenerator.Field>> searchCache = new HashMap<>();

    protected static final Map<String, Set<String>> uniqueRelationshipsForType = new ConcurrentHashMap<>();
    private static final Map<String, String> subTypeToSuperType = new ConcurrentHashMap<>();
    private static final Map<String, List<String>> subTypeToSuperTypes = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATES_DIRECTORY));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());

        List<EntityDef> entityDefs =
                TypeDefsEndpoint.getTypeDefs(AtlanTypeCategory.ENTITY).getEntityDefs();
        cacheRelationshipsForInheritance(entityDefs);

        generateEnums(cfg);
        generateStructs(cfg);
        generateAssets(cfg, entityDefs);
        generateSearchFields(cfg, entityDefs);
        generateAssetTests(cfg);
        generateAssetDocs(cfg);
        generateFullModelDiagram(cfg);
        generateUpdatedAttributeCSV();
    }

    private static void generateEnums(Configuration cfg) throws Exception {
        TypeDefResponse enums = TypeDefsEndpoint.getTypeDefs(AtlanTypeCategory.ENUM);
        if (enums != null && enums.getEnumDefs() != null) {
            Template enumTemplate = cfg.getTemplate("enum.ftl");
            for (EnumDef enumDef : enums.getEnumDefs()) {
                EnumGenerator generator = new EnumGenerator(enumDef);
                String filename = EnumGenerator.DIRECTORY + File.separator + generator.getClassName() + ".java";
                try (BufferedWriter fs = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                    enumTemplate.process(generator, fs);
                    enumCache.put(enumDef.getName(), generator);
                } catch (IOException e) {
                    log.error("Unable to open file output: {}", filename, e);
                }
            }
        }
    }

    private static void generateStructs(Configuration cfg) throws Exception {
        TypeDefResponse structs = TypeDefsEndpoint.getTypeDefs(AtlanTypeCategory.STRUCT);
        if (structs != null && structs.getStructDefs() != null) {
            Template structTemplate = cfg.getTemplate("struct.ftl");
            for (StructDef structDef : structs.getStructDefs()) {
                StructGenerator generator = new StructGenerator(structDef);
                String filename = StructGenerator.DIRECTORY + File.separator + generator.getClassName() + ".java";
                try (BufferedWriter fs = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                    structTemplate.process(generator, fs);
                    structCache.put(structDef.getName(), generator);
                } catch (IOException e) {
                    log.error("Unable to open file output: {}", filename, e);
                }
            }
            Template abstractStructTemplate = cfg.getTemplate("AtlanStruct.ftl");
            String filename = StructGenerator.DIRECTORY + File.separator + "AtlanStruct.java";
            try (BufferedWriter fs = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                List<String> structNames =
                        structCache.keySet().stream().sorted().collect(Collectors.toList());
                ListGenerator generator = new ListGenerator(structNames);
                abstractStructTemplate.process(generator, fs);
            } catch (IOException e) {
                log.error("Unable to open file output: {}", filename, e);
            }
        }
    }

    private static void generateAssets(Configuration cfg, List<EntityDef> entityDefs) throws Exception {
        // In the first pass, only cache the class names and the un-resolved generators
        // (need all class names resolved first, since they may all reference each other
        // in their resolved details)
        for (EntityDef entityDef : entityDefs) {
            AssetGenerator generator = new AssetGenerator(entityDef);
            assetCache.put(entityDef.getName(), generator);
        }
        Template entityTemplate = cfg.getTemplate("entity.ftl");
        for (AssetGenerator generator : assetCache.values()) {
            if (!AssetGenerator.SKIP_GENERATING.contains(generator.getOriginalName())) {
                String filename = AssetGenerator.DIRECTORY + File.separator + generator.getClassName() + ".java";
                try (BufferedWriter fs = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                    // Now that all are cached, render the inner details of the generator
                    // before processing the template
                    generator.resolveDetails();
                    entityTemplate.process(generator, fs);
                } catch (IOException e) {
                    log.error("Unable to open file output: {}", filename, e);
                }
            }
        }
        // Inject all these generated assets into the AttributeDefOptions class (regenerate it)
        Template attributeDefOptionsTemplate = cfg.getTemplate("AttributeDefOptions.ftl");
        String filename = "src" + File.separator
                + "main" + File.separator
                + "java" + File.separator
                + "com" + File.separator
                + "atlan" + File.separator
                + "model" + File.separator
                + "typedefs" + File.separator
                + "AttributeDefOptions.java";
        try (BufferedWriter fs =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
            // Now that all are generated, output the generated switch-based deserialization
            SerdeGenerator generator = new SerdeGenerator(assetCache.values());
            attributeDefOptionsTemplate.process(generator, fs);
        } catch (IOException e) {
            log.error("Unable to open file output: {}", filename, e);
        }
        // Finally, inject all these generated assets into the AssetDeserializer class (regenerate it)
        Template assetDeserializerTemplate = cfg.getTemplate("AssetDeserializer.ftl");
        filename = SerdeGenerator.DIRECTORY + File.separator + "AssetDeserializer.java";
        try (BufferedWriter fs =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
            // Now that all are generated, output the generated switch-based deserialization
            SerdeGenerator generator = new SerdeGenerator(assetCache.values());
            assetDeserializerTemplate.process(generator, fs);
        } catch (IOException e) {
            log.error("Unable to open file output: {}", filename, e);
        }
    }

    private static void generateSearchFields(Configuration cfg, List<EntityDef> entityDefs) throws Exception {
        Template searchTemplate = cfg.getTemplate("enum_search.ftl");
        Set<SearchFieldGenerator.IndexType> enumsToGenerate = Set.of(
                SearchFieldGenerator.IndexType.NUMERIC,
                SearchFieldGenerator.IndexType.KEYWORD,
                SearchFieldGenerator.IndexType.TEXT,
                SearchFieldGenerator.IndexType.STEMMED,
                SearchFieldGenerator.IndexType.BOOLEAN,
                SearchFieldGenerator.IndexType.RANK_FEATURE);
        for (SearchFieldGenerator.IndexType toGenerate : enumsToGenerate) {
            log.info("Generating for: {}", toGenerate);
            SearchFieldGenerator generator = new SearchFieldGenerator(entityDefs, toGenerate);
            String filename = SearchFieldGenerator.DIRECTORY + File.separator + generator.getClassName() + ".java";
            try (BufferedWriter fs = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                searchTemplate.process(generator, fs);
            } catch (IOException e) {
                log.error("Unable to open file output: {}", filename, e);
            }
        }
    }

    private static void generateAssetTests(Configuration cfg) throws Exception {
        Template testTemplate = cfg.getTemplate("asset_test.ftl");
        for (AssetGenerator assetGen : assetCache.values()) {
            if (!AssetGenerator.SKIP_GENERATING.contains(assetGen.getOriginalName()) && !assetGen.isAbstract()) {
                AssetTestGenerator generator = new AssetTestGenerator(assetGen);
                String filename =
                        AssetTestGenerator.DIRECTORY + File.separator + generator.getClassName() + "Test.java";
                try (BufferedWriter fs = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                    // Now that all are cached, render the inner details of the generator
                    // before processing the template
                    generator.resolveDetails();
                    testTemplate.process(generator, fs);
                } catch (IOException e) {
                    log.error("Unable to open file output: {}", filename, e);
                }
            }
        }
    }

    private static void generateAssetDocs(Configuration cfg) throws Exception {
        Template docTemplate = cfg.getTemplate("asset_doc.ftl");
        Template javaPropertySnippetTemplate = cfg.getTemplate("snippet_java_properties.ftl");
        Template javaRelationshipSnippetTemplate = cfg.getTemplate("snippet_java_relationships.ftl");
        Template rawPropertySnippetTemplate = cfg.getTemplate("snippet_raw_properties.ftl");
        Template rawRelationshipSnippetTemplate = cfg.getTemplate("snippet_raw_relationships.ftl");
        for (AssetGenerator assetGen : assetCache.values()) {
            if (!AssetGenerator.SKIP_GENERATING.contains(assetGen.getOriginalName())) {
                AssetDocGenerator generator = new AssetDocGenerator(assetGen);
                // Now that all are cached, render the inner details of the generator
                // before processing the template
                generator.resolveDetails();
                String originalName = generator.getOriginalName().toLowerCase();
                // First the overall asset file
                String filename = AssetDocGenerator.DIRECTORY + File.separator + originalName + ".md";
                try (BufferedWriter fs = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                    docTemplate.process(generator, fs);
                } catch (IOException e) {
                    log.error("Unable to open file output: {}", filename, e);
                }
                // Then the snippets
                filename = AssetDocGenerator.DIRECTORY + File.separator + "snippets" + File.separator + "model"
                        + File.separator + "java" + File.separator + originalName + "-properties.md";
                try (BufferedWriter fs = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                    javaPropertySnippetTemplate.process(generator, fs);
                } catch (IOException e) {
                    log.error("Unable to open file output: {}", filename, e);
                }
                filename = AssetDocGenerator.DIRECTORY + File.separator + "snippets" + File.separator + "model"
                        + File.separator + "java" + File.separator + originalName + "-relationships.md";
                try (BufferedWriter fs = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                    javaRelationshipSnippetTemplate.process(generator, fs);
                } catch (IOException e) {
                    log.error("Unable to open file output: {}", filename, e);
                }
                filename = AssetDocGenerator.DIRECTORY + File.separator + "snippets" + File.separator + "model"
                        + File.separator + "raw" + File.separator + originalName + "-properties.md";
                try (BufferedWriter fs = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                    rawPropertySnippetTemplate.process(generator, fs);
                } catch (IOException e) {
                    log.error("Unable to open file output: {}", filename, e);
                }
                filename = AssetDocGenerator.DIRECTORY + File.separator + "snippets" + File.separator + "model"
                        + File.separator + "raw" + File.separator + originalName + "-relationships.md";
                try (BufferedWriter fs = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
                    rawRelationshipSnippetTemplate.process(generator, fs);
                } catch (IOException e) {
                    log.error("Unable to open file output: {}", filename, e);
                }
            }
        }
    }

    private static void generateFullModelDiagram(Configuration cfg) throws Exception {
        Template modelTemplate = cfg.getTemplate("full_model.ftl");
        AssetGenerator referenceable = assetCache.get("Referenceable");
        AssetDocGenerator generator = new AssetDocGenerator(referenceable);
        // Now that all are cached, render the inner details of the generator
        // before processing the template
        generator.resolveDetails();
        String filename = AssetDocGenerator.DIRECTORY + File.separator + "index.md";
        try (BufferedWriter fs =
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
            modelTemplate.process(generator, fs);
        } catch (IOException e) {
            log.error("Unable to open file output: {}", filename, e);
        }
    }

    private static void generateUpdatedAttributeCSV() throws Exception {
        AttributeCSVGenerator.generate();
    }

    public static TypeGenerator.MappedType getCachedType(String typeName) {
        if (enumCache.containsKey(typeName)) {
            return TypeGenerator.MappedType.builder()
                    .type(TypeGenerator.MappedType.Type.ENUM)
                    .name(enumCache.get(typeName).getClassName())
                    .build();
        } else if (structCache.containsKey(typeName)) {
            return TypeGenerator.MappedType.builder()
                    .type(TypeGenerator.MappedType.Type.STRUCT)
                    .name(structCache.get(typeName).getClassName())
                    .build();
        } else if (assetCache.containsKey(typeName)) {
            return TypeGenerator.MappedType.builder()
                    .type(TypeGenerator.MappedType.Type.ASSET)
                    .name(assetCache.get(typeName).getClassName())
                    .build();
        }
        return null;
    }

    public static AssetGenerator getCachedAssetType(String typeName) {
        return assetCache.get(typeName);
    }

    static String getTemplateFile(String className) {
        File file = new File(TEMPLATES_DIRECTORY + File.separator + className + ".ftl");
        return file.isFile() ? file.getName() : null;
    }

    static Set<String> getUniqueRelationshipsForType(String originalName) {
        return uniqueRelationshipsForType.get(originalName);
    }

    static void cacheRelationshipsForInheritance(List<EntityDef> entityDefs) {
        // Populate 'relationshipsForType' map so that we don't repeat inherited attributes in subtypes
        // (this seems to only be a risk for relationship attributes)
        if (!entityDefs.isEmpty()) {
            List<EntityDef> leftOvers = new ArrayList<>();
            for (EntityDef entityDef : entityDefs) {
                String typeName = entityDef.getName();
                List<String> superTypes = entityDef.getSuperTypes();
                List<RelationshipAttributeDef> relationships = entityDef.getRelationshipAttributeDefs();
                if (superTypes == null || superTypes.isEmpty()) {
                    subTypeToSuperTypes.put(typeName, new ArrayList<>());
                } else {
                    subTypeToSuperTypes.put(typeName, superTypes);
                }
                if (superTypes == null || superTypes.isEmpty() || typeName.equals("Asset")) {
                    subTypeToSuperType.put(typeName, "");
                    uniqueRelationshipsForType.put(
                            typeName,
                            relationships.stream()
                                    .map(RelationshipAttributeDef::getName)
                                    .collect(Collectors.toSet()));
                } else {
                    String singleSuperType = AssetGenerator.getSingleTypeToExtend(typeName, superTypes);
                    if (uniqueRelationshipsForType.containsKey(singleSuperType)) {
                        subTypeToSuperType.put(typeName, singleSuperType);
                        Set<String> inheritedRelationships = getAllInheritedRelationships(singleSuperType);
                        Set<String> uniqueRelationships = relationships.stream()
                                .map(RelationshipAttributeDef::getName)
                                .collect(Collectors.toSet());
                        uniqueRelationships.removeAll(inheritedRelationships);
                        uniqueRelationshipsForType.put(typeName, uniqueRelationships);
                    } else {
                        leftOvers.add(entityDef);
                    }
                }
            }
            cacheRelationshipsForInheritance(leftOvers);
        }
    }

    private static Set<String> getAllInheritedRelationships(String superTypeName) {
        // Retrieve all relationship attributes from the supertype (and up) for the received type
        if (superTypeName.equals("")) {
            return new HashSet<>();
        } else {
            Set<String> relations = new HashSet<>(uniqueRelationshipsForType.get(superTypeName));
            relations.addAll(getAllInheritedRelationships(subTypeToSuperType.get(superTypeName)));
            return relations;
        }
    }

    static void addSearchFieldToCache(String className, String attrName, SearchFieldGenerator.Field field) {
        String attrQName = AttributeCSVCache.getAttrQualifiedName(className, attrName);
        if (!searchCache.containsKey(attrQName)) {
            searchCache.put(attrQName, new TreeSet<>());
        }
        searchCache.get(attrQName).add(field);
    }

    static Set<SearchFieldGenerator.Field> getCachedSearchFields(String className, String attrName) {
        return searchCache.get(AttributeCSVCache.getAttrQualifiedName(className, attrName));
    }

    static LinkedHashSet<String> getAllSuperTypesForType(String typeName) {
        List<String> next = subTypeToSuperTypes.get(typeName);
        if (next.isEmpty()) {
            LinkedHashSet<String> root = new LinkedHashSet<>();
            root.add(typeName);
            return root;
        } else {
            LinkedHashSet<String> now = new LinkedHashSet<>(next);
            for (String superType : next) {
                LinkedHashSet<String> again = getAllSuperTypesForType(superType);
                now.addAll(again);
            }
            return now;
        }
    }
}