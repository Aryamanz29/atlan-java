/* SPDX-License-Identifier: Apache-2.0
   Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import static org.testng.Assert.*;

import com.atlan.Atlan;
import com.atlan.model.core.AtlanTag;
import com.atlan.model.core.CustomMetadataAttributes;
import com.atlan.model.enums.*;
import com.atlan.model.structs.*;
import java.io.IOException;
import java.util.*;
import javax.annotation.processing.Generated;
import org.testng.annotations.Test;

@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@SuppressWarnings("deprecation")
public class PowerBIPageTest {

    private static final PowerBIPage full = PowerBIPage._internal()
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
            .atlanTag(AtlanTag.of("String0"))
            .atlanTag(AtlanTag.builder().typeName("String1").propagate(false).build())
            .customMetadata(
                    "String0",
                    CustomMetadataAttributes.builder()
                            .attribute("String0", 123.456)
                            .attribute("String1", true)
                            .build())
            .customMetadata(
                    "String1",
                    CustomMetadataAttributes.builder()
                            // Note: for equivalency this MUST be a Long (not an Integer), as deserialization
                            // will always produce a Long
                            .attribute("String0", 789L)
                            .attribute("String1", "AnotherString")
                            .build())
            .powerBIEndorsement(PowerBIEndorsementType.PROMOTED)
            .powerBIFormatString("String0")
            .powerBIIsHidden(true)
            .powerBITableQualifiedName("String0")
            .inputToAirflowTask(AirflowTask.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .inputToAirflowTask(AirflowTask.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .inputToProcess(LineageProcess.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .inputToProcess(LineageProcess.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .outputFromAirflowTask(AirflowTask.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .outputFromAirflowTask(AirflowTask.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .outputFromProcess(LineageProcess.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .outputFromProcess(LineageProcess.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .adminGroup("String0")
            .adminGroup("String1")
            .adminRole("String0")
            .adminRole("String1")
            .adminUser("String0")
            .adminUser("String1")
            .announcementMessage("String0")
            .announcementTitle("String0")
            .announcementType(AtlanAnnouncementType.INFORMATION)
            .announcementUpdatedAt(123456789L)
            .announcementUpdatedBy("String0")
            .assetCoverImage("String0")
            .assetDbtAccountName("String0")
            .assetDbtAlias("String0")
            .assetDbtEnvironmentDbtVersion("String0")
            .assetDbtEnvironmentName("String0")
            .assetDbtJobLastRun(123456789L)
            .assetDbtJobLastRunArtifactS3Path("String0")
            .assetDbtJobLastRunArtifactsSaved(true)
            .assetDbtJobLastRunCreatedAt(123456789L)
            .assetDbtJobLastRunDequedAt(123456789L)
            .assetDbtJobLastRunExecutedByThreadId("String0")
            .assetDbtJobLastRunGitBranch("String0")
            .assetDbtJobLastRunGitSha("String0")
            .assetDbtJobLastRunHasDocsGenerated(true)
            .assetDbtJobLastRunHasSourcesGenerated(true)
            .assetDbtJobLastRunNotificationsSent(true)
            .assetDbtJobLastRunOwnerThreadId("String0")
            .assetDbtJobLastRunQueuedDuration("String0")
            .assetDbtJobLastRunQueuedDurationHumanized("String0")
            .assetDbtJobLastRunRunDuration("String0")
            .assetDbtJobLastRunRunDurationHumanized("String0")
            .assetDbtJobLastRunStartedAt(123456789L)
            .assetDbtJobLastRunStatusMessage("String0")
            .assetDbtJobLastRunTotalDuration("String0")
            .assetDbtJobLastRunTotalDurationHumanized("String0")
            .assetDbtJobLastRunUpdatedAt(123456789L)
            .assetDbtJobLastRunUrl("String0")
            .assetDbtJobName("String0")
            .assetDbtJobNextRun(123456789L)
            .assetDbtJobNextRunHumanized("String0")
            .assetDbtJobSchedule("String0")
            .assetDbtJobScheduleCronHumanized("String0")
            .assetDbtJobStatus("String0")
            .assetDbtMeta("String0")
            .assetDbtPackageName("String0")
            .assetDbtProjectName("String0")
            .assetDbtSemanticLayerProxyUrl("String0")
            .assetDbtSourceFreshnessCriteria("String0")
            .assetDbtTag("String0")
            .assetDbtTag("String1")
            .assetDbtTestStatus("String0")
            .assetDbtUniqueId("String0")
            .assetIcon(AtlanIcon.ATLAN_TAG)
            .assetMcIncidentName("String0")
            .assetMcIncidentName("String1")
            .assetMcIncidentQualifiedName("String0")
            .assetMcIncidentQualifiedName("String1")
            .assetMcIncidentSeverity("String0")
            .assetMcIncidentSeverity("String1")
            .assetMcIncidentState("String0")
            .assetMcIncidentState("String1")
            .assetMcIncidentSubType("String0")
            .assetMcIncidentSubType("String1")
            .assetMcIncidentType("String0")
            .assetMcIncidentType("String1")
            .assetMcLastSyncRunAt(123456789L)
            .assetMcMonitorName("String0")
            .assetMcMonitorName("String1")
            .assetMcMonitorQualifiedName("String0")
            .assetMcMonitorQualifiedName("String1")
            .assetMcMonitorScheduleType("String0")
            .assetMcMonitorScheduleType("String1")
            .assetMcMonitorStatus("String0")
            .assetMcMonitorStatus("String1")
            .assetMcMonitorType("String0")
            .assetMcMonitorType("String1")
            .assetSodaCheckCount(123456789L)
            .assetSodaCheckStatuses("String0")
            .assetSodaDQStatus("String0")
            .assetSodaLastScanAt(123456789L)
            .assetSodaLastSyncRunAt(123456789L)
            .assetSodaSourceURL("String0")
            .assetTag("String0")
            .assetTag("String1")
            .assignedTerm(GlossaryTerm.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .assignedTerm(GlossaryTerm.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .certificateStatus(CertificateStatus.DEPRECATED)
            .certificateStatusMessage("String0")
            .certificateUpdatedAt(123456789L)
            .certificateUpdatedBy("String0")
            .connectionName("String0")
            .connectionQualifiedName("String0")
            .connectorType(AtlanConnectorType.SNOWFLAKE)
            .dbtQualifiedName("String0")
            .description("String0")
            .displayName("String0")
            .file(File.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .file(File.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .hasLineage(true)
            .isAIGenerated(true)
            .isDiscoverable(true)
            .isEditable(true)
            .isPartial(true)
            .lastRowChangedAt(123456789L)
            .lastSyncRun("String0")
            .lastSyncRunAt(123456789L)
            .lastSyncWorkflowName("String0")
            .link(Link.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .link(Link.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .mcIncident(MCIncident.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .mcIncident(MCIncident.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .mcMonitor(MCMonitor.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .mcMonitor(MCMonitor.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .metric(DbtMetric.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .metric(DbtMetric.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .name("String0")
            .outputPortDataProduct(DataProduct.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .outputPortDataProduct(DataProduct.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .ownerGroup("String0")
            .ownerGroup("String1")
            .ownerUser("String0")
            .ownerUser("String1")
            .popularityScore(123.456)
            .readme(Readme.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .sampleDataUrl("String0")
            .schemaRegistrySubject(SchemaRegistrySubject.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .schemaRegistrySubject(
                    SchemaRegistrySubject.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .sodaCheck(SodaCheck.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .sodaCheck(SodaCheck.refByQualifiedName("default/snowflake/1234567890/test/qualifiedName"))
            .sourceCostUnit(SourceCostUnitType.CREDITS)
            .sourceCreatedAt(123456789L)
            .sourceCreatedBy("String0")
            .sourceEmbedURL("String0")
            .sourceLastReadAt(123456789L)
            .sourceOwners("String0")
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
            .sourceQueryComputeCost("String0")
            .sourceQueryComputeCost("String1")
            .sourceReadCount(123456789L)
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
            .sourceReadQueryCost(123.456)
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
            .sourceReadRecentUser("String0")
            .sourceReadRecentUser("String1")
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
            .sourceReadTopUser("String0")
            .sourceReadTopUser("String1")
            .sourceReadUserCount(123456789L)
            .sourceTotalCost(123.456)
            .sourceURL("String0")
            .sourceUpdatedAt(123456789L)
            .sourceUpdatedBy("String0")
            .addStarredBy("String0")
            .addStarredBy("String1")
            .starredCount(123)
            .starredDetail(StarredDetails.builder()
                    .assetStarredBy("String0")
                    .assetStarredAt(123456789L)
                    .build())
            .starredDetail(StarredDetails.builder()
                    .assetStarredBy("String1")
                    .assetStarredAt(987654321L)
                    .build())
            .subType("String0")
            .tenantId("String0")
            .userDescription("String0")
            .viewScore(123.456)
            .viewerGroup("String0")
            .viewerGroup("String1")
            .viewerUser("String0")
            .viewerUser("String1")
            .report(PowerBIReport.refByGuid("705d96f4-bdb6-4792-8dfe-8dc4ca3d2c23"))
            .reportQualifiedName("String0")
            .workspaceQualifiedName("String0")
            .build();

    private static final int hash = full.hashCode();
    private static PowerBIPage frodo;
    private static String serialized;

    @Test(groups = {"PowerBIPage.builderEquivalency"})
    void builderEquivalency() {
        assertEquals(full.toBuilder().build(), full);
    }

    @Test(
            groups = {"PowerBIPage.serialize"},
            dependsOnGroups = {"PowerBIPage.builderEquivalency"})
    void serialization() {
        assertNotNull(full);
        serialized = full.toJson(Atlan.getDefaultClient());
        assertNotNull(serialized);
        assertEquals(full.hashCode(), hash, "Serialization mutated the original value,");
    }

    @Test(
            groups = {"PowerBIPage.deserialize"},
            dependsOnGroups = {"PowerBIPage.serialize"})
    void deserialization() throws IOException {
        assertNotNull(serialized);
        frodo = Atlan.getDefaultClient().readValue(serialized, PowerBIPage.class);
        assertNotNull(frodo);
    }

    @Test(
            groups = {"PowerBIPage.equivalency"},
            dependsOnGroups = {"PowerBIPage.serialize", "PowerBIPage.deserialize"})
    void serializedEquivalency() {
        assertNotNull(serialized);
        assertNotNull(frodo);
        String backAgain = frodo.toJson(Atlan.getDefaultClient());
        assertEquals(backAgain, serialized, "Serialization is not equivalent after serde loop,");
    }

    @Test(
            groups = {"PowerBIPage.equivalency"},
            dependsOnGroups = {"PowerBIPage.serialize", "PowerBIPage.deserialize"})
    void deserializedEquivalency() {
        assertNotNull(full);
        assertNotNull(frodo);
        assertEquals(frodo, full, "Deserialization is not equivalent after serde loop,");
    }
}
