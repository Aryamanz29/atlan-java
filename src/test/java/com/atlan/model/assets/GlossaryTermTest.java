/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import static org.testng.Assert.*;

import com.atlan.model.enums.*;
import com.atlan.model.structs.*;
import com.atlan.serde.Serde;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import org.testng.annotations.Test;

@SuppressWarnings("deprecation")
public class GlossaryTermTest {

    private static final GlossaryTerm full = GlossaryTerm.builder()
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
            .name("String0")
            .displayName("String0")
            .description("String0")
            .userDescription("String0")
            .tenantId("String0")
            .certificateStatus(CertificateStatus.DEPRECATED)
            .certificateStatusMessage("String0")
            .certificateUpdatedBy("String0")
            .certificateUpdatedAt(123456789L)
            .announcementTitle("String0")
            .announcementMessage("String0")
            .announcementType(AtlanAnnouncementType.INFORMATION)
            .announcementUpdatedAt(123456789L)
            .announcementUpdatedBy("String0")
            .ownerUser("String0")
            .ownerUser("String1")
            .ownerGroup("String0")
            .ownerGroup("String1")
            .adminUser("String0")
            .adminUser("String1")
            .adminGroup("String0")
            .adminGroup("String1")
            .viewerUser("String0")
            .viewerUser("String1")
            .viewerGroup("String0")
            .viewerGroup("String1")
            .connectorType(AtlanConnectorType.SNOWFLAKE)
            .connectionName("String0")
            .connectionQualifiedName("String0")
            .hasLineage(true)
            .isDiscoverable(true)
            .isEditable(true)
            .subType("String0")
            .viewScore(123.456)
            .popularityScore(123.456)
            .sourceOwners("String0")
            .sourceCreatedBy("String0")
            .sourceCreatedAt(123456789L)
            .sourceUpdatedAt(123456789L)
            .sourceUpdatedBy("String0")
            .sourceURL("String0")
            .sourceEmbedURL("String0")
            .lastSyncWorkflowName("String0")
            .lastSyncRunAt(123456789L)
            .lastSyncRun("String0")
            .adminRole("String0")
            .adminRole("String1")
            .sourceReadCount(123456789L)
            .sourceReadUserCount(123456789L)
            .sourceLastReadAt(123456789L)
            .lastRowChangedAt(123456789L)
            .sourceTotalCost(123.456)
            .sourceCostUnit(SourceCostUnitType.CREDITS)
            .sourceReadRecentUser("String0")
            .sourceReadRecentUser("String1")
            .sourceReadRecentUserRecord(PopularityInsights.builder()
                    .recordUser("String0")
                    .recordQuery("String0")
                    .recordQueryDuration(123456789L)
                    .recordQueryCount(123456789L)
                    .recordTotalUserCount(123456789L)
                    .recordComputeCost(123.456)
                    .recordMaxComputeCost(123.456)
                    .recordComputeCostUnit(SourceCostUnitType.CREDITS)
                    .recordLastTimestamp(123456789L)
                    .recordWarehouse("String0")
                    .build())
            .sourceReadRecentUserRecord(PopularityInsights.builder()
                    .recordUser("String1")
                    .recordQuery("String1")
                    .recordQueryDuration(987654321L)
                    .recordQueryCount(987654321L)
                    .recordTotalUserCount(987654321L)
                    .recordComputeCost(654.321)
                    .recordMaxComputeCost(654.321)
                    .recordComputeCostUnit(SourceCostUnitType.BYTES)
                    .recordLastTimestamp(987654321L)
                    .recordWarehouse("String1")
                    .build())
            .sourceReadTopUser("String0")
            .sourceReadTopUser("String1")
            .sourceReadTopUserRecord(PopularityInsights.builder()
                    .recordUser("String0")
                    .recordQuery("String0")
                    .recordQueryDuration(123456789L)
                    .recordQueryCount(123456789L)
                    .recordTotalUserCount(123456789L)
                    .recordComputeCost(123.456)
                    .recordMaxComputeCost(123.456)
                    .recordComputeCostUnit(SourceCostUnitType.CREDITS)
                    .recordLastTimestamp(123456789L)
                    .recordWarehouse("String0")
                    .build())
            .sourceReadTopUserRecord(PopularityInsights.builder()
                    .recordUser("String1")
                    .recordQuery("String1")
                    .recordQueryDuration(987654321L)
                    .recordQueryCount(987654321L)
                    .recordTotalUserCount(987654321L)
                    .recordComputeCost(654.321)
                    .recordMaxComputeCost(654.321)
                    .recordComputeCostUnit(SourceCostUnitType.BYTES)
                    .recordLastTimestamp(987654321L)
                    .recordWarehouse("String1")
                    .build())
            .sourceReadPopularQueryRecord(PopularityInsights.builder()
                    .recordUser("String0")
                    .recordQuery("String0")
                    .recordQueryDuration(123456789L)
                    .recordQueryCount(123456789L)
                    .recordTotalUserCount(123456789L)
                    .recordComputeCost(123.456)
                    .recordMaxComputeCost(123.456)
                    .recordComputeCostUnit(SourceCostUnitType.CREDITS)
                    .recordLastTimestamp(123456789L)
                    .recordWarehouse("String0")
                    .build())
            .sourceReadPopularQueryRecord(PopularityInsights.builder()
                    .recordUser("String1")
                    .recordQuery("String1")
                    .recordQueryDuration(987654321L)
                    .recordQueryCount(987654321L)
                    .recordTotalUserCount(987654321L)
                    .recordComputeCost(654.321)
                    .recordMaxComputeCost(654.321)
                    .recordComputeCostUnit(SourceCostUnitType.BYTES)
                    .recordLastTimestamp(987654321L)
                    .recordWarehouse("String1")
                    .build())
            .sourceReadExpensiveQueryRecord(PopularityInsights.builder()
                    .recordUser("String0")
                    .recordQuery("String0")
                    .recordQueryDuration(123456789L)
                    .recordQueryCount(123456789L)
                    .recordTotalUserCount(123456789L)
                    .recordComputeCost(123.456)
                    .recordMaxComputeCost(123.456)
                    .recordComputeCostUnit(SourceCostUnitType.CREDITS)
                    .recordLastTimestamp(123456789L)
                    .recordWarehouse("String0")
                    .build())
            .sourceReadExpensiveQueryRecord(PopularityInsights.builder()
                    .recordUser("String1")
                    .recordQuery("String1")
                    .recordQueryDuration(987654321L)
                    .recordQueryCount(987654321L)
                    .recordTotalUserCount(987654321L)
                    .recordComputeCost(654.321)
                    .recordMaxComputeCost(654.321)
                    .recordComputeCostUnit(SourceCostUnitType.BYTES)
                    .recordLastTimestamp(987654321L)
                    .recordWarehouse("String1")
                    .build())
            .sourceReadSlowQueryRecord(PopularityInsights.builder()
                    .recordUser("String0")
                    .recordQuery("String0")
                    .recordQueryDuration(123456789L)
                    .recordQueryCount(123456789L)
                    .recordTotalUserCount(123456789L)
                    .recordComputeCost(123.456)
                    .recordMaxComputeCost(123.456)
                    .recordComputeCostUnit(SourceCostUnitType.CREDITS)
                    .recordLastTimestamp(123456789L)
                    .recordWarehouse("String0")
                    .build())
            .sourceReadSlowQueryRecord(PopularityInsights.builder()
                    .recordUser("String1")
                    .recordQuery("String1")
                    .recordQueryDuration(987654321L)
                    .recordQueryCount(987654321L)
                    .recordTotalUserCount(987654321L)
                    .recordComputeCost(654.321)
                    .recordMaxComputeCost(654.321)
                    .recordComputeCostUnit(SourceCostUnitType.BYTES)
                    .recordLastTimestamp(987654321L)
                    .recordWarehouse("String1")
                    .build())
            .sourceQueryComputeCost("String0")
            .sourceQueryComputeCost("String1")
            .sourceQueryComputeCostRecord(PopularityInsights.builder()
                    .recordUser("String0")
                    .recordQuery("String0")
                    .recordQueryDuration(123456789L)
                    .recordQueryCount(123456789L)
                    .recordTotalUserCount(123456789L)
                    .recordComputeCost(123.456)
                    .recordMaxComputeCost(123.456)
                    .recordComputeCostUnit(SourceCostUnitType.CREDITS)
                    .recordLastTimestamp(123456789L)
                    .recordWarehouse("String0")
                    .build())
            .sourceQueryComputeCostRecord(PopularityInsights.builder()
                    .recordUser("String1")
                    .recordQuery("String1")
                    .recordQueryDuration(987654321L)
                    .recordQueryCount(987654321L)
                    .recordTotalUserCount(987654321L)
                    .recordComputeCost(654.321)
                    .recordMaxComputeCost(654.321)
                    .recordComputeCostUnit(SourceCostUnitType.BYTES)
                    .recordLastTimestamp(987654321L)
                    .recordWarehouse("String1")
                    .build())
            .dbtQualifiedName("String0")
            .assetDbtAlias("String0")
            .assetDbtMeta("String0")
            .assetDbtUniqueId("String0")
            .assetDbtAccountName("String0")
            .assetDbtProjectName("String0")
            .assetDbtPackageName("String0")
            .assetDbtJobName("String0")
            .assetDbtJobSchedule("String0")
            .assetDbtJobStatus("String0")
            .assetDbtJobScheduleCronHumanized("String0")
            .assetDbtJobLastRun(123456789L)
            .assetDbtJobLastRunUrl("String0")
            .assetDbtJobLastRunCreatedAt(123456789L)
            .assetDbtJobLastRunUpdatedAt(123456789L)
            .assetDbtJobLastRunDequedAt(123456789L)
            .assetDbtJobLastRunStartedAt(123456789L)
            .assetDbtJobLastRunTotalDuration("String0")
            .assetDbtJobLastRunTotalDurationHumanized("String0")
            .assetDbtJobLastRunQueuedDuration("String0")
            .assetDbtJobLastRunQueuedDurationHumanized("String0")
            .assetDbtJobLastRunRunDuration("String0")
            .assetDbtJobLastRunRunDurationHumanized("String0")
            .assetDbtJobLastRunGitBranch("String0")
            .assetDbtJobLastRunGitSha("String0")
            .assetDbtJobLastRunStatusMessage("String0")
            .assetDbtJobLastRunOwnerThreadId("String0")
            .assetDbtJobLastRunExecutedByThreadId("String0")
            .assetDbtJobLastRunArtifactsSaved(true)
            .assetDbtJobLastRunArtifactS3Path("String0")
            .assetDbtJobLastRunHasDocsGenerated(true)
            .assetDbtJobLastRunHasSourcesGenerated(true)
            .assetDbtJobLastRunNotificationsSent(true)
            .assetDbtJobNextRun(123456789L)
            .assetDbtJobNextRunHumanized("String0")
            .assetDbtEnvironmentName("String0")
            .assetDbtEnvironmentDbtVersion("String0")
            .assetDbtTag("String0")
            .assetDbtTag("String1")
            .assetDbtSemanticLayerProxyUrl("String0")
            .assetDbtSourceFreshnessCriteria("String0")
            .sampleDataUrl("String0")
            .assetTag("String0")
            .assetTag("String1")
            .link(Link.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .link(Link.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .metric(DbtMetric.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .metric(DbtMetric.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .readme(Readme.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .assignedTerm(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .assignedTerm(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .shortDescription("String0")
            .longDescription("String0")
            .example("String0")
            .example("String1")
            .abbreviation("String0")
            .usage("String0")
            .additionalAttribute("key1", "value1")
            .additionalAttribute("key2", "value2")
            .translationTerm(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .translationTerm(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .validValueFor(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .validValueFor(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .synonym(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .synonym(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .replacedByTerm(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .replacedByTerm(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .validValue(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .validValue(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .replacementTerm(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .replacementTerm(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .seeAlsoOne(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .seeAlsoOne(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .translatedTerm(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .translatedTerm(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .isATerm(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .isATerm(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .anchor(Glossary.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .antonym(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .antonym(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .assignedEntity(Connection.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .assignedEntity(Connection.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .category(GlossaryCategory.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .category(GlossaryCategory.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .classify(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .classify(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .preferredToTerm(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .preferredToTerm(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .preferredTerm(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .preferredTerm(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .build();

    private static final int hash = full.hashCode();
    private static GlossaryTerm frodo;
    private static String serialized;

    @Test(groups = {"GlossaryTerm.builderEquivalency"})
    void builderEquivalency() {
        assertEquals(full.toBuilder().build(), full);
    }

    @Test(
            groups = {"GlossaryTerm.serialize"},
            dependsOnGroups = {"GlossaryTerm.builderEquivalency"})
    void serialization() {
        assertNotNull(full);
        serialized = full.toJson();
        assertNotNull(serialized);
        assertEquals(full.hashCode(), hash, "Serialization mutated the original value,");
    }

    @Test(
            groups = {"GlossaryTerm.deserialize"},
            dependsOnGroups = {"GlossaryTerm.serialize"})
    void deserialization() throws JsonProcessingException {
        assertNotNull(serialized);
        frodo = Serde.mapper.readValue(serialized, GlossaryTerm.class);
        assertNotNull(frodo);
    }

    @Test(
            groups = {"GlossaryTerm.equivalency"},
            dependsOnGroups = {"GlossaryTerm.serialize", "GlossaryTerm.deserialize"})
    void serializedEquivalency() {
        assertNotNull(serialized);
        assertNotNull(frodo);
        String backAgain = frodo.toJson();
        assertEquals(backAgain, serialized, "Serialization is not equivalent after serde loop,");
    }

    @Test(
            groups = {"GlossaryTerm.equivalency"},
            dependsOnGroups = {"GlossaryTerm.serialize", "GlossaryTerm.deserialize"})
    void deserializedEquivalency() {
        assertNotNull(full);
        assertNotNull(frodo);
        assertEquals(frodo, full, "Deserialization is not equivalent after serde loop,");
    }
}
