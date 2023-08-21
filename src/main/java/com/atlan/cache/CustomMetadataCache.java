/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.cache;

import com.atlan.api.TypeDefsEndpoint;
import com.atlan.exception.*;
import com.atlan.model.core.CustomMetadataAttributes;
import com.atlan.model.enums.AtlanTypeCategory;
import com.atlan.model.typedefs.AttributeDef;
import com.atlan.model.typedefs.CustomMetadataDef;
import com.atlan.model.typedefs.TypeDefResponse;
import com.atlan.serde.Removable;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * Lazily-loaded cache for translating between Atlan-internal ID strings and human-readable names for
 * custom metadata (including attributes).
 */
@Slf4j
public class CustomMetadataCache {

    private Map<String, CustomMetadataDef> cacheById = new ConcurrentHashMap<>();
    private Map<String, AttributeDef> attrCacheById = new ConcurrentHashMap<>();
    private Map<String, String> mapIdToName = new ConcurrentHashMap<>();
    private Map<String, String> mapNameToId = new ConcurrentHashMap<>();

    private Map<String, Map<String, String>> mapAttrIdToName = new ConcurrentHashMap<>();
    private Map<String, Map<String, String>> mapAttrNameToId = new ConcurrentHashMap<>();
    private Map<String, String> archivedAttrIds = new ConcurrentHashMap<>();

    private final TypeDefsEndpoint typeDefsEndpoint;

    public CustomMetadataCache(TypeDefsEndpoint typeDefsEndpoint) {
        this.typeDefsEndpoint = typeDefsEndpoint;
    }

    /**
     * Refreshes the cache of custom metadata structures by requesting the full set of custom metadata
     * structures from Atlan.
     *
     * @throws AtlanException on any API communication problem
     */
    public synchronized void refreshCache() throws AtlanException {
        log.debug("Refreshing cache of custom metadata...");
        TypeDefResponse response = typeDefsEndpoint.list(AtlanTypeCategory.CUSTOM_METADATA);
        List<CustomMetadataDef> customMetadata;
        if (response != null) {
            customMetadata = response.getCustomMetadataDefs();
        } else {
            customMetadata = Collections.emptyList();
        }
        cacheById = new ConcurrentHashMap<>();
        attrCacheById = new ConcurrentHashMap<>();
        mapIdToName = new ConcurrentHashMap<>();
        mapNameToId = new ConcurrentHashMap<>();
        mapAttrIdToName = new ConcurrentHashMap<>();
        mapAttrNameToId = new ConcurrentHashMap<>();
        archivedAttrIds = new ConcurrentHashMap<>();
        for (CustomMetadataDef bmDef : customMetadata) {
            String typeId = bmDef.getName();
            cacheById.put(typeId, bmDef);
            mapIdToName.put(typeId, bmDef.getDisplayName());
            mapNameToId.put(bmDef.getDisplayName(), typeId);
            mapAttrIdToName.put(typeId, new ConcurrentHashMap<>());
            mapAttrNameToId.put(typeId, new ConcurrentHashMap<>());
            for (AttributeDef attributeDef : bmDef.getAttributeDefs()) {
                String attrId = attributeDef.getName();
                String attrName = attributeDef.getDisplayName();
                mapAttrIdToName.get(typeId).put(attrId, attrName);
                attrCacheById.put(attrId, attributeDef);
                if (attributeDef.isArchived()) {
                    archivedAttrIds.put(attrId, attrName);
                } else {
                    String existingId =
                            mapAttrNameToId.get(typeId).put(attributeDef.getDisplayName(), attributeDef.getName());
                    if (existingId != null) {
                        throw new LogicException(
                                ErrorCode.DUPLICATE_CUSTOM_ATTRIBUTES,
                                attributeDef.getDisplayName(),
                                bmDef.getDisplayName());
                    }
                }
            }
        }
    }

    /**
     * Translate the provided human-readable custom metadata set name to the Atlan-internal ID string.
     *
     * @param name human-readable name of the custom metadata set
     * @return Atlan-internal ID string of the custom metadata set
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     * @throws NotFoundException if the custom metadata cannot be found (does not exist) in Atlan
     * @throws InvalidRequestException if no name was provided for the custom metadata to retrieve
     */
    public String getIdForName(String name) throws AtlanException {
        if (name != null && !name.isEmpty()) {
            String cmId = mapNameToId.get(name);
            if (cmId == null) {
                // If not found, refresh the cache and look again (could be stale)
                refreshCache();
                cmId = mapNameToId.get(name);
                if (cmId == null) {
                    throw new NotFoundException(ErrorCode.CM_NOT_FOUND_BY_NAME, name);
                }
            }
            return cmId;
        } else {
            throw new InvalidRequestException(ErrorCode.MISSING_CM_NAME);
        }
    }

    /**
     * Translate the provided Atlan-internal custom metadata ID string to the human-readable custom metadata set name.
     *
     * @param id Atlan-internal ID string of the custom metadata set
     * @return human-readable name of the custom metadata set
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     * @throws NotFoundException if the custom metadata cannot be found (does not exist) in Atlan
     * @throws InvalidRequestException if no name was provided for the custom metadata to retrieve
     */
    public String getNameForId(String id) throws AtlanException {
        if (id != null && !id.isEmpty()) {
            String cmName = mapIdToName.get(id);
            if (cmName == null) {
                // If not found, refresh the cache and look again (could be stale)
                refreshCache();
                cmName = mapIdToName.get(id);
                if (cmName == null) {
                    throw new NotFoundException(ErrorCode.CM_NOT_FOUND_BY_ID, id);
                }
            }
            return cmName;
        } else {
            throw new InvalidRequestException(ErrorCode.MISSING_CM_ID);
        }
    }

    /**
     * Retrieve all the (active) custom metadata attributes. The map will be keyed by custom metadata set
     * name, and the value will be a listing of all the (active) attributes within that set (with all the details
     * of each of those attributes).
     *
     * @return a map from custom metadata set name to all details about all its active attributes
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public Map<String, List<AttributeDef>> getAllCustomAttributes() throws AtlanException {
        return getAllCustomAttributes(false);
    }

    /**
     * Retrieve all the custom metadata attributes. The map will be keyed by custom metadata set
     * name, and the value will be a listing of all the attributes within that set (with all the details
     * of each of those attributes).
     *
     * @param includeDeleted if true, include the archived (deleted) custom attributes; otherwise only include active custom attributes
     * @return a map from custom metadata set name to all details about all its attributes
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public Map<String, List<AttributeDef>> getAllCustomAttributes(boolean includeDeleted) throws AtlanException {
        return getAllCustomAttributes(includeDeleted, false);
    }

    /**
     * Retrieve all the custom metadata attributes. The map will be keyed by custom metadata set
     * name, and the value will be a listing of all the attributes within that set (with all the details
     * of each of those attributes).
     *
     * @param includeDeleted if true, include the archived (deleted) custom attributes; otherwise only include active custom attributes
     * @param forceRefresh if true, will refresh the custom metadata cache; if false, will only refresh
     *                     the cache if it is empty
     * @return a map from custom metadata set name to all details about all its attributes
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public Map<String, List<AttributeDef>> getAllCustomAttributes(boolean includeDeleted, boolean forceRefresh)
            throws AtlanException {
        if (cacheById.isEmpty() || forceRefresh) {
            refreshCache();
        }
        Map<String, List<AttributeDef>> map = new HashMap<>();
        for (Map.Entry<String, CustomMetadataDef> entry : cacheById.entrySet()) {
            String typeId = entry.getKey();
            String typeName = getNameForId(typeId);
            CustomMetadataDef typeDef = entry.getValue();
            List<AttributeDef> attributeDefs = typeDef.getAttributeDefs();
            List<AttributeDef> toInclude;
            if (includeDeleted) {
                toInclude = attributeDefs;
            } else {
                toInclude = new ArrayList<>();
                for (AttributeDef attributeDef : attributeDefs) {
                    if (!attributeDef.isArchived()) {
                        toInclude.add(attributeDef);
                    }
                }
            }
            map.put(typeName, toInclude);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * Translate the provided human-readable custom metadata set and attribute names to the Atlan-internal ID string
     * for the attribute.
     *
     * @param setName human-readable name of the custom metadata set
     * @param attributeName human-readable name of the attribute
     * @return Atlan-internal ID string for the attribute
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     * @throws NotFoundException if the custom metadata cannot be found (does not exist) in Atlan
     * @throws InvalidRequestException if no name was provided for the custom metadata to retrieve
     */
    public String getAttrIdForName(String setName, String attributeName) throws AtlanException {
        String setId = getIdForName(setName);
        return getAttrIdForNameFromSetId(setId, attributeName);
    }

    /**
     * Retrieve a single custom attribute name to include on search results.
     *
     * @param setName human-readable name of the custom metadata set for which to retrieve the custom metadata attribute name
     * @param attributeName human-readable name of the attribute
     * @return the attribute name, strictly useful for inclusion in search results
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     * @throws NotFoundException if the custom metadata cannot be found (does not exist) in Atlan
     * @throws InvalidRequestException if no name was provided for the custom metadata to retrieve
     * @see com.atlan.model.search.IndexSearchRequest.IndexSearchRequestBuilder#attributes(Collection)
     */
    public String getAttributeForSearchResults(String setName, String attributeName) throws AtlanException {
        String setId = getIdForName(setName);
        String attrId = _getAttributeForSearchResults(setId, attributeName);
        if (attrId == null) {
            // If we've not found any names, refresh the cache and look again (could be stale)
            refreshCache();
            attrId = _getAttributeForSearchResults(setId, attributeName);
        }
        return attrId;
    }

    /**
     * Retrieve the full set of custom attributes to include on search results.
     *
     * @param setName human-readable name of the custom metadata set for which to retrieve a set of attribute names
     * @return a set of the attribute names, strictly useful for inclusion in search results
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     * @throws NotFoundException if the custom metadata cannot be found (does not exist) in Atlan
     * @throws InvalidRequestException if no name was provided for the custom metadata to retrieve
     * @see com.atlan.model.search.IndexSearchRequest.IndexSearchRequestBuilder#attributes(Collection)
     */
    public Set<String> getAttributesForSearchResults(String setName) throws AtlanException {
        String setId = getIdForName(setName);
        Set<String> dotNames = _getAttributesForSearchResults(setId);
        if (dotNames == null) {
            // If we've not found any names, refresh the cache and look again (could be stale)
            refreshCache();
            dotNames = _getAttributesForSearchResults(setId);
        }
        return dotNames == null ? Collections.emptySet() : Collections.unmodifiableSet(dotNames);
    }

    private Set<String> _getAttributesForSearchResults(String setId) {
        Map<String, String> subMap = mapAttrNameToId.get(setId);
        if (subMap != null) {
            Collection<String> attrIds = subMap.values();
            Set<String> dotNames = new HashSet<>();
            for (String attrId : attrIds) {
                dotNames.add(setId + "." + attrId);
            }
            return dotNames;
        }
        return null;
    }

    private String _getAttributeForSearchResults(String setId, String attrName) {
        Map<String, String> subMap = mapAttrNameToId.get(setId);
        if (subMap != null) {
            return subMap.get(attrName);
        }
        return null;
    }

    /**
     * Retrieve the full custom metadata structure definition.
     *
     * @param setName human-readable name of the custom metadata set
     * @return the full custom metadata structure definition for that set
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     * @throws NotFoundException if the custom metadata cannot be found (does not exist) in Atlan
     * @throws InvalidRequestException if no name was provided for the custom metadata to retrieve
     */
    public CustomMetadataDef getCustomMetadataDef(String setName) throws AtlanException {
        String setId = getIdForName(setName);
        return cacheById.get(setId);
    }

    /**
     * Retrieve a specific custom metadata attribute definition by its unique Atlan-internal ID string.
     *
     * @param attributeId Atlan-internal ID string for the custom metadata attribute
     * @return attribute definition for the custom metadata attribute
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public AttributeDef getAttributeDef(String attributeId) throws AtlanException {
        if (attributeId == null || attributeId.isEmpty()) {
            throw new InvalidRequestException(ErrorCode.MISSING_CM_ATTR_ID);
        }
        if (attrCacheById.isEmpty()) {
            refreshCache();
        }
        return attrCacheById.get(attributeId);
    }

    /**
     * Translate the provided human-readable custom metadata attribute name to the Atlan-internal ID string.
     *
     * @param setId Atlan-internal ID string for the custom metadata set
     * @param attributeName human-readable name of the attribute
     * @return Atlan-internal ID string for the attribute
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     * @throws NotFoundException if the custom metadata property cannot be found (does not exist) in Atlan
     * @throws InvalidRequestException if no name was provided for the custom metadata property to retrieve
     */
    private String getAttrIdForNameFromSetId(String setId, String attributeName) throws AtlanException {
        if (setId != null && !setId.isEmpty()) {
            Map<String, String> subMap = mapAttrNameToId.get(setId);
            if (attributeName != null && !attributeName.isEmpty()) {
                String attrId = null;
                if (subMap != null) {
                    attrId = subMap.get(attributeName);
                }
                if (attrId == null) {
                    // If not found, refresh the cache and look again (could be stale)
                    refreshCache();
                    subMap = mapAttrNameToId.get(setId);
                    if (subMap == null) {
                        throw new NotFoundException(ErrorCode.CM_NO_ATTRIBUTES, setId);
                    }
                } else {
                    return attrId;
                }
                attrId = subMap.get(attributeName);
                if (attrId == null) {
                    throw new NotFoundException(ErrorCode.CM_ATTR_NOT_FOUND_BY_NAME, attributeName, setId);
                }
                return attrId;
            } else {
                throw new InvalidRequestException(ErrorCode.MISSING_CM_ATTR_NAME);
            }
        } else {
            throw new InvalidRequestException(ErrorCode.MISSING_CM_ID);
        }
    }

    /**
     * Translate the provided Atlan-internal ID for a custom metadata attribute to the human-readable attribute name.
     *
     * @param setId Atlan-internal ID string for the custom metadata set
     * @param attributeId Atlan-internal ID string for the attribute
     * @return human-readable name of the attribute
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     * @throws NotFoundException if the custom metadata property cannot be found (does not exist) in Atlan
     * @throws InvalidRequestException if no ID was provided for the custom metadata property to retrieve
     */
    private String getAttrNameForIdFromSetId(String setId, String attributeId) throws AtlanException {
        if (setId != null && !setId.isEmpty()) {
            Map<String, String> subMap = mapAttrIdToName.get(setId);
            if (attributeId != null && !attributeId.isEmpty()) {
                String attrName = null;
                if (subMap != null) {
                    attrName = subMap.get(attributeId);
                }
                if (attrName == null) {
                    // If not found, refresh the cache and look again (could be stale)
                    refreshCache();
                    subMap = mapAttrIdToName.get(setId);
                    if (subMap == null) {
                        throw new NotFoundException(ErrorCode.CM_NO_ATTRIBUTES, setId);
                    }
                } else {
                    return attrName;
                }
                attrName = subMap.get(attributeId);
                if (attrName == null) {
                    throw new NotFoundException(ErrorCode.CM_ATTR_NOT_FOUND_BY_ID, attributeId, setId);
                }
                return attrName;
            } else {
                throw new InvalidRequestException(ErrorCode.MISSING_CM_ATTR_ID);
            }
        } else {
            throw new InvalidRequestException(ErrorCode.MISSING_CM_ID);
        }
    }

    /**
     * Construct a full set of attributes for the given custom metadata, but where all the values are null.
     *
     * @param customMetadataName for which to construct the empty map
     * @return a map from custom metadata attribute name (human-readable) to null values
     * @throws AtlanException on any API issues
     */
    public Map<String, Object> getEmptyAttributes(String customMetadataName) throws AtlanException {
        String cmId = getIdForName(customMetadataName);
        Map<String, String> attributes = mapAttrNameToId.get(cmId);
        Map<String, Object> empty = new LinkedHashMap<>();
        for (String attrName : attributes.keySet()) {
            empty.put(attrName, Removable.NULL);
        }
        return empty;
    }

    /**
     * Translate the provided custom metadata object into a business attributes object.
     * We receive the businessAttributes object (rather than creating a new one) to initialize it with
     * any existing business attributes.
     *
     * @param customMetadata custom metadata object
     * @param businessAttributes business attributes object, which will be changed
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public void getBusinessAttributesFromCustomMetadata(
            Map<String, CustomMetadataAttributes> customMetadata, Map<String, Map<String, Object>> businessAttributes)
            throws AtlanException {
        if (customMetadata != null) {
            for (Map.Entry<String, CustomMetadataAttributes> entry : customMetadata.entrySet()) {
                String cmName = entry.getKey();
                String cmId = getIdForName(cmName);
                CustomMetadataAttributes attrs = entry.getValue();
                Map<String, Object> bmAttrs = businessAttributes.getOrDefault(cmId, new LinkedHashMap<>());
                getAttributesFromCustomMetadata(cmId, cmName, attrs, bmAttrs);
                businessAttributes.put(cmId, bmAttrs);
            }
        }
    }

    /**
     * Translate the provided custom metadata attributes object into a hashed-string ID map of attributes and values.
     * We receive the attributes object (rather than creating a new one) to initialize it with any existing attributes.
     *
     * @param cmId hashed-string ID of the custom metadata set (structure)
     * @param cmName human-readable name of the custom metadata set (structure)
     * @param cma custom metadata attributes in human-readable form
     * @param attributes map of custom metadata attributes keyed by hashed-string ID of the attribute
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public void getAttributesFromCustomMetadata(
            String cmId, String cmName, CustomMetadataAttributes cma, Map<String, Object> attributes)
            throws AtlanException {
        // Start by placing in any custom metadata for archived attributes
        if (cma.getArchivedAttributes() != null) {
            for (Map.Entry<String, Object> archived :
                    cma.getArchivedAttributes().entrySet()) {
                String archivedAttrName = archived.getKey();
                String archivedAttrId = getAttrIdForNameFromSetId(cmId, archivedAttrName);
                attributes.put(archivedAttrId, archived.getValue());
            }
        }
        // Then layer on top all the active custom metadata attributes
        getIdMapFromNameMap(cmName, cma.getAttributes(), attributes);
    }

    /**
     * Translate the provided map keyed by human-readable attribute name into a map of keyed by attribute id.
     * We receive the idToValue map (rather than creating a new one) to initialize it with
     * any existing business attributes.
     *
     * @param customMetadataName human-readable name of the custom metadata
     * @param nameToValue the attributes and their values for the custom metadata
     * @param idToValue the business metadata to map into
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public void getIdMapFromNameMap(
            String customMetadataName, Map<String, Object> nameToValue, Map<String, Object> idToValue)
            throws AtlanException {
        String cmId = getIdForName(customMetadataName);
        for (Map.Entry<String, Object> entry : nameToValue.entrySet()) {
            String attrName = entry.getKey();
            String cmAttrId = getAttrIdForNameFromSetId(cmId, attrName);
            idToValue.put(cmAttrId, entry.getValue());
        }
    }

    /**
     * Translate the provided business attributes object into a custom metadata object.
     *
     * @param businessAttributes business attributes object
     * @return custom metadata object
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public Map<String, CustomMetadataAttributes> getCustomMetadataFromBusinessAttributes(JsonNode businessAttributes)
            throws AtlanException {
        Map<String, CustomMetadataAttributes> map = new LinkedHashMap<>();
        Iterator<String> itrCM = businessAttributes.fieldNames();
        while (itrCM.hasNext()) {
            String cmId = itrCM.next();
            try {
                String cmName = getNameForId(cmId);
                JsonNode bmAttrs = businessAttributes.get(cmId);
                CustomMetadataAttributes cma = getCustomMetadataAttributes(cmId, bmAttrs);
                if (!cma.isEmpty()) {
                    map.put(cmName, cma);
                }
            } catch (NotFoundException e) {
                log.warn(
                        "Custom metadata with ID {} could not be found, likely deleted in parallel with this processing so it will be skipped.",
                        cmId,
                        e);
            }
        }
        return map;
    }

    /**
     * Translate the provided attributes structure into a human-readable map of attribute names to values.
     *
     * @param cmId custom metadata hashed-string ID
     * @param attributes embedded attributes structure with hashed-string IDs
     * @return deserialized CustomMetadataAttributes object
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public CustomMetadataAttributes getCustomMetadataAttributes(String cmId, JsonNode attributes)
            throws AtlanException {
        CustomMetadataAttributes.CustomMetadataAttributesBuilder<?, ?> builder = CustomMetadataAttributes.builder();
        Iterator<String> itrCMA = attributes.fieldNames();
        while (itrCMA.hasNext()) {
            String attrId = itrCMA.next();
            String cmAttrName = getAttrNameForIdFromSetId(cmId, attrId);
            JsonNode jsonValue = attributes.get(attrId);
            if (jsonValue.isArray()) {
                Set<Object> values = new HashSet<>();
                ArrayNode array = (ArrayNode) jsonValue;
                for (JsonNode element : array) {
                    Object primitive = deserializePrimitive(element);
                    values.add(primitive);
                }
                if (!values.isEmpty()) {
                    // It seems assets that previously had multivalued custom metadata that was later
                    // removed retain an empty set for that attribute, but this is equivalent to the
                    // custom metadata not existing from a UI and delete-ability perspective (so we will
                    // treat as non-existent in the deserialization as well)
                    if (archivedAttrIds.containsKey(attrId)) {
                        builder.archivedAttribute(cmAttrName, values);
                    } else {
                        builder.attribute(cmAttrName, values);
                    }
                }
            } else if (jsonValue.isValueNode()) {
                Object primitive = deserializePrimitive(jsonValue);
                if (archivedAttrIds.containsKey(attrId)) {
                    builder.archivedAttribute(cmAttrName, primitive);
                } else {
                    builder.attribute(cmAttrName, primitive);
                }
            } else {
                throw new LogicException(ErrorCode.UNABLE_TO_DESERIALIZE, jsonValue.toString());
            }
        }
        return builder.build();
    }

    /**
     * Translate the provided search result-embedded custom metadata into a custom metadata object.
     *
     * @param embeddedAttributes map of custom metadata that was embedded in search result attributes, keyed
     *                           by {@code <cmId>.<attrId>} with the value of that custom attribute
     * @return custom metadata object
     * @throws AtlanException on any API communication problem if the cache needs to be refreshed
     */
    public Map<String, CustomMetadataAttributes> getCustomMetadataFromSearchResult(
            Map<String, JsonNode> embeddedAttributes) throws AtlanException {

        Map<String, CustomMetadataAttributes> map = new LinkedHashMap<>();

        Map<String, CustomMetadataAttributes.CustomMetadataAttributesBuilder<?, ?>> builderMap = new LinkedHashMap<>();
        for (Map.Entry<String, JsonNode> entry : embeddedAttributes.entrySet()) {
            String compositeId = entry.getKey();
            int indexOfDot = compositeId.indexOf(".");
            if (indexOfDot > 0) {
                String cmId = compositeId.substring(0, indexOfDot);
                try {
                    String cmName = getNameForId(cmId);
                    if (!builderMap.containsKey(cmName)) {
                        builderMap.put(cmName, CustomMetadataAttributes.builder());
                    }
                    String attrId = compositeId.substring(indexOfDot + 1);
                    String cmAttrName = getAttrNameForIdFromSetId(cmId, attrId);
                    JsonNode jsonValue = entry.getValue();
                    if (jsonValue.isArray()) {
                        Set<Object> values = new HashSet<>();
                        ArrayNode array = (ArrayNode) jsonValue;
                        for (JsonNode element : array) {
                            Object primitive = deserializePrimitive(element);
                            values.add(primitive);
                        }
                        if (!values.isEmpty()) {
                            // It seems assets that previously had multivalued custom metadata that was later
                            // removed retain an empty set for that attribute, but this is equivalent to the
                            // custom metadata not existing from a UI and delete-ability perspective (so we will
                            // treat as non-existent in the deserialization as well)
                            if (archivedAttrIds.containsKey(attrId)) {
                                builderMap.get(cmName).archivedAttribute(cmAttrName, values);
                            } else {
                                builderMap.get(cmName).attribute(cmAttrName, values);
                            }
                        }
                    } else if (jsonValue.isValueNode()) {
                        Object primitive = deserializePrimitive(jsonValue);
                        if (archivedAttrIds.containsKey(attrId)) {
                            builderMap.get(cmName).archivedAttribute(cmAttrName, primitive);
                        } else {
                            builderMap.get(cmName).attribute(cmAttrName, primitive);
                        }
                    } else {
                        throw new LogicException(ErrorCode.UNABLE_TO_DESERIALIZE, jsonValue.toString());
                    }
                } catch (NotFoundException e) {
                    log.warn(
                            "Custom metadata with ID {} could not be found, likely deleted in parallel with this processing so it will be skipped.",
                            cmId,
                            e);
                }
            }
        }

        for (Map.Entry<String, CustomMetadataAttributes.CustomMetadataAttributesBuilder<?, ?>> entry :
                builderMap.entrySet()) {
            String cmName = entry.getKey();
            CustomMetadataAttributes cma = entry.getValue().build();
            if (!cma.isEmpty()) {
                map.put(cmName, cma);
            }
        }
        return map;
    }

    private static Object deserializePrimitive(JsonNode jsonValue) throws LogicException {
        if (jsonValue.isValueNode()) {
            if (jsonValue.isTextual()) {
                return jsonValue.asText();
            } else if (jsonValue.isBoolean()) {
                return jsonValue.asBoolean();
            } else if (jsonValue.isIntegralNumber()) {
                return jsonValue.asLong();
            } else if (jsonValue.isFloatingPointNumber()) {
                return jsonValue.asDouble();
            } else if (jsonValue.isNull()) {
                return null;
            } else {
                throw new LogicException(ErrorCode.UNABLE_TO_DESERIALIZE, jsonValue.toString());
            }
        } else {
            throw new LogicException(ErrorCode.UNABLE_TO_DESERIALIZE, jsonValue.toString());
        }
    }
}
