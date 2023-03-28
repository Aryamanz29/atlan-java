/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2023 Atlan Pte. Ltd. */
package com.atlan.model.enums;

import lombok.Getter;

public enum KeywordFields implements AtlanSearchableField {
    /** Unused. */
    ABBREVIATION("abbreviation"),
    /** Unused. */
    ADDITIONAL_ATTRIBUTES("additionalAttributes"),
    /** TBC */
    ADDITIONAL_INFO("additionalInfo"),
    /** TBC */
    ADLS_ACCOUNT_ACCESS_TIER("adlsAccountAccessTier"),
    /** TBC */
    ADLS_ACCOUNT_KIND("adlsAccountKind"),
    /** TBC */
    ADLS_ACCOUNT_PERFORMANCE("adlsAccountPerformance"),
    /** TBC */
    ADLS_ACCOUNT_PROVISION_STATE("adlsAccountProvisionState"),
    /** TBC */
    ADLS_ACCOUNT_QUALIFIED_NAME("adlsAccountQualifiedName"),
    /** TBC */
    ADLS_ACCOUNT_REPLICATION("adlsAccountReplication"),
    /** TBC */
    ADLS_ACCOUNT_RESOURCE_GROUP("adlsAccountResourceGroup.keyword"),
    /** TBC */
    ADLS_ACCOUNT_SECONDARY_LOCATION("adlsAccountSecondaryLocation"),
    /** TBC */
    ADLS_ACCOUNT_SUBSCRIPTION("adlsAccountSubscription.keyword"),
    /** TBC */
    ADLS_CONTAINER_ENCRYPTION_SCOPE("adlsContainerEncryptionScope"),
    /** TBC */
    ADLS_CONTAINER_LEASE_STATE("adlsContainerLeaseState"),
    /** TBC */
    ADLS_CONTAINER_LEASE_STATUS("adlsContainerLeaseStatus"),
    /** TBC */
    ADLS_CONTAINER_QUALIFIED_NAME("adlsContainerQualifiedName"),
    /** TBC */
    ADLS_CONTAINER_URL("adlsContainerUrl.keyword"),
    /** Entity tag for the asset. An entity tag is a hash of the object and represents changes to the contents of an object only, not its metadata. */
    ADLS_E_TAG("adlsETag"),
    /** TBC */
    ADLS_ENCRYPTION_TYPE("adlsEncryptionType"),
    /** TBC */
    ADLS_OBJECT_ACCESS_TIER("adlsObjectAccessTier"),
    /** TBC */
    ADLS_OBJECT_ARCHIVE_STATUS("adlsObjectArchiveStatus"),
    /** TBC */
    ADLS_OBJECT_CONTENT_LANGUAGE("adlsObjectContentLanguage.keyword"),
    /** TBC */
    ADLS_OBJECT_CONTENT_MD5HASH("adlsObjectContentMD5Hash"),
    /** TBC */
    ADLS_OBJECT_LEASE_STATE("adlsObjectLeaseState"),
    /** TBC */
    ADLS_OBJECT_LEASE_STATUS("adlsObjectLeaseStatus"),
    /** TBC */
    ADLS_OBJECT_METADATA("adlsObjectMetadata"),
    /** TBC */
    ADLS_OBJECT_TYPE("adlsObjectType"),
    /** TBC */
    ADLS_OBJECT_URL("adlsObjectUrl.keyword"),
    /** TBC */
    ADLS_OBJECT_VERSION_ID("adlsObjectVersionId"),
    /** TBC */
    ADLS_PRIMARY_DISK_STATE("adlsPrimaryDiskState"),
    /** List of groups who administer the asset. (This is only used for Connection assets.) */
    ADMIN_GROUPS("adminGroups"),
    /** List of roles who administer the asset. (This is only used for Connection assets.) */
    ADMIN_ROLES("adminRoles"),
    /** List of users who administer the asset. (This is only used for Connection assets.) */
    ADMIN_USERS("adminUsers"),
    /** TBC */
    ALIAS("alias"),
    /** Detailed message to include in the announcement on this asset. */
    ANNOUNCEMENT_MESSAGE("announcementMessage"),
    /** Brief title for the announcement on this asset. Required when announcementType is specified. */
    ANNOUNCEMENT_TITLE("announcementTitle"),
    /** Type of announcement on the asset. */
    ANNOUNCEMENT_TYPE("announcementType"),
    /** Name of the user who last updated the announcement. */
    ANNOUNCEMENT_UPDATED_BY("announcementUpdatedBy"),
    /** TBC */
    API_EXTERNAL_DOCS("apiExternalDocs"),
    /** TBC */
    API_NAME("apiName.keyword"),
    /** TBC */
    API_PATH_AVAILABLE_OPERATIONS("apiPathAvailableOperations"),
    /** TBC */
    API_PATH_AVAILABLE_RESPONSE_CODES("apiPathAvailableResponseCodes"),
    /** TBC */
    API_PATH_RAW_URI("apiPathRawURI"),
    /** TBC */
    API_SPEC_CONTACT_EMAIL("apiSpecContactEmail"),
    /** TBC */
    API_SPEC_CONTACT_NAME("apiSpecContactName.keyword"),
    /** TBC */
    API_SPEC_CONTACT_URL("apiSpecContactURL"),
    /** TBC */
    API_SPEC_CONTRACT_VERSION("apiSpecContractVersion"),
    /** TBC */
    API_SPEC_LICENSE_NAME("apiSpecLicenseName.keyword"),
    /** TBC */
    API_SPEC_LICENSE_URL("apiSpecLicenseURL"),
    /** TBC */
    API_SPEC_NAME("apiSpecName.keyword"),
    /** TBC */
    API_SPEC_QUALIFIED_NAME("apiSpecQualifiedName"),
    /** TBC */
    API_SPEC_SERVICE_ALIAS("apiSpecServiceAlias"),
    /** TBC */
    API_SPEC_TERMS_OF_SERVICE_URL("apiSpecTermsOfServiceURL"),
    /** TBC */
    API_SPEC_TYPE("apiSpecType"),
    /** TBC */
    API_SPEC_VERSION("apiSpecVersion"),
    /** TBC */
    ASSET_DBT_ACCOUNT_NAME("assetDbtAccountName.keyword"),
    /** TBC */
    ASSET_DBT_ALIAS("assetDbtAlias.keyword"),
    /** TBC */
    ASSET_DBT_ENVIRONMENT_DBT_VERSION("assetDbtEnvironmentDbtVersion"),
    /** TBC */
    ASSET_DBT_ENVIRONMENT_NAME("assetDbtEnvironmentName.keyword"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_ARTIFACT_S3PATH("assetDbtJobLastRunArtifactS3Path"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_EXECUTED_BY_THREAD_ID("assetDbtJobLastRunExecutedByThreadId"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_GIT_BRANCH("assetDbtJobLastRunGitBranch"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_GIT_SHA("assetDbtJobLastRunGitSha"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_OWNER_THREAD_ID("assetDbtJobLastRunOwnerThreadId"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_QUEUED_DURATION("assetDbtJobLastRunQueuedDuration"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_QUEUED_DURATION_HUMANIZED("assetDbtJobLastRunQueuedDurationHumanized"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_RUN_DURATION("assetDbtJobLastRunRunDuration"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_RUN_DURATION_HUMANIZED("assetDbtJobLastRunRunDurationHumanized"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_STATUS_MESSAGE("assetDbtJobLastRunStatusMessage.keyword"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_TOTAL_DURATION("assetDbtJobLastRunTotalDuration"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_TOTAL_DURATION_HUMANIZED("assetDbtJobLastRunTotalDurationHumanized"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_URL("assetDbtJobLastRunUrl"),
    /** TBC */
    ASSET_DBT_JOB_NAME("assetDbtJobName.keyword"),
    /** TBC */
    ASSET_DBT_JOB_NEXT_RUN_HUMANIZED("assetDbtJobNextRunHumanized.keyword"),
    /** TBC */
    ASSET_DBT_JOB_SCHEDULE("assetDbtJobSchedule"),
    /** TBC */
    ASSET_DBT_JOB_STATUS("assetDbtJobStatus"),
    /** TBC */
    ASSET_DBT_META("assetDbtMeta"),
    /** TBC */
    ASSET_DBT_PACKAGE_NAME("assetDbtPackageName.keyword"),
    /** TBC */
    ASSET_DBT_PROJECT_NAME("assetDbtProjectName.keyword"),
    /** TBC */
    ASSET_DBT_SEMANTIC_LAYER_PROXY_URL("assetDbtSemanticLayerProxyUrl"),
    /** TBC */
    ASSET_DBT_SOURCE_FRESHNESS_CRITERIA("assetDbtSourceFreshnessCriteria"),
    /** TBC */
    ASSET_DBT_TAGS("assetDbtTags"),
    /** TBC */
    ASSET_DBT_UNIQUE_ID("assetDbtUniqueId.keyword"),
    /** TBC */
    AST("ast"),
    /** 12-digit number that uniquely identifies an AWS account. */
    AWS_ACCOUNT_ID("awsAccountId"),
    /** Amazon Resource Name (ARN) for this asset. This uniquely identifies the asset in AWS, and thus must be unique across all AWS asset instances. */
    AWS_ARN("awsArn"),
    /** Root user's ID. */
    AWS_OWNER_ID("awsOwnerId"),
    /** Root user's name. */
    AWS_OWNER_NAME("awsOwnerName"),
    /** Group of AWS region and service objects. */
    AWS_PARTITION("awsPartition"),
    /** Physical region where the data center in which the asset exists is clustered. */
    AWS_REGION("awsRegion"),
    /** Unique resource ID assigned when a new resource is created. */
    AWS_RESOURCE_ID("awsResourceId"),
    /** Type of service in which the asset exists. */
    AWS_SERVICE("awsService"),
    /** List of tags that have been applied to the asset in AWS. */
    AWS_TAGS("awsTags"),
    /** TBC */
    AZURE_LOCATION("azureLocation"),
    /** TBC */
    AZURE_RESOURCE_ID("azureResourceId"),
    /** TBC */
    AZURE_TAGS("azureTags"),
    /** TBC */
    BADGE_CONDITIONS("badgeConditions"),
    /** TBC */
    BADGE_METADATA_ATTRIBUTE("badgeMetadataAttribute"),
    /** Type of connection. */
    CATEGORY("category"),
    /** Status of the asset's certification. */
    CERTIFICATE_STATUS("certificateStatus"),
    /** Human-readable descriptive message that can optionally be submitted when the certificateStatus is changed. */
    CERTIFICATE_STATUS_MESSAGE("certificateStatusMessage"),
    /** Name of the user who last updated the certification of the asset. */
    CERTIFICATE_UPDATED_BY("certificateUpdatedBy"),
    /** TBC */
    CERTIFICATION_NOTE("certificationNote"),
    /** TBC */
    CERTIFIER("certifier"),
    /** TBC */
    CERTIFIER_DISPLAY_NAME("certifierDisplayName"),
    /** TBC */
    CLIENT_ID("clientId"),
    /** Code that ran within the process. */
    CODE("code"),
    /** qualifiedName of the collection in which this folder exists. */
    COLLECTION_QUALIFIED_NAME("collectionQualifiedName"),
    /** List of values in a histogram that represents the contents of the column. */
    COLUMN_HISTOGRAM("columnHistogram"),
    /** List of the greatest values in a column. */
    COLUMN_MAXS("columnMaxs"),
    /** List of the least values in a column. */
    COLUMN_MINS("columnMins"),
    /** TBC */
    COLUMN_TOP_VALUES("columnTopValues"),
    /** TBC */
    CONNECTION_DBT_ENVIRONMENTS("connectionDbtEnvironments"),
    /** TBC */
    CONNECTION_DETAILS("connectionDetails"),
    /** TBC */
    CONNECTION_NAME("connectionName"),
    /** Unique name of the connection through which this asset is accessible. */
    CONNECTION_QUALIFIED_NAME("connectionQualifiedName"),
    /** TBC */
    CONNECTOR_ICON("connectorIcon"),
    /** TBC */
    CONNECTOR_IMAGE("connectorImage"),
    /** Type of the connector through which this asset is accessible. */
    CONNECTOR_TYPE("connectorName"),
    /** TBC */
    CONSTRAINT("constraint"),
    /** Atlan user who created this sasset. */
    CREATED_BY("__createdBy"),
    /** TBC */
    CREDENTIAL_STRATEGY("credentialStrategy"),
    /** TBC */
    DASHBOARD_QUALIFIED_NAME("dashboardQualifiedName"),
    /** Type of dashboard in Salesforce. */
    DASHBOARD_TYPE("dashboardType"),
    /** TBC */
    DATA_CATEGORY("dataCategory"),
    /** Owner of the asset within Google Data Studio. */
    DATA_STUDIO_ASSET_OWNER("dataStudioAssetOwner"),
    /** Title for the asset. */
    DATA_STUDIO_ASSET_TITLE("dataStudioAssetTitle.keyword"),
    /** Type of Google Data Studio asset. */
    DATA_STUDIO_ASSET_TYPE("dataStudioAssetType"),
    /** Data type of values in the column. */
    DATA_TYPE("dataType"),
    /** Simple name of the database in which this SQL asset exists, or empty if it does not exist within a database. */
    DATABASE_NAME("databaseName.keyword"),
    /** Unique name of the database in which this SQL asset exists, or empty if it does not exist within a database. */
    DATABASE_QUALIFIED_NAME("databaseQualifiedName"),
    /** TBC */
    DATASET_QUALIFIED_NAME("datasetQualifiedName"),
    /** TBC */
    DATASOURCE_FIELD_TYPE("datasourceFieldType"),
    /** TBC */
    DATASOURCE_QUALIFIED_NAME("datasourceQualifiedName"),
    /** TBC */
    DBT_ACCOUNT_NAME("dbtAccountName.keyword"),
    /** TBC */
    DBT_ALIAS("dbtAlias.keyword"),
    /** TBC */
    DBT_COLUMN_PROCESS_JOB_STATUS("dbtColumnProcessJobStatus"),
    /** TBC */
    DBT_COMPILED_SQL("dbtCompiledSQL"),
    /** TBC */
    DBT_CONNECTION_CONTEXT("dbtConnectionContext"),
    /** TBC */
    DBT_ENVIRONMENT_DBT_VERSION("dbtEnvironmentDbtVersion.keyword"),
    /** TBC */
    DBT_ENVIRONMENT_NAME("dbtEnvironmentName.keyword"),
    /** TBC */
    DBT_ERROR("dbtError"),
    /** TBC */
    DBT_FRESHNESS_CRITERIA("dbtFreshnessCriteria"),
    /** TBC */
    DBT_JOB_NAME("dbtJobName.keyword"),
    /** TBC */
    DBT_JOB_NEXT_RUN_HUMANIZED("dbtJobNextRunHumanized.keyword"),
    /** TBC */
    DBT_JOB_SCHEDULE("dbtJobSchedule"),
    /** TBC */
    DBT_JOB_SCHEDULE_CRON_HUMANIZED("dbtJobScheduleCronHumanized.keyword"),
    /** TBC */
    DBT_JOB_STATUS("dbtJobStatus"),
    /** TBC */
    DBT_MATERIALIZATION_TYPE("dbtMaterializationType"),
    /** TBC */
    DBT_META("dbtMeta"),
    /** TBC */
    DBT_METRIC_FILTERS("dbtMetricFilters"),
    /** TBC */
    DBT_MODEL_COLUMN_DATA_TYPE("dbtModelColumnDataType"),
    /** TBC */
    DBT_MODEL_QUALIFIED_NAME("dbtModelQualifiedName"),
    /** TBC */
    DBT_PACKAGE_NAME("dbtPackageName.keyword"),
    /** TBC */
    DBT_PROCESS_JOB_STATUS("dbtProcessJobStatus"),
    /** TBC */
    DBT_PROJECT_NAME("dbtProjectName.keyword"),
    /** TBC */
    DBT_QUALIFIED_NAME("dbtQualifiedName"),
    /** TBC */
    DBT_RAW_SQL("dbtRawSQL"),
    /** TBC */
    DBT_SEMANTIC_LAYER_PROXY_URL("dbtSemanticLayerProxyUrl"),
    /** TBC */
    DBT_STATE("dbtState"),
    /** TBC */
    DBT_STATS("dbtStats"),
    /** TBC */
    DBT_STATUS("dbtStatus"),
    /** TBC */
    DBT_TAGS("dbtTags"),
    /** TBC */
    DBT_UNIQUE_ID("dbtUniqueId.keyword"),
    /** TBC */
    DEFAULT_CREDENTIAL_GUID("defaultCredentialGuid"),
    /** TBC */
    DEFAULT_DATABASE_QUALIFIED_NAME("defaultDatabaseQualifiedName"),
    /** TBC */
    DEFAULT_SCHEMA_QUALIFIED_NAME("defaultSchemaQualifiedName"),
    /** TBC */
    DEFAULT_VALUE("defaultValue"),
    /** TBC */
    DEFAULT_VALUE_FORMULA("defaultValueFormula"),
    /** Definition of the view (DDL). */
    DEFINITION("definition"),
    /** Description of the asset, as crawled from a source. */
    DESCRIPTION("description.keyword"),
    /** List of column names on the report. */
    DETAIL_COLUMNS("detailColumns"),
    /** Name used for display purposes (in user interfaces). */
    DISPLAY_NAME("displayName.keyword"),
    /** Unused. */
    EXAMPLES("examples"),
    /** TBC */
    EXTERNAL_LOCATION("externalLocation"),
    /** TBC */
    EXTERNAL_LOCATION_FORMAT("externalLocationFormat"),
    /** TBC */
    EXTERNAL_LOCATION_REGION("externalLocationRegion"),
    /** TBC */
    FIELDS("fields"),
    /** TBC */
    FOLDER_NAME("folderName"),
    /** TBC */
    FORMULA("formula"),
    /** TBC */
    FULL_NAME("fullName"),
    /** TBC */
    FULLY_QUALIFIED_NAME("fullyQualifiedName"),
    /** TBC */
    GCS_ACCESS_CONTROL("gcsAccessControl"),
    /** Human-readable name of the bucket in which this object exists. */
    GCS_BUCKET_NAME("gcsBucketName.keyword"),
    /** qualifiedName of the bucket in which this object exists. */
    GCS_BUCKET_QUALIFIED_NAME("gcsBucketQualifiedName"),
    /** Entity tag for the asset. An entity tag is a hash of the object and represents changes to the contents of an object only, not its metadata. */
    GCS_E_TAG("gcsETag"),
    /** TBC */
    GCS_ENCRYPTION_TYPE("gcsEncryptionType"),
    /** TBC */
    GCS_OBJECT_CRC32C_HASH("gcsObjectCRC32CHash"),
    /** Information about how the object's content should be presented. */
    GCS_OBJECT_CONTENT_DISPOSITION("gcsObjectContentDisposition"),
    /** TBC */
    GCS_OBJECT_CONTENT_ENCODING("gcsObjectContentEncoding"),
    /** TBC */
    GCS_OBJECT_CONTENT_LANGUAGE("gcsObjectContentLanguage"),
    /** Type of content in the object. */
    GCS_OBJECT_CONTENT_TYPE("gcsObjectContentType"),
    /** TBC */
    GCS_OBJECT_HOLD_TYPE("gcsObjectHoldType"),
    /** TBC */
    GCS_OBJECT_KEY("gcsObjectKey"),
    /** TBC */
    GCS_OBJECT_MD5HASH("gcsObjectMD5Hash"),
    /** TBC */
    GCS_OBJECT_MEDIA_LINK("gcsObjectMediaLink"),
    /** TBC */
    GCS_STORAGE_CLASS("gcsStorageClass"),
    /** Glossary in which the asset is contained, searchable by the qualifiedName of the glossary. */
    GLOSSARY("__glossary"),
    /** List of labels that have been applied to the asset in Google. */
    GOOGLE_LABELS("googleLabels"),
    /** TBC */
    GOOGLE_LOCATION("googleLocation"),
    /** TBC */
    GOOGLE_LOCATION_TYPE("googleLocationType"),
    /** ID of the project in which the asset exists. */
    GOOGLE_PROJECT_ID("googleProjectId"),
    /** Name of the project in which the asset exists. */
    GOOGLE_PROJECT_NAME("googleProjectName"),
    /** Service in Google in which the asset exists. */
    GOOGLE_SERVICE("googleService"),
    /** List of tags that have been applied to the asset in Google. */
    GOOGLE_TAGS("googleTags"),
    /** Globally unique identifier (GUID) of any object in Atlan. */
    GUID("__guid"),
    /** Host name of the connection's source. */
    HOST("host"),
    /** TBC */
    ICON("icon"),
    /** TBC */
    ICON_TYPE("iconType"),
    /** TBC */
    INPUT_FIELDS("inputFields"),
    /** Assets that are inputs to this process. */
    INPUTS("inputs"),
    /** TBC */
    KAFKA_CONSUMER_GROUP_TOPIC_CONSUMPTION_PROPERTIES("kafkaConsumerGroupTopicConsumptionProperties"),
    /** TBC */
    KAFKA_TOPIC_CLEANUP_POLICY("kafkaTopicCleanupPolicy"),
    /** TBC */
    KAFKA_TOPIC_COMPRESSION_TYPE("kafkaTopicCompressionType"),
    /** TBC */
    KAFKA_TOPIC_NAMES("kafkaTopicNames"),
    /** TBC */
    KAFKA_TOPIC_QUALIFIED_NAMES("kafkaTopicQualifiedNames"),
    /** Unused. */
    LANGUAGE("language"),
    /** Name of the last run of the crawler that last synchronized this asset. */
    LAST_SYNC_RUN("lastSyncRun"),
    /** Name of the crawler that last synchronized this asset. */
    LAST_SYNC_WORKFLOW_NAME("lastSyncWorkflowName"),
    /** TBC */
    LINK("link"),
    /** Unused. */
    LONG_DESCRIPTION("longDescription"),
    /** TBC */
    LOOKER_EXPLORE_QUALIFIED_NAME("lookerExploreQualifiedName"),
    /** TBC */
    LOOKER_FIELD_DATA_TYPE("lookerFieldDataType"),
    /** TBC */
    LOOKER_VIEW_QUALIFIED_NAME("lookerViewQualifiedName"),
    /** TBC */
    LOOKML_LINK_ID("lookmlLinkId"),
    /** All terms attached to an asset, searchable by the term's qualifiedName. */
    ASSIGNED_TERMS("__meanings"),
    /** TBC */
    MERGE_RESULT_ID("mergeResultId"),
    /** TBC */
    METABASE_COLLECTION_NAME("metabaseCollectionName.keyword"),
    /** TBC */
    METABASE_COLLECTION_QUALIFIED_NAME("metabaseCollectionQualifiedName"),
    /** TBC */
    METABASE_COLOR("metabaseColor"),
    /** TBC */
    METABASE_NAMESPACE("metabaseNamespace"),
    /** TBC */
    METABASE_QUERY("metabaseQuery.keyword"),
    /** TBC */
    METABASE_QUERY_TYPE("metabaseQueryType"),
    /** TBC */
    METABASE_SLUG("metabaseSlug"),
    /** TBC */
    METRIC_SQL("metricSQL"),
    /** TBC */
    METRIC_TYPE("metricType"),
    /** TBC */
    MODE_CHART_TYPE("modeChartType"),
    /** TBC */
    MODE_COLLECTION_STATE("modeCollectionState"),
    /** TBC */
    MODE_COLLECTION_TOKEN("modeCollectionToken"),
    /** TBC */
    MODE_COLLECTION_TYPE("modeCollectionType"),
    /** TBC */
    MODE_ID("modeId"),
    /** TBC */
    MODE_QUERY_NAME("modeQueryName.keyword"),
    /** TBC */
    MODE_QUERY_QUALIFIED_NAME("modeQueryQualifiedName"),
    /** TBC */
    MODE_REPORT_NAME("modeReportName.keyword"),
    /** TBC */
    MODE_REPORT_QUALIFIED_NAME("modeReportQualifiedName"),
    /** TBC */
    MODE_TOKEN("modeToken"),
    /** TBC */
    MODE_WORKSPACE_NAME("modeWorkspaceName.keyword"),
    /** TBC */
    MODE_WORKSPACE_QUALIFIED_NAME("modeWorkspaceQualifiedName"),
    /** TBC */
    MODE_WORKSPACE_USERNAME("modeWorkspaceUsername"),
    /** TBC */
    MODEL_NAME("modelName"),
    /** Atlan user who last updated the sasset. */
    MODIFIED_BY("__modifiedBy"),
    /** Human-readable name of the asset. */
    NAME("name.keyword"),
    /** TBC */
    NOTE_TEXT("noteText"),
    /** TBC */
    OBJECT_QUALIFIED_NAME("objectQualifiedName"),
    /** TBC */
    OPERATION("operation"),
    /** TBC */
    OPERATION_PARAMS("operationParams"),
    /** TBC */
    ORGANIZATION_QUALIFIED_NAME("organizationQualifiedName"),
    /** TBC */
    OUTPUT_FIELDS("outputFields"),
    /** TBC */
    OUTPUT_STEPS("outputSteps"),
    /** Assets that are outputs from this process. */
    OUTPUTS("outputs"),
    /** List of groups who own the asset. */
    OWNER_GROUPS("ownerGroups"),
    /** TBC */
    OWNER_NAME("ownerName"),
    /** List of users who own the asset. */
    OWNER_USERS("ownerUsers"),
    /** TBC */
    PARAMS("params"),
    /** TBC */
    PARENT_QUALIFIED_NAME("parentQualifiedName"),
    /** TBC */
    PARTITION_LIST("partitionList"),
    /** TBC */
    PARTITION_STRATEGY("partitionStrategy"),
    /** List of values from which a user can pick while adding a record. */
    PICKLIST_VALUES("picklistValues"),
    /** TBC */
    PINNED_BY("pinnedBy"),
    /** TBC */
    POLICY_STRATEGY("policyStrategy"),
    /** TBC */
    POWER_BI_COLUMN_DATA_CATEGORY("powerBIColumnDataCategory"),
    /** TBC */
    POWER_BI_COLUMN_DATA_TYPE("powerBIColumnDataType"),
    /** TBC */
    POWER_BI_COLUMN_SUMMARIZE_BY("powerBIColumnSummarizeBy"),
    /** TBC */
    POWER_BI_ENDORSEMENT("powerBIEndorsement"),
    /** TBC */
    POWER_BI_FORMAT_STRING("powerBIFormatString"),
    /** TBC */
    POWER_BI_SORT_BY_COLUMN("powerBISortByColumn"),
    /** TBC */
    POWER_BI_TABLE_QUALIFIED_NAME("powerBITableQualifiedName"),
    /** TBC */
    POWER_BI_TABLE_SOURCE_EXPRESSIONS("powerBITableSourceExpressions"),
    /** TBC */
    PRESET_CHART_FORM_DATA("presetChartFormData"),
    /** Username of the user who last changed the collection. */
    PRESET_DASHBOARD_CHANGED_BY_NAME("presetDashboardChangedByName.keyword"),
    /** TBC */
    PRESET_DASHBOARD_CHANGED_BY_URL("presetDashboardChangedByURL"),
    /** qualifiedName of the Preset asset's collection. */
    PRESET_DASHBOARD_QUALIFIED_NAME("presetDashboardQualifiedName"),
    /** URL to a thumbnail illustration of the collection. */
    PRESET_DASHBOARD_THUMBNAIL_URL("presetDashboardThumbnailURL"),
    /** Name of the data source for the dataset. */
    PRESET_DATASET_DATASOURCE_NAME("presetDatasetDatasourceName.keyword"),
    /** Type of the dataset. */
    PRESET_DATASET_TYPE("presetDatasetType"),
    /** Hostname of the Preset workspace. */
    PRESET_WORKSPACE_HOSTNAME("presetWorkspaceHostname"),
    /** qualifiedName of the Preset asset's workspace. */
    PRESET_WORKSPACE_QUALIFIED_NAME("presetWorkspaceQualifiedName"),
    /** Region of the workspace. */
    PRESET_WORKSPACE_REGION("presetWorkspaceRegion"),
    /** Status of the workspace. */
    PRESET_WORKSPACE_STATUS("presetWorkspaceStatus"),
    /** TBC */
    PREVIEW_CREDENTIAL_STRATEGY("previewCredentialStrategy"),
    /** TBC */
    PROJECT_HIERARCHY("projectHierarchy"),
    /** TBC */
    PROJECT_NAME("projectName"),
    /** TBC */
    PROJECT_QUALIFIED_NAME("projectQualifiedName"),
    /** All propagated classifications that exist on an asset, searchable by the internal hashed-string ID of the classification. */
    PROPAGATED_TRAIT_NAMES("__propagatedTraitNames"),
    /** TBC */
    QLIK_APP_ID("qlikAppId"),
    /** TBC */
    QLIK_APP_QUALIFIED_NAME("qlikAppQualifiedName"),
    /** TBC */
    QLIK_CHART_ORIENTATION("qlikChartOrientation"),
    /** TBC */
    QLIK_CHART_TYPE("qlikChartType"),
    /** TBC */
    QLIK_DATASET_SUBTYPE("qlikDatasetSubtype"),
    /** TBC */
    QLIK_DATASET_TECHNICAL_NAME("qlikDatasetTechnicalName.keyword"),
    /** TBC */
    QLIK_DATASET_TYPE("qlikDatasetType"),
    /** TBC */
    QLIK_DATASET_URI("qlikDatasetUri"),
    /** TBC */
    QLIK_ID("qlikId"),
    /** TBC */
    QLIK_ORIGIN_APP_ID("qlikOriginAppId"),
    /** TBC */
    QLIK_OWNER_ID("qlikOwnerId"),
    /** TBC */
    QLIK_QRI("qlikQRI"),
    /** TBC */
    QLIK_SPACE_ID("qlikSpaceId"),
    /** TBC */
    QLIK_SPACE_QUALIFIED_NAME("qlikSpaceQualifiedName"),
    /** TBC */
    QLIK_SPACE_TYPE("qlikSpaceType"),
    /** Unique name for this asset. This is typically a concatenation of the asset's name onto its parent's qualifiedName. */
    QUALIFIED_NAME("qualifiedName"),
    /** TBC */
    QUERY_CONFIG("queryConfig"),
    /** TBC */
    QUERY_PREVIEW_CONFIG("queryPreviewConfig"),
    /** TBC */
    QUERY_USER_MAP("queryUserMap"),
    /** TBC */
    QUERY_USERNAME_STRATEGY("queryUsernameStrategy"),
    /** TBC */
    QUICK_SIGHT_ANALYSIS_CALCULATED_FIELDS("quickSightAnalysisCalculatedFields"),
    /** TBC */
    QUICK_SIGHT_ANALYSIS_FILTER_GROUPS("quickSightAnalysisFilterGroups"),
    /** TBC */
    QUICK_SIGHT_ANALYSIS_PARAMETER_DECLARATIONS("quickSightAnalysisParameterDeclarations"),
    /** TBC */
    QUICK_SIGHT_ANALYSIS_QUALIFIED_NAME("quickSightAnalysisQualifiedName"),
    /** TBC */
    QUICK_SIGHT_ANALYSIS_STATUS("quickSightAnalysisStatus"),
    /** TBC */
    QUICK_SIGHT_DASHBOARD_QUALIFIED_NAME("quickSightDashboardQualifiedName"),
    /** TBC */
    QUICK_SIGHT_DATASET_FIELD_TYPE("quickSightDatasetFieldType"),
    /** TBC */
    QUICK_SIGHT_DATASET_IMPORT_MODE("quickSightDatasetImportMode"),
    /** TBC */
    QUICK_SIGHT_DATASET_QUALIFIED_NAME("quickSightDatasetQualifiedName"),
    /** TBC */
    QUICK_SIGHT_FOLDER_HIERARCHY("quickSightFolderHierarchy"),
    /** TBC */
    QUICK_SIGHT_FOLDER_TYPE("quickSightFolderType"),
    /** TBC */
    QUICK_SIGHT_ID("quickSightId"),
    /** TBC */
    QUICK_SIGHT_SHEET_ID("quickSightSheetId"),
    /** TBC */
    QUICK_SIGHT_SHEET_NAME("quickSightSheetName.keyword"),
    /** TBC */
    RAW_QUERY("rawQuery"),
    /** TBC */
    REFERENCE("reference"),
    /** TBC */
    REFRESH_METHOD("refreshMethod"),
    /** TBC */
    REFRESH_MODE("refreshMode"),
    /** Unused. */
    REPLICATED_FROM("replicatedFrom"),
    /** Unused. */
    REPLICATED_TO("replicatedTo"),
    /** TBC */
    REPORT_QUALIFIED_NAME("reportQualifiedName"),
    /** Type of report in Salesforce. */
    REPORT_TYPE("reportType"),
    /** TBC */
    RESOURCE_METADATA("resourceMetadata"),
    /** TBC */
    RESULT("result"),
    /** TBC */
    RESULT_SUMMARY("resultSummary"),
    /** TBC */
    ROLE("role"),
    /** Name of the bucket in which the object exists. */
    S3BUCKET_NAME("s3BucketName"),
    /** qualifiedName of the bucket in which the object exists. */
    S3BUCKET_QUALIFIED_NAME("s3BucketQualifiedName"),
    /** Entity tag for the asset. An entity tag is a hash of the object and represents changes to the contents of an object only, not its metadata. */
    S3E_TAG("s3ETag"),
    /** TBC */
    S3ENCRYPTION("s3Encryption"),
    /** Information about how the object's content should be presented. */
    S3OBJECT_CONTENT_DISPOSITION("s3ObjectContentDisposition"),
    /** Type of content in the object. */
    S3OBJECT_CONTENT_TYPE("s3ObjectContentType"),
    /** Unique identity of the object in an S3 bucket. This is usually the concatenation of any prefix (folder) in the S3 bucket with the name of the object (file) itself. */
    S3OBJECT_KEY("s3ObjectKey"),
    /** Storage class used for storing the object. */
    S3OBJECT_STORAGE_CLASS("s3ObjectStorageClass"),
    /** Version of the object. This is only applicable when versioning is enabled on the bucket in which the object exists. */
    S3OBJECT_VERSION_ID("s3ObjectVersionId"),
    /** TBC */
    SAMPLE_DATA_URL("sampleDataUrl"),
    /** TBC */
    SAVED_SEARCHES("savedSearches"),
    /** Simple name of the schema in which this SQL asset exists, or empty if it does not exist within a schema. */
    SCHEMA_NAME("schemaName.keyword"),
    /** Unique name of the schema in which this SQL asset exists, or empty if it does not exist within a schema. */
    SCHEMA_QUALIFIED_NAME("schemaQualifiedName"),
    /** TBC */
    SEARCH_PARAMETERS("searchParameters"),
    /** TBC */
    SEARCH_TYPE("searchType"),
    /** Unused. */
    SHORT_DESCRIPTION("shortDescription"),
    /** TBC */
    SIGMA_DATA_ELEMENT_NAME("sigmaDataElementName.keyword"),
    /** TBC */
    SIGMA_DATA_ELEMENT_QUALIFIED_NAME("sigmaDataElementQualifiedName"),
    /** TBC */
    SIGMA_DATA_ELEMENT_QUERY("sigmaDataElementQuery"),
    /** TBC */
    SIGMA_DATA_ELEMENT_TYPE("sigmaDataElementType"),
    /** Human-readable name of the dataset that contains this column. */
    SIGMA_DATASET_NAME("sigmaDatasetName.keyword"),
    /** Unique name of the dataset that contains this column. */
    SIGMA_DATASET_QUALIFIED_NAME("sigmaDatasetQualifiedName"),
    /** TBC */
    SIGMA_PAGE_NAME("sigmaPageName.keyword"),
    /** TBC */
    SIGMA_PAGE_QUALIFIED_NAME("sigmaPageQualifiedName"),
    /** TBC */
    SIGMA_WORKBOOK_NAME("sigmaWorkbookName.keyword"),
    /** TBC */
    SIGMA_WORKBOOK_QUALIFIED_NAME("sigmaWorkbookQualifiedName"),
    /** TBC */
    SITE_QUALIFIED_NAME("siteQualifiedName"),
    /** TBC */
    SNOWFLAKE_PIPE_NOTIFICATION_CHANNEL_NAME("snowflakePipeNotificationChannelName"),
    /** TBC */
    SNOWFLAKE_STREAM_MODE("snowflakeStreamMode"),
    /** TBC */
    SNOWFLAKE_STREAM_SOURCE_TYPE("snowflakeStreamSourceType"),
    /** TBC */
    SNOWFLAKE_STREAM_TYPE("snowflakeStreamType"),
    /** TBC */
    SOURCE_CONNECTION_NAME("sourceConnectionName"),
    /** The unit of measure for sourceTotalCost. */
    SOURCE_COST_UNIT("sourceCostUnit"),
    /** Who created the asset, in the source system. */
    SOURCE_CREATED_BY("sourceCreatedBy"),
    /** TBC */
    SOURCE_DEFINITION("sourceDefinition"),
    /** TBC */
    SOURCE_DEFINITION_DATABASE("sourceDefinitionDatabase"),
    /** TBC */
    SOURCE_DEFINITION_SCHEMA("sourceDefinitionSchema"),
    /** URL to create an embed for a resource (for example, an image of a dashboard) within Atlan. */
    SOURCE_EMBED_URL("sourceEmbedURL"),
    /** ID of the organization in Salesforce. */
    SOURCE_ID("sourceId"),
    /** TBC */
    SOURCE_LOGO("sourceLogo"),
    /** TBC */
    SOURCE_OWNERS("sourceOwners"),
    /** List of most expensive warehouse names. */
    SOURCE_QUERY_COMPUTE_COSTS("sourceQueryComputeCostList"),
    /** List of most expensive warehouses with extra insights. */
    SOURCE_QUERY_COMPUTE_COST_RECORDS("sourceQueryComputeCostRecordList"),
    /** List of the most expensive queries that accessed this asset. */
    SOURCE_READ_EXPENSIVE_QUERY_RECORDS("sourceReadExpensiveQueryRecordList"),
    /** List of the most popular queries that accessed this asset. */
    SOURCE_READ_POPULAR_QUERY_RECORDS("sourceReadPopularQueryRecordList"),
    /** List of usernames of the most recent users who read the asset. */
    SOURCE_READ_RECENT_USERS("sourceReadRecentUserList"),
    /** List of usernames with extra insights for the most recent users who read the asset. */
    SOURCE_READ_RECENT_USER_RECORDS("sourceReadRecentUserRecordList"),
    /** List of the slowest queries that accessed this asset. */
    SOURCE_READ_SLOW_QUERY_RECORDS("sourceReadSlowQueryRecordList"),
    /** List of usernames of the users who read the asset the most. */
    SOURCE_READ_TOP_USERS("sourceReadTopUserList"),
    /** List of usernames with extra insights for the users who read the asset the most. */
    SOURCE_READ_TOP_USER_RECORDS("sourceReadTopUserRecordList"),
    /** TBC */
    SOURCE_SERVER_NAME("sourceServerName"),
    /** URL to the resource within the source application. */
    SOURCE_URL("sourceURL"),
    /** Who last updated the asset in the source system. */
    SOURCE_UPDATED_BY("sourceUpdatedBy"),
    /** SQL query that ran to produce the outputs. */
    SQL("sql"),
    /** TBC */
    SQL_TABLE_NAME("sqlTableName"),
    /** TBC */
    STALENESS("staleness"),
    /** Asset status in Atlan (active vs deleted). */
    STATE("__state"),
    /** TBC */
    SUB_CATEGORY("subCategory"),
    /** TBC */
    SUB_DATA_TYPE("subDataType"),
    /** TBC */
    SUB_TYPE("subType"),
    /** TBC */
    SUBTITLE_TEXT("subtitleText"),
    /** All super types of an asset. */
    SUPER_TYPE_NAMES("__superTypeNames.keyword"),
    /** Simple name of the table in which this SQL asset exists, or empty if it does not exist within a table. */
    TABLE_NAME("tableName.keyword"),
    /** Unique name of the table in which this SQL asset exists, or empty if it does not exist within a table. */
    TABLE_QUALIFIED_NAME("tableQualifiedName"),
    /** TBC */
    TABLEAU_DATA_TYPE("tableauDataType"),
    /** TBC */
    TABLEAU_DATASOURCE_FIELD_BIN_SIZE("tableauDatasourceFieldBinSize"),
    /** TBC */
    TABLEAU_DATASOURCE_FIELD_DATA_CATEGORY("tableauDatasourceFieldDataCategory"),
    /** TBC */
    TABLEAU_DATASOURCE_FIELD_DATA_TYPE("tableauDatasourceFieldDataType"),
    /** TBC */
    TABLEAU_DATASOURCE_FIELD_FORMULA("tableauDatasourceFieldFormula"),
    /** TBC */
    TABLEAU_DATASOURCE_FIELD_ROLE("tableauDatasourceFieldRole"),
    /** TBC */
    TARGET_SERVER_NAME("targetServerName"),
    /** Name of the Atlan workspace in which the asset exists. */
    TENANT_ID("tenantId"),
    /** TBC */
    TOP_LEVEL_PROJECT_NAME("topLevelProjectName"),
    /** TBC */
    TOP_LEVEL_PROJECT_QUALIFIED_NAME("topLevelProjectQualifiedName"),
    /** All directly-assigned classifications that exist on an asset, searchable by the internal hashed-string ID of the classification. */
    TRAIT_NAMES("__traitNames"),
    /** Type of the asset. For example Table, Column, and so on. */
    TYPE_NAME("__typeName.keyword"),
    /** TBC */
    UI_PARAMETERS("uiParameters"),
    /** TBC */
    UNIQUE_NAME("uniqueName"),
    /** TBC */
    UPSTREAM_COLUMNS("upstreamColumns"),
    /** TBC */
    UPSTREAM_DATASOURCES("upstreamDatasources"),
    /** TBC */
    UPSTREAM_FIELDS("upstreamFields"),
    /** TBC */
    UPSTREAM_TABLES("upstreamTables"),
    /** TBC */
    URLS("urls"),
    /** Unused. */
    USAGE("usage"),
    /** Description of the asset, as provided by a user. If present, this will be used for the description in user interfaces. If not present, the description will be used. */
    USER_DESCRIPTION("userDescription.keyword"),
    /** TBC */
    USER_NAME("userName"),
    /** TBC */
    VALIDATIONS("validations"),
    /** TBC */
    VARIABLES_SCHEMA_BASE64("variablesSchemaBase64"),
    /** Simple name of the view in which this SQL asset exists, or empty if it does not exist within a view. */
    VIEW_NAME("viewName.keyword"),
    /** Unique name of the view in which this SQL asset exists, or empty if it does not exist within a view. */
    VIEW_QUALIFIED_NAME("viewQualifiedName"),
    /** TBC */
    VIEWER_GROUPS("viewerGroups"),
    /** TBC */
    VIEWER_USERS("viewerUsers"),
    /** TBC */
    VISUAL_BUILDER_SCHEMA_BASE64("visualBuilderSchemaBase64"),
    /** TBC */
    WEB_URL("webUrl"),
    /** TBC */
    WORKBOOK_QUALIFIED_NAME("workbookQualifiedName"),
    /** TBC */
    WORKSPACE_QUALIFIED_NAME("workspaceQualifiedName"),
    ;

    @Getter(onMethod_ = {@Override})
    private final String indexedFieldName;

    KeywordFields(String indexedFieldName) {
        this.indexedFieldName = indexedFieldName;
    }
}
