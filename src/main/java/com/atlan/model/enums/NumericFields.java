/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2023 Atlan Pte. Ltd. */
package com.atlan.model.enums;

import lombok.Getter;

public enum NumericFields implements AtlanSearchableField {
    /** TBC */
    ADLS_OBJECT_ACCESS_TIER_LAST_MODIFIED_TIME("adlsObjectAccessTierLastModifiedTime"),
    /** TBC */
    ADLS_OBJECT_COUNT("adlsObjectCount"),
    /** TBC */
    ADLS_OBJECT_SIZE("adlsObjectSize"),
    /** Time (epoch) at which the announcement was last updated, in milliseconds. */
    ANNOUNCEMENT_UPDATED_AT("announcementUpdatedAt"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN("assetDbtJobLastRun"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_CREATED_AT("assetDbtJobLastRunCreatedAt"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_DEQUED_AT("assetDbtJobLastRunDequedAt"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_STARTED_AT("assetDbtJobLastRunStartedAt"),
    /** TBC */
    ASSET_DBT_JOB_LAST_RUN_UPDATED_AT("assetDbtJobLastRunUpdatedAt"),
    /** TBC */
    ASSET_DBT_JOB_NEXT_RUN("assetDbtJobNextRun"),
    /** Time (epoch) at which the certification was last updated, in milliseconds. */
    CERTIFICATE_UPDATED_AT("certificateUpdatedAt"),
    /** TBC */
    COLUMN_AVERAGE("columnAverage"),
    /** Average length of values in a string column. */
    COLUMN_AVERAGE_LENGTH("columnAverageLength"),
    /** Number of columns in this view. */
    COLUMN_COUNT("columnCount"),
    /** Number of rows that contain distinct values. */
    COLUMN_DISTINCT_VALUES_COUNT("columnDistinctValuesCount"),
    /** TBC */
    COLUMN_DISTINCT_VALUES_COUNT_LONG("columnDistinctValuesCountLong"),
    /** Number of rows that contain duplicate values. */
    COLUMN_DUPLICATE_VALUES_COUNT("columnDuplicateValuesCount"),
    /** TBC */
    COLUMN_DUPLICATE_VALUES_COUNT_LONG("columnDuplicateValuesCountLong"),
    /** Greatest value in a numeric column. */
    COLUMN_MAX("columnMax"),
    /** Length of the longest value in a string column. */
    COLUMN_MAXIMUM_STRING_LENGTH("columnMaximumStringLength"),
    /** Arithmetic mean of the values in a numeric column. */
    COLUMN_MEAN("columnMean"),
    /** Calculated median of the values in a numeric column. */
    COLUMN_MEDIAN("columnMedian"),
    /** Least value in a numeric column. */
    COLUMN_MIN("columnMin"),
    /** Length of the shortest value in a string column. */
    COLUMN_MINIMUM_STRING_LENGTH("columnMinimumStringLength"),
    /** Number of rows in a column that do not contain content. */
    COLUMN_MISSING_VALUES_COUNT("columnMissingValuesCount"),
    /** TBC */
    COLUMN_MISSING_VALUES_COUNT_LONG("columnMissingValuesCountLong"),
    /** Percentage of rows in a column that do not contain content. */
    COLUMN_MISSING_VALUES_PERCENTAGE("columnMissingValuesPercentage"),
    /** Calculated standard deviation of the values in a numeric column. */
    COLUMN_STANDARD_DEVIATION("columnStandardDeviation"),
    /** Calculated sum of the values in a numeric column. */
    COLUMN_SUM("columnSum"),
    /** Number of rows in which a value in this column appears only once. */
    COLUMN_UNIQUE_VALUES_COUNT("columnUniqueValuesCount"),
    /** TBC */
    COLUMN_UNIQUE_VALUES_COUNT_LONG("columnUniqueValuesCountLong"),
    /** Ratio indicating how unique data in the column is: 0 indicates that all values are the same, 100 indicates that all values in the column are unique. */
    COLUMN_UNIQUENESS_PERCENTAGE("columnUniquenessPercentage"),
    /** Calculated variance of the values in a numeric column. */
    COLUMN_VARIANCE("columnVariance"),
    /** TBC */
    DASHBOARD_COUNT("dashboardCount"),
    /** TBC */
    DATAFLOW_COUNT("dataflowCount"),
    /** TBC */
    DATASET_COUNT("datasetCount"),
    /** TBC */
    DBT_JOB_LAST_RUN("dbtJobLastRun"),
    /** TBC */
    DBT_JOB_NEXT_RUN("dbtJobNextRun"),
    /** TBC */
    DBT_MODEL_COLUMN_ORDER("dbtModelColumnOrder"),
    /** TBC */
    DBT_MODEL_COMPILE_COMPLETED_AT("dbtModelCompileCompletedAt"),
    /** TBC */
    DBT_MODEL_COMPILE_STARTED_AT("dbtModelCompileStartedAt"),
    /** TBC */
    DBT_MODEL_EXECUTE_COMPLETED_AT("dbtModelExecuteCompletedAt"),
    /** TBC */
    DBT_MODEL_EXECUTE_STARTED_AT("dbtModelExecuteStartedAt"),
    /** TBC */
    DBT_MODEL_EXECUTION_TIME("dbtModelExecutionTime"),
    /** TBC */
    DBT_MODEL_RUN_ELAPSED_TIME("dbtModelRunElapsedTime"),
    /** TBC */
    DBT_MODEL_RUN_GENERATED_AT("dbtModelRunGeneratedAt"),
    /** TBC */
    END_TIME("endTime"),
    /** Number of fields in the object. */
    FIELD_COUNT("fieldCount"),
    /** TBC */
    GCS_BUCKET_RETENTION_EFFECTIVE_TIME("gcsBucketRetentionEffectiveTime"),
    /** TBC */
    GCS_BUCKET_RETENTION_PERIOD("gcsBucketRetentionPeriod"),
    /** TBC */
    GCS_META_GENERATION_ID("gcsMetaGenerationId"),
    /** TBC */
    GCS_OBJECT_COUNT("gcsObjectCount"),
    /** TBC */
    GCS_OBJECT_DATA_LAST_MODIFIED_TIME("gcsObjectDataLastModifiedTime"),
    /** TBC */
    GCS_OBJECT_GENERATION_ID("gcsObjectGenerationId"),
    /** TBC */
    GCS_OBJECT_RETENTION_EXPIRATION_DATE("gcsObjectRetentionExpirationDate"),
    /** Object size in bytes. */
    GCS_OBJECT_SIZE("gcsObjectSize"),
    /** TBC */
    GOOGLE_PROJECT_NUMBER("googleProjectNumber"),
    /** Time (epoch) at which the asset was last profiled, in milliseconds. */
    LAST_PROFILED_AT("lastProfiledAt"),
    /** Timestamp of last operation that inserted, updated, or deleted rows. */
    LAST_ROW_CHANGED_AT("lastRowChangedAt"),
    /** Time (epoch) at which the asset was last crawled, in milliseconds. */
    LAST_SYNC_RUN_AT("lastSyncRunAt"),
    /** TBC */
    LOOK_ID("lookId"),
    /** TBC */
    LOOKER_TIMES_USED("lookerTimesUsed"),
    /** Maximum length of a value in this column. */
    MAX_LENGTH("maxLength"),
    /** TBC */
    METABASE_DASHBOARD_COUNT("metabaseDashboardCount"),
    /** TBC */
    METABASE_QUESTION_COUNT("metabaseQuestionCount"),
    /** TBC */
    MODE_CHART_COUNT("modeChartCount"),
    /** TBC */
    MODE_COLLECTION_COUNT("modeCollectionCount"),
    /** TBC */
    MODE_QUERY_COUNT("modeQueryCount"),
    /** TBC */
    MODE_REPORT_IMPORT_COUNT("modeReportImportCount"),
    /** TBC */
    MODE_REPORT_PUBLISHED_AT("modeReportPublishedAt"),
    /** Time (in milliseconds) when the asset was last updated. */
    MODIFICATION_TIMESTAMP("__modificationTimestamp"),
    /** Number of digits allowed to the right of the decimal point. */
    NUMERIC_SCALE("numericScale"),
    /** TBC */
    OPERATION_END_TIME("operationEndTime"),
    /** TBC */
    OPERATION_START_TIME("operationStartTime"),
    /** Order (position) in which the column appears in the table (starting at 1). */
    ORDER("order"),
    /** TBC */
    PAGE_COUNT("pageCount"),
    /** TBC */
    PARTITION_COUNT("partitionCount"),
    /** TBC */
    PARTITION_ORDER("partitionOrder"),
    /** TBC */
    PINNED_AT("pinnedAt"),
    /** Number of days over which popularity is calculated, for example 30 days. */
    POPULARITY_INSIGHTS_TIMEFRAME("popularityInsightsTimeframe"),
    /** TBC */
    POPULARITY_SCORE("popularityScore"),
    /** Port number to the connection's source. */
    PORT("port"),
    /** TBC */
    POWER_BI_TABLE_COLUMN_COUNT("powerBITableColumnCount"),
    /** TBC */
    POWER_BI_TABLE_MEASURE_COUNT("powerBITableMeasureCount"),
    /** Total number of digits allowed when the dataType is numeric. */
    PRECISION("precision"),
    /** Number of charts within the collection. */
    PRESET_DASHBOARD_CHART_COUNT("presetDashboardChartCount"),
    /** ID of the Preset asset's collection. */
    PRESET_DASHBOARD_ID("presetDashboardId"),
    /** ID of the dataset. */
    PRESET_DATASET_ID("presetDatasetId"),
    /** ID of the cluster for the Preset workspace. */
    PRESET_WORKSPACE_CLUSTER_ID("presetWorkspaceClusterId"),
    /** Number of collections in the workspace. */
    PRESET_WORKSPACE_DASHBOARD_COUNT("presetWorkspaceDashboardCount"),
    /** Number of datasets in the workspace. */
    PRESET_WORKSPACE_DATASET_COUNT("presetWorkspaceDatasetCount"),
    /** ID of the deployment for the Preset workspace. */
    PRESET_WORKSPACE_DEPLOYMENT_ID("presetWorkspaceDeploymentId"),
    /** ID of the Preset asset's workspace. */
    PRESET_WORKSPACE_ID("presetWorkspaceId"),
    /** TBC */
    QLIK_APP_STATIC_BYTE_SIZE("qlikAppStaticByteSize"),
    /** TBC */
    QUERY_COUNT("queryCount"),
    /** Time (epoch) at which the query count was last updated, in milliseconds. */
    QUERY_COUNT_UPDATED_AT("queryCountUpdatedAt"),
    /** TBC */
    QUERY_ID("queryID"),
    /** TBC */
    QUERY_USER_COUNT("queryUserCount"),
    /** Number of reports linked to the dashboard in Salesforce. */
    REPORT_COUNT("reportCount"),
    /** TBC */
    RESULT_COUNT("resultCount"),
    /** TBC */
    RESULT_MAKER_ID("resultMakerID"),
    /** Number of rows in this view. */
    ROW_COUNT("rowCount"),
    /** Maximum number of rows that can be returned for the source. */
    ROW_LIMIT("rowLimit"),
    /** Number of objects within the bucket. */
    S3OBJECT_COUNT("s3ObjectCount"),
    /** Time (epoch) at which the object was last updated, in milliseconds, or when it was created if it has never been modified. */
    S3OBJECT_LAST_MODIFIED_TIME("s3ObjectLastModifiedTime"),
    /** Object size in bytes. */
    S3OBJECT_SIZE("s3ObjectSize"),
    /** Number of schemas in this database. */
    SCHEMA_COUNT("schemaCount"),
    /** Number of data elements that exist within this page. */
    SIGMA_DATA_ELEMENT_COUNT("sigmaDataElementCount"),
    /** Number of data element fields within this data element. */
    SIGMA_DATA_ELEMENT_FIELD_COUNT("sigmaDataElementFieldCount"),
    /** Number of columns that exist within this dataset. */
    SIGMA_DATASET_COLUMN_COUNT("sigmaDatasetColumnCount"),
    /** Number of pages that exist within this workbook. */
    SIGMA_PAGE_COUNT("sigmaPageCount"),
    /** Size of the view in bytes. */
    SIZE_BYTES("sizeBytes"),
    /** TBC */
    SNOWFLAKE_STREAM_STALE_AFTER("snowflakeStreamStaleAfter"),
    /** TBC */
    SOURCE_CHILD_COUNT("sourceChildCount"),
    /** TBC */
    SOURCE_CONTENT_METADATA_ID("sourceContentMetadataId"),
    /** Time (epoch) at which the asset was created in the source system, in milliseconds. */
    SOURCE_CREATED_AT("sourceCreatedAt"),
    /** TBC */
    SOURCE_CREATOR_ID("sourceCreatorId"),
    /** TBC */
    SOURCE_LAST_ACCESSED_AT("sourceLastAccessedAt"),
    /** Timestamp of most recent read operation. */
    SOURCE_LAST_READ_AT("sourceLastReadAt"),
    /** TBC */
    SOURCE_LAST_VIEWED_AT("sourceLastViewedAt"),
    /** TBC */
    SOURCE_METADATA_ID("sourceMetadataId"),
    /** TBC */
    SOURCE_PARENT_ID("sourceParentID"),
    /** TBC */
    SOURCE_QUERY_ID("sourceQueryId"),
    /** Total count of all read operations at source. */
    SOURCE_READ_COUNT("sourceReadCount"),
    /** Total number of unique users that read data from asset. */
    SOURCE_READ_USER_COUNT("sourceReadUserCount"),
    /** Total cost of all operations at source. */
    SOURCE_TOTAL_COST("sourceTotalCost"),
    /** Time (epoch) at which the asset was last updated in the source system, in milliseconds. */
    SOURCE_UPDATED_AT("sourceUpdatedAt"),
    /** TBC */
    SOURCE_USER_ID("sourceUserId"),
    /** TBC */
    SOURCE_VIEW_COUNT("sourceViewCount"),
    /** TBC */
    SOURCELAST_UPDATER_ID("sourcelastUpdaterId"),
    /** TBC */
    STALE_SINCE_DATE("staleSinceDate"),
    /** TBC */
    START_TIME("startTime"),
    /** Number of tables in this schema. */
    TABLE_COUNT("tableCount"),
    /** TBC */
    TILE_COUNT("tileCount"),
    /** Time (in milliseconds) when the asset was created. */
    TIMESTAMP("__timestamp"),
    /** TBC */
    VIEW_SCORE("viewScore"),
    /** Number of views in this schema. */
    VIEW_COUNT("viewsCount"),
    ;

    @Getter(onMethod_ = {@Override})
    private final String indexedFieldName;

    NumericFields(String indexedFieldName) {
        this.indexedFieldName = indexedFieldName;
    }
}
