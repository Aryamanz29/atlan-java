package com.atlan.model;

import static org.testng.Assert.*;

import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanCertificateStatus;
import com.atlan.model.enums.AtlanStatus;
import com.atlan.model.relations.Reference;
import com.atlan.net.ApiResource;
import org.testng.annotations.Test;

public class S3BucketTest {

    private static final S3Bucket full = S3Bucket.builder()
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
            .certificateStatus(AtlanCertificateStatus.VERIFIED)
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
            .connectorName("connectorName")
            .connectionName("connectionName")
            .connectionQualifiedName("connectionQualifiedName")
            .__hasLineage(false)
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
            .link(Reference.to("Resource", "linkGuid1"))
            .link(Reference.to("Resource", "linkGuid2"))
            .readme(Reference.to("Readme", "readmeGuid"))
            .meaning(Reference.to(GlossaryTerm.TYPE_NAME, "termGuid1"))
            .meaning(Reference.to(GlossaryTerm.TYPE_NAME, "termGuid2"))
            .awsArn("awsArn")
            .awsPartition("awsPartition")
            .awsService("awsService")
            .awsRegion("awsRegion")
            .awsAccountId("awsAccountId")
            .awsResourceId("awsResourceId")
            .awsOwnerName("awsOwnerName")
            .awsOwnerId("awsOwnerId")
            .awsTag(AWSTag.of("awsTagKey1", "awsTagValue1"))
            .awsTag(AWSTag.of("awsTagKey2", "awsTagValue2"))
            .s3ETag("s3ETag")
            .s3Encryption("s3Encryption")
            .s3ObjectCount(123456L)
            .s3BucketVersioningEnabled(true)
            .object(Reference.to(S3Object.TYPE_NAME, "objectGuid1"))
            .object(Reference.to(S3Object.TYPE_NAME, "objectGuid2"))
            .build();

    private static S3Bucket frodo;
    private static String serialized;

    @Test(groups = {"serialize"})
    void serialization() {
        assertNotNull(full);
        serialized = full.toJson();
        assertNotNull(serialized);
    }

    @Test(
            groups = {"deserialize"},
            dependsOnGroups = {"serialize"})
    void deserialization() {
        assertNotNull(serialized);
        frodo = ApiResource.GSON.fromJson(serialized, S3Bucket.class);
        assertNotNull(frodo);
    }

    @Test(
            groups = {"equivalency"},
            dependsOnGroups = {"serialize", "deserialize"})
    void serializedEquivalency() {
        assertNotNull(serialized);
        assertNotNull(frodo);
        String backAgain = frodo.toJson();
        assertEquals(serialized, backAgain, "Serialization is not equivalent after serde loop,");
    }

    @Test(
            groups = {"equivalency"},
            dependsOnGroups = {"serialize", "deserialize"})
    void deserializedEquivalency() {
        assertNotNull(full);
        assertNotNull(frodo);
        assertEquals(full, frodo, "Deserialization is not equivalent after serde loop,");
    }
}