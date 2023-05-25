/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022- Atlan Pte. Ltd. */
package com.atlan.model.assets;

import static org.testng.Assert.*;

import com.atlan.model.core.Classification;
import com.atlan.model.core.CustomMetadataAttributes;
import com.atlan.model.enums.*;
import com.atlan.model.structs.*;
import com.atlan.serde.Serde;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
public class ${className}Test {

    private static final ${className} full = ${className}.builder()
            .guid("guid")
            .displayText("displayText")
            .status(AtlanStatus.ACTIVE)
            .createdBy("createdBy")
            .updatedBy("updatedBy")
            .createTime(123456789L)
            .updateTime(123456789L)
            .isIncomplete(false)
            .deleteHandler("SOFT")
            .meaningNames(Set.of("meaningName1", "meaningName2"))
            .meanings(Set.of(
                Meaning.builder()
                    .termGuid("termGuid1")
                    .relationGuid("relationGuid1")
                    .displayText("displayText1")
                    .confidence(100)
                    .build(),
                Meaning.builder()
                    .termGuid("termGuid2")
                    .relationGuid("relationGuid2")
                    .displayText("displayText2")
                    .confidence(100)
                    .build()))
            .qualifiedName("qualifiedName")
            .classification(Classification.of("String0"))
            .classification(Classification.builder().typeName("String1").propagate(false).build())
            .customMetadata("String0", CustomMetadataAttributes.builder()
                    .attribute("String0", 123.456)
                    .attribute("String1", true)
                    .build())
            .customMetadata("String1", CustomMetadataAttributes.builder()
                // Note: for equivalency this MUST be a Long (not an Integer), as deserialization
                // will always produce a Long
                    .attribute("String0", 789L)
                    .attribute("String1", "AnotherString")
                    .build())
<#list testAttributes as testAttribute>
    <#list testAttribute.values as value>
            .${testAttribute.builderMethod}(${value})
    </#list>
</#list>
            .build();

    private static final int hash = full.hashCode();
    private static ${className} frodo;
    private static String serialized;

    @Test(groups = {"${className}.builderEquivalency"})
    void builderEquivalency() {
        assertEquals(full.toBuilder().build(), full);
    }

    @Test(
            groups = {"${className}.serialize"},
            dependsOnGroups = {"${className}.builderEquivalency"})
    void serialization() {
        assertNotNull(full);
        serialized = full.toJson();
        assertNotNull(serialized);
        assertEquals(full.hashCode(), hash, "Serialization mutated the original value,");
    }

    @Test(
            groups = {"${className}.deserialize"},
            dependsOnGroups = {"${className}.serialize"})
    void deserialization() throws JsonProcessingException {
        assertNotNull(serialized);
        frodo = Serde.mapper.readValue(serialized, ${className}.class);
        assertNotNull(frodo);
    }

    @Test(
            groups = {"${className}.equivalency"},
            dependsOnGroups = {"${className}.serialize", "${className}.deserialize"})
    void serializedEquivalency() {
        assertNotNull(serialized);
        assertNotNull(frodo);
        String backAgain = frodo.toJson();
        assertEquals(backAgain, serialized, "Serialization is not equivalent after serde loop,");
    }

    @Test(
            groups = {"${className}.equivalency"},
            dependsOnGroups = {"${className}.serialize", "${className}.deserialize"})
    void deserializedEquivalency() {
        assertNotNull(full);
        assertNotNull(frodo);
        assertEquals(frodo, full, "Deserialization is not equivalent after serde loop,");
    }
}