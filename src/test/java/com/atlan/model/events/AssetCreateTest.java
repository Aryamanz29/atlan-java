/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.events;

import static org.testng.Assert.*;

import com.atlan.Atlan;
import com.atlan.model.assets.Glossary;
import com.atlan.model.assets.GlossaryTerm;
import com.atlan.model.enums.*;
import java.io.IOException;
import org.testng.annotations.Test;

public class AssetCreateTest {

    private static final AtlanEvent full = AtlanEvent.builder()
            .msgSourceIP("msgSourceIP")
            .msgCreatedBy("msgCreatedBy")
            .msgCreationTime(123456789L)
            .payload(AssetCreatePayload.builder()
                    .asset(GlossaryTerm.builder()
                            .guid("guid1")
                            .qualifiedName("qualifiedName")
                            .anchor(Glossary.refByGuid("guid2"))
                            .build())
                    .build())
            .build();
    private static AtlanEvent frodo;
    private static String serialized;
    private static final int HASH = full.hashCode();

    @Test(groups = {"AssetCreate.builderEquivalency"})
    void builderEquivalency() {
        assertEquals(full.toBuilder().build(), full);
    }

    @Test(
            groups = {"AssetCreate.serialize"},
            dependsOnGroups = {"AssetCreate.builderEquivalency"})
    void serialization() {
        assertNotNull(full);
        serialized = full.toJson(Atlan.getDefaultClient());
        assertNotNull(serialized);
        assertEquals(full.hashCode(), HASH, "Object is mutated by serialization.");
    }

    @Test(
            groups = {"AssetCreate.deserialize"},
            dependsOnGroups = {"AssetCreate.serialize"})
    void deserialization() throws IOException {
        assertNotNull(serialized);
        frodo = Atlan.getDefaultClient().readValue(serialized, AtlanEvent.class);
        assertNotNull(frodo);
    }

    @Test(
            groups = {"AssetCreate.equivalency"},
            dependsOnGroups = {"AssetCreate.serialize", "AssetCreate.deserialize"})
    void serializedEquivalency() {
        assertNotNull(serialized);
        assertNotNull(frodo);
        String backAgain = frodo.toJson(Atlan.getDefaultClient());
        assertEquals(backAgain, serialized, "Serialization is not equivalent after serde loop,");
    }

    @Test(
            groups = {"AssetCreate.equivalency"},
            dependsOnGroups = {"AssetCreate.serialize", "AssetCreate.deserialize"})
    void deserializedEquivalency() {
        assertNotNull(full);
        assertNotNull(frodo);
        assertEquals(frodo, full, "Deserialization is not equivalent after serde loop,");
    }
}
