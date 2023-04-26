/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import static org.testng.Assert.*;

import com.atlan.model.enums.*;
import com.atlan.model.structs.AzureTag;
import com.atlan.serde.Serde;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import org.testng.annotations.Test;

public class ADLSObjectTest {

    private static final ADLSObject full = ADLSObject.builder()
            .guid("guid")
            .displayText("displayText")
            .status(AtlanStatus.ACTIVE)
            .createdBy("createdBy")
            .updatedBy("updatedBy")
            .createTime(123456789L)
            .updateTime(123456789L)
            .isIncomplete(false)
            .qualifiedName("qualifiedName")
            .name("name")
            .displayName("displayName")
            .description("description")
            .userDescription("userDescription")
            .tenantId("tenantId")
            .certificateStatus(CertificateStatus.VERIFIED)
            .certificateStatusMessage("certificateStatusMessage")
            .certificateUpdatedBy("certificateUpdatedBy")
            .certificateUpdatedAt(123456789L)
            .announcementTitle("announcementTitle")
            .announcementMessage("announcementMessage")
            .announcementUpdatedAt(123456789L)
            .announcementUpdatedBy("announcementUpdatedBy")
            .announcementType(AtlanAnnouncementType.INFORMATION)
            .ownerUser("ownerUser")
            .ownerGroup("ownerGroup")
            .adminUser("adminUser")
            .adminGroup("adminGroup")
            .adminRole("adminRole")
            .viewerUser("viewerUser")
            .viewerGroup("viewerGroup")
            .connectorType(AtlanConnectorType.PRESTO)
            .connectionName("connectionName")
            .connectionQualifiedName("connectionQualifiedName")
            .hasLineage(false)
            .isDiscoverable(true)
            .isEditable(true)
            .viewScore(123456.0)
            .popularityScore(123456.0)
            .sourceOwners("sourceOwners")
            .sourceURL("sourceURL")
            .sourceEmbedURL("sourceEmbedURL")
            .lastSyncWorkflowName("lastSyncWorkflowName")
            .lastSyncRunAt(123456789L)
            .lastSyncRun("lastSyncRun")
            .sourceCreatedBy("sourceCreatedBy")
            .sourceCreatedAt(123456789L)
            .sourceUpdatedAt(123456789L)
            .sourceUpdatedBy("sourceUpdatedBy")
            .dbtQualifiedName("dbtQualifiedName")
            .assetDbtAlias("assetDbtAlias")
            .assetDbtMeta("assetDbtMeta")
            .assetDbtUniqueId("assetDbtUniqueId")
            .assetDbtAccountName("assetDbtAccountName")
            .assetDbtProjectName("assetDbtProjectName")
            .assetDbtPackageName("assetDbtPackageName")
            .assetDbtJobName("assetDbtJobName")
            .assetDbtJobSchedule("assetDbtJobSchedule")
            .assetDbtJobStatus("assetDbtJobStatus")
            .assetDbtJobScheduleCronHumanized("assetDbtJobScheduleCronHumanized")
            .assetDbtJobLastRun(123456789L)
            .assetDbtJobLastRunUrl("assetDbtJobLastRunUrl")
            .assetDbtJobLastRunCreatedAt(123456789L)
            .assetDbtJobLastRunUpdatedAt(123456789L)
            .assetDbtJobLastRunDequedAt(123456789L)
            .assetDbtJobLastRunStartedAt(123456789L)
            .assetDbtJobLastRunTotalDuration("assetDbtJobLastRunTotalDuration")
            .assetDbtJobLastRunTotalDurationHumanized("assetDbtJobLastRunTotalDurationHumanized")
            .assetDbtJobLastRunQueuedDuration("assetDbtJobLastRunQueuedDuration")
            .assetDbtJobLastRunQueuedDurationHumanized("assetDbtJobLastRunQueuedDurationHumanized")
            .assetDbtJobLastRunRunDuration("assetDbtJobLastRunRunDuration")
            .assetDbtJobLastRunRunDurationHumanized("assetDbtJobLastRunRunDurationHumanized")
            .assetDbtJobLastRunGitBranch("assetDbtJobLastRunGitBranch")
            .assetDbtJobLastRunGitSha("assetDbtJobLastRunGitSha")
            .assetDbtJobLastRunStatusMessage("assetDbtJobLastRunStatusMessage")
            .assetDbtJobLastRunOwnerThreadId("assetDbtJobLastRunOwnerThreadId")
            .assetDbtJobLastRunExecutedByThreadId("assetDbtJobLastRunExecutedByThreadId")
            .assetDbtJobLastRunArtifactsSaved(true)
            .assetDbtJobLastRunArtifactS3Path("assetDbtJobLastRunArtifactS3Path")
            .assetDbtJobLastRunHasDocsGenerated(false)
            .assetDbtJobLastRunHasSourcesGenerated(true)
            .assetDbtJobLastRunNotificationsSent(false)
            .assetDbtJobNextRun(123456789L)
            .assetDbtJobNextRunHumanized("assetDbtJobNextRunHumanized")
            .assetDbtEnvironmentName("assetDbtEnvironmentName")
            .assetDbtEnvironmentDbtVersion("assetDbtEnvironmentDbtVersion")
            .assetDbtTag("assetDbtTag1")
            .assetDbtTag("assetDbtTag2")
            .assetDbtSemanticLayerProxyUrl("assetDbtSemanticLayerProxyUrl")
            .link(Link.refByGuid("linkGuid1"))
            .link(Link.refByGuid("linkGuid2"))
            .readme(Readme.refByGuid("readmeGuid"))
            .assignedTerm(GlossaryTerm.refByGuid("termGuid1"))
            .assignedTerm(GlossaryTerm.refByGuid("termGuid2"))
            .inputToProcesses(Set.of(
                    LineageProcess.refByGuid("5c066be5-2153-4a69-bb3a-93576920f8c7"),
                    LineageProcess.refByGuid("329e5318-a895-4a72-9b3b-660ca81e96fe")))
            .outputFromProcesses(Set.of(
                    LineageProcess.refByGuid("961a5322-de48-4501-9196-32e8033710b4"),
                    LineageProcess.refByGuid("f00bb525-d20a-4ca8-abfc-aced6f153713")))
            .azureResourceId("azureResourceId")
            .azureLocation("azureLocation")
            .adlsAccountSecondaryLocation("adlsAccountSecondaryLocation")
            .azureTag(AzureTag.of("key", "value"))
            .inputToProcesses(Set.of(
                    LineageProcess.refByGuid("01b615e1-63f7-4af3-9955-b6307bbec1ee"),
                    LineageProcess.refByGuid("b0ba234b-ab30-47ef-9106-b01dbbc8aa39")))
            .outputFromProcesses(Set.of(
                    LineageProcess.refByGuid("59b3617c-a3a4-41ce-8ed6-91c8bc653e6e"),
                    LineageProcess.refByGuid("25cd62c7-8120-4c6d-a1f0-d45c75efbe46")))
            .adlsObjectUrl("adlsObjectUrl")
            .adlsObjectVersionId("adlsObjectVersionId")
            .adlsObjectType(ADLSObjectType.APPEND_BLOB)
            .adlsObjectSize(-4522292454635227782L)
            .adlsObjectAccessTier(ADLSAccessTier.HOT)
            .adlsObjectAccessTierLastModifiedTime(3541758216269101356L)
            .adlsObjectArchiveStatus(ADLSObjectArchiveStatus.REHYDRATE_PENDING_TO_COOL)
            .adlsObjectServerEncrypted(false)
            .adlsObjectVersionLevelImmutabilitySupport(false)
            .adlsObjectCacheControl("adlsObjectCacheControl")
            .adlsObjectContentType("adlsObjectContentType")
            .adlsObjectContentMD5Hash("adlsObjectContentMD5Hash")
            .adlsObjectContentLanguage("adlsObjectContentLanguage")
            .adlsObjectLeaseStatus(ADLSLeaseStatus.LOCKED)
            .adlsObjectLeaseState(ADLSLeaseState.AVAILABLE)
            .adlsObjectMetadata(Map.of("key1", "value1", "key2", "value2"))
            .adlsContainerQualifiedName("adlsContainerQualifiedName")
            .adlsContainer(ADLSContainer.refByGuid("298a8fbb-9f37-4558-89f4-00ea92941c1d"))
            .build();
    private static ADLSObject frodo;
    private static String serialized;

    @Test(groups = {"ADLSObject.builderEquivalency"})
    void builderEquivalency() {
        assertEquals(full.toBuilder().build(), full);
    }

    @Test(
            groups = {"ADLSObject.serialize"},
            dependsOnGroups = {"ADLSObject.builderEquivalency"})
    void serialization() {
        assertNotNull(full);
        serialized = full.toJson();
        assertNotNull(serialized);
    }

    @Test(
            groups = {"ADLSObject.deserialize"},
            dependsOnGroups = {"ADLSObject.serialize"})
    void deserialization() throws JsonProcessingException {
        assertNotNull(serialized);
        frodo = Serde.mapper.readValue(serialized, ADLSObject.class);
        assertNotNull(frodo);
    }

    @Test(
            groups = {"ADLSObject.equivalency"},
            dependsOnGroups = {"ADLSObject.serialize", "ADLSObject.deserialize"})
    void serializedEquivalency() {
        assertNotNull(serialized);
        assertNotNull(frodo);
        String backAgain = frodo.toJson();
        assertEquals(backAgain, serialized, "Serialization is not equivalent after serde loop,");
    }

    @Test(
            groups = {"ADLSObject.equivalency"},
            dependsOnGroups = {"ADLSObject.serialize", "ADLSObject.deserialize"})
    void deserializedEquivalency() {
        assertNotNull(full);
        assertNotNull(frodo);
        assertEquals(frodo, full, "Deserialization is not equivalent after serde loop,");
    }
}
