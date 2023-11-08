/* SPDX-License-Identifier: Apache-2.0
   Copyright 2023 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.model.enums.AtlanAnnouncementType;
import com.atlan.model.enums.AtlanConnectorType;
import com.atlan.model.enums.AtlanIcon;
import com.atlan.model.enums.AtlanStatus;
import com.atlan.model.enums.CertificateStatus;
import com.atlan.model.enums.SourceCostUnitType;
import com.atlan.model.fields.RelationField;
import com.atlan.model.relations.UniqueAttributes;
import com.atlan.model.structs.PopularityInsights;
import com.atlan.model.structs.StarredDetails;
import com.atlan.serde.AssetDeserializer;
import com.atlan.serde.AssetSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.processing.Generated;

/**
 * Base class for catalog assets. Catalog assets include any asset that can participate in lineage.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@JsonSerialize(using = AssetSerializer.class)
@JsonDeserialize(using = AssetDeserializer.class)
public interface ICatalog {

    public static final String TYPE_NAME = "Catalog";

    /** TBC */
    RelationField INPUT_TO_AIRFLOW_TASKS = new RelationField("inputToAirflowTasks");

    /** Processes to which this asset provides input. */
    RelationField INPUT_TO_PROCESSES = new RelationField("inputToProcesses");

    /** TBC */
    RelationField OUTPUT_FROM_AIRFLOW_TASKS = new RelationField("outputFromAirflowTasks");

    /** Processes from which this asset is produced as output. */
    RelationField OUTPUT_FROM_PROCESSES = new RelationField("outputFromProcesses");

    /**
     * Reference to an asset by its qualifiedName.
     *
     * @param typeName the type of the asset being referenced
     * @param qualifiedName the qualifiedName of the asset to reference
     * @return reference to an asset that can be used for defining a lineage relationship to the asset
     */
    public static ICatalog getLineageReference(String typeName, String qualifiedName) {
        ICatalog ref = null;
        switch (typeName) {
            case ADLSAccount.TYPE_NAME:
                ref = ADLSAccount.refByQualifiedName(qualifiedName);
                break;
            case ADLSContainer.TYPE_NAME:
                ref = ADLSContainer.refByQualifiedName(qualifiedName);
                break;
            case ADLSObject.TYPE_NAME:
                ref = ADLSObject.refByQualifiedName(qualifiedName);
                break;
            case APIPath.TYPE_NAME:
                ref = APIPath.refByQualifiedName(qualifiedName);
                break;
            case APISpec.TYPE_NAME:
                ref = APISpec.refByQualifiedName(qualifiedName);
                break;
            case AirflowDag.TYPE_NAME:
                ref = AirflowDag.refByQualifiedName(qualifiedName);
                break;
            case AirflowTask.TYPE_NAME:
                ref = AirflowTask.refByQualifiedName(qualifiedName);
                break;
            case AtlanQuery.TYPE_NAME:
                ref = AtlanQuery.refByQualifiedName(qualifiedName);
                break;
            case AzureEventHub.TYPE_NAME:
                ref = AzureEventHub.refByQualifiedName(qualifiedName);
                break;
            case AzureEventHubConsumerGroup.TYPE_NAME:
                ref = AzureEventHubConsumerGroup.refByQualifiedName(qualifiedName);
                break;
            case Column.TYPE_NAME:
                ref = Column.refByQualifiedName(qualifiedName);
                break;
            case DataStudioAsset.TYPE_NAME:
                ref = DataStudioAsset.refByQualifiedName(qualifiedName);
                break;
            case Database.TYPE_NAME:
                ref = Database.refByQualifiedName(qualifiedName);
                break;
            case DbtColumnProcess.TYPE_NAME:
                ref = DbtColumnProcess.refByQualifiedName(qualifiedName);
                break;
            case DbtMetric.TYPE_NAME:
                ref = DbtMetric.refByQualifiedName(qualifiedName);
                break;
            case DbtModel.TYPE_NAME:
                ref = DbtModel.refByQualifiedName(qualifiedName);
                break;
            case DbtModelColumn.TYPE_NAME:
                ref = DbtModelColumn.refByQualifiedName(qualifiedName);
                break;
            case DbtProcess.TYPE_NAME:
                ref = DbtProcess.refByQualifiedName(qualifiedName);
                break;
            case DbtSource.TYPE_NAME:
                ref = DbtSource.refByQualifiedName(qualifiedName);
                break;
            case DbtTag.TYPE_NAME:
                ref = DbtTag.refByQualifiedName(qualifiedName);
                break;
            case DbtTest.TYPE_NAME:
                ref = DbtTest.refByQualifiedName(qualifiedName);
                break;
            case File.TYPE_NAME:
                ref = File.refByQualifiedName(qualifiedName);
                break;
            case Function.TYPE_NAME:
                ref = Function.refByQualifiedName(qualifiedName);
                break;
            case GCSBucket.TYPE_NAME:
                ref = GCSBucket.refByQualifiedName(qualifiedName);
                break;
            case GCSObject.TYPE_NAME:
                ref = GCSObject.refByQualifiedName(qualifiedName);
                break;
            case Insight.TYPE_NAME:
                ref = Insight.refByQualifiedName(qualifiedName);
                break;
            case KafkaConsumerGroup.TYPE_NAME:
                ref = KafkaConsumerGroup.refByQualifiedName(qualifiedName);
                break;
            case KafkaTopic.TYPE_NAME:
                ref = KafkaTopic.refByQualifiedName(qualifiedName);
                break;
            case Link.TYPE_NAME:
                ref = Link.refByQualifiedName(qualifiedName);
                break;
            case LookerDashboard.TYPE_NAME:
                ref = LookerDashboard.refByQualifiedName(qualifiedName);
                break;
            case LookerExplore.TYPE_NAME:
                ref = LookerExplore.refByQualifiedName(qualifiedName);
                break;
            case LookerField.TYPE_NAME:
                ref = LookerField.refByQualifiedName(qualifiedName);
                break;
            case LookerFolder.TYPE_NAME:
                ref = LookerFolder.refByQualifiedName(qualifiedName);
                break;
            case LookerLook.TYPE_NAME:
                ref = LookerLook.refByQualifiedName(qualifiedName);
                break;
            case LookerModel.TYPE_NAME:
                ref = LookerModel.refByQualifiedName(qualifiedName);
                break;
            case LookerProject.TYPE_NAME:
                ref = LookerProject.refByQualifiedName(qualifiedName);
                break;
            case LookerQuery.TYPE_NAME:
                ref = LookerQuery.refByQualifiedName(qualifiedName);
                break;
            case LookerTile.TYPE_NAME:
                ref = LookerTile.refByQualifiedName(qualifiedName);
                break;
            case LookerView.TYPE_NAME:
                ref = LookerView.refByQualifiedName(qualifiedName);
                break;
            case MCIncident.TYPE_NAME:
                ref = MCIncident.refByQualifiedName(qualifiedName);
                break;
            case MCMonitor.TYPE_NAME:
                ref = MCMonitor.refByQualifiedName(qualifiedName);
                break;
            case MaterializedView.TYPE_NAME:
                ref = MaterializedView.refByQualifiedName(qualifiedName);
                break;
            case MatillionComponent.TYPE_NAME:
                ref = MatillionComponent.refByQualifiedName(qualifiedName);
                break;
            case MatillionGroup.TYPE_NAME:
                ref = MatillionGroup.refByQualifiedName(qualifiedName);
                break;
            case MatillionJob.TYPE_NAME:
                ref = MatillionJob.refByQualifiedName(qualifiedName);
                break;
            case MatillionProject.TYPE_NAME:
                ref = MatillionProject.refByQualifiedName(qualifiedName);
                break;
            case MetabaseCollection.TYPE_NAME:
                ref = MetabaseCollection.refByQualifiedName(qualifiedName);
                break;
            case MetabaseDashboard.TYPE_NAME:
                ref = MetabaseDashboard.refByQualifiedName(qualifiedName);
                break;
            case MetabaseQuestion.TYPE_NAME:
                ref = MetabaseQuestion.refByQualifiedName(qualifiedName);
                break;
            case MicroStrategyAttribute.TYPE_NAME:
                ref = MicroStrategyAttribute.refByQualifiedName(qualifiedName);
                break;
            case MicroStrategyCube.TYPE_NAME:
                ref = MicroStrategyCube.refByQualifiedName(qualifiedName);
                break;
            case MicroStrategyDocument.TYPE_NAME:
                ref = MicroStrategyDocument.refByQualifiedName(qualifiedName);
                break;
            case MicroStrategyDossier.TYPE_NAME:
                ref = MicroStrategyDossier.refByQualifiedName(qualifiedName);
                break;
            case MicroStrategyFact.TYPE_NAME:
                ref = MicroStrategyFact.refByQualifiedName(qualifiedName);
                break;
            case MicroStrategyMetric.TYPE_NAME:
                ref = MicroStrategyMetric.refByQualifiedName(qualifiedName);
                break;
            case MicroStrategyProject.TYPE_NAME:
                ref = MicroStrategyProject.refByQualifiedName(qualifiedName);
                break;
            case MicroStrategyReport.TYPE_NAME:
                ref = MicroStrategyReport.refByQualifiedName(qualifiedName);
                break;
            case MicroStrategyVisualization.TYPE_NAME:
                ref = MicroStrategyVisualization.refByQualifiedName(qualifiedName);
                break;
            case ModeChart.TYPE_NAME:
                ref = ModeChart.refByQualifiedName(qualifiedName);
                break;
            case ModeCollection.TYPE_NAME:
                ref = ModeCollection.refByQualifiedName(qualifiedName);
                break;
            case ModeQuery.TYPE_NAME:
                ref = ModeQuery.refByQualifiedName(qualifiedName);
                break;
            case ModeReport.TYPE_NAME:
                ref = ModeReport.refByQualifiedName(qualifiedName);
                break;
            case ModeWorkspace.TYPE_NAME:
                ref = ModeWorkspace.refByQualifiedName(qualifiedName);
                break;
            case MongoDBCollection.TYPE_NAME:
                ref = MongoDBCollection.refByQualifiedName(qualifiedName);
                break;
            case MongoDBDatabase.TYPE_NAME:
                ref = MongoDBDatabase.refByQualifiedName(qualifiedName);
                break;
            case PowerBIColumn.TYPE_NAME:
                ref = PowerBIColumn.refByQualifiedName(qualifiedName);
                break;
            case PowerBIDashboard.TYPE_NAME:
                ref = PowerBIDashboard.refByQualifiedName(qualifiedName);
                break;
            case PowerBIDataflow.TYPE_NAME:
                ref = PowerBIDataflow.refByQualifiedName(qualifiedName);
                break;
            case PowerBIDataset.TYPE_NAME:
                ref = PowerBIDataset.refByQualifiedName(qualifiedName);
                break;
            case PowerBIDatasource.TYPE_NAME:
                ref = PowerBIDatasource.refByQualifiedName(qualifiedName);
                break;
            case PowerBIMeasure.TYPE_NAME:
                ref = PowerBIMeasure.refByQualifiedName(qualifiedName);
                break;
            case PowerBIPage.TYPE_NAME:
                ref = PowerBIPage.refByQualifiedName(qualifiedName);
                break;
            case PowerBIReport.TYPE_NAME:
                ref = PowerBIReport.refByQualifiedName(qualifiedName);
                break;
            case PowerBITable.TYPE_NAME:
                ref = PowerBITable.refByQualifiedName(qualifiedName);
                break;
            case PowerBITile.TYPE_NAME:
                ref = PowerBITile.refByQualifiedName(qualifiedName);
                break;
            case PowerBIWorkspace.TYPE_NAME:
                ref = PowerBIWorkspace.refByQualifiedName(qualifiedName);
                break;
            case PresetChart.TYPE_NAME:
                ref = PresetChart.refByQualifiedName(qualifiedName);
                break;
            case PresetDashboard.TYPE_NAME:
                ref = PresetDashboard.refByQualifiedName(qualifiedName);
                break;
            case PresetDataset.TYPE_NAME:
                ref = PresetDataset.refByQualifiedName(qualifiedName);
                break;
            case PresetWorkspace.TYPE_NAME:
                ref = PresetWorkspace.refByQualifiedName(qualifiedName);
                break;
            case Procedure.TYPE_NAME:
                ref = Procedure.refByQualifiedName(qualifiedName);
                break;
            case QlikApp.TYPE_NAME:
                ref = QlikApp.refByQualifiedName(qualifiedName);
                break;
            case QlikChart.TYPE_NAME:
                ref = QlikChart.refByQualifiedName(qualifiedName);
                break;
            case QlikDataset.TYPE_NAME:
                ref = QlikDataset.refByQualifiedName(qualifiedName);
                break;
            case QlikSheet.TYPE_NAME:
                ref = QlikSheet.refByQualifiedName(qualifiedName);
                break;
            case QlikSpace.TYPE_NAME:
                ref = QlikSpace.refByQualifiedName(qualifiedName);
                break;
            case QlikStream.TYPE_NAME:
                ref = QlikStream.refByQualifiedName(qualifiedName);
                break;
            case QuickSightAnalysis.TYPE_NAME:
                ref = QuickSightAnalysis.refByQualifiedName(qualifiedName);
                break;
            case QuickSightAnalysisVisual.TYPE_NAME:
                ref = QuickSightAnalysisVisual.refByQualifiedName(qualifiedName);
                break;
            case QuickSightDashboard.TYPE_NAME:
                ref = QuickSightDashboard.refByQualifiedName(qualifiedName);
                break;
            case QuickSightDashboardVisual.TYPE_NAME:
                ref = QuickSightDashboardVisual.refByQualifiedName(qualifiedName);
                break;
            case QuickSightDataset.TYPE_NAME:
                ref = QuickSightDataset.refByQualifiedName(qualifiedName);
                break;
            case QuickSightDatasetField.TYPE_NAME:
                ref = QuickSightDatasetField.refByQualifiedName(qualifiedName);
                break;
            case QuickSightFolder.TYPE_NAME:
                ref = QuickSightFolder.refByQualifiedName(qualifiedName);
                break;
            case Readme.TYPE_NAME:
                ref = Readme.refByQualifiedName(qualifiedName);
                break;
            case ReadmeTemplate.TYPE_NAME:
                ref = ReadmeTemplate.refByQualifiedName(qualifiedName);
                break;
            case RedashDashboard.TYPE_NAME:
                ref = RedashDashboard.refByQualifiedName(qualifiedName);
                break;
            case RedashQuery.TYPE_NAME:
                ref = RedashQuery.refByQualifiedName(qualifiedName);
                break;
            case RedashVisualization.TYPE_NAME:
                ref = RedashVisualization.refByQualifiedName(qualifiedName);
                break;
            case S3Bucket.TYPE_NAME:
                ref = S3Bucket.refByQualifiedName(qualifiedName);
                break;
            case S3Object.TYPE_NAME:
                ref = S3Object.refByQualifiedName(qualifiedName);
                break;
            case SalesforceDashboard.TYPE_NAME:
                ref = SalesforceDashboard.refByQualifiedName(qualifiedName);
                break;
            case SalesforceField.TYPE_NAME:
                ref = SalesforceField.refByQualifiedName(qualifiedName);
                break;
            case SalesforceObject.TYPE_NAME:
                ref = SalesforceObject.refByQualifiedName(qualifiedName);
                break;
            case SalesforceOrganization.TYPE_NAME:
                ref = SalesforceOrganization.refByQualifiedName(qualifiedName);
                break;
            case SalesforceReport.TYPE_NAME:
                ref = SalesforceReport.refByQualifiedName(qualifiedName);
                break;
            case Schema.TYPE_NAME:
                ref = Schema.refByQualifiedName(qualifiedName);
                break;
            case SchemaRegistrySubject.TYPE_NAME:
                ref = SchemaRegistrySubject.refByQualifiedName(qualifiedName);
                break;
            case SigmaDataElement.TYPE_NAME:
                ref = SigmaDataElement.refByQualifiedName(qualifiedName);
                break;
            case SigmaDataElementField.TYPE_NAME:
                ref = SigmaDataElementField.refByQualifiedName(qualifiedName);
                break;
            case SigmaDataset.TYPE_NAME:
                ref = SigmaDataset.refByQualifiedName(qualifiedName);
                break;
            case SigmaDatasetColumn.TYPE_NAME:
                ref = SigmaDatasetColumn.refByQualifiedName(qualifiedName);
                break;
            case SigmaPage.TYPE_NAME:
                ref = SigmaPage.refByQualifiedName(qualifiedName);
                break;
            case SigmaWorkbook.TYPE_NAME:
                ref = SigmaWorkbook.refByQualifiedName(qualifiedName);
                break;
            case SisenseDashboard.TYPE_NAME:
                ref = SisenseDashboard.refByQualifiedName(qualifiedName);
                break;
            case SisenseDatamodel.TYPE_NAME:
                ref = SisenseDatamodel.refByQualifiedName(qualifiedName);
                break;
            case SisenseDatamodelTable.TYPE_NAME:
                ref = SisenseDatamodelTable.refByQualifiedName(qualifiedName);
                break;
            case SisenseFolder.TYPE_NAME:
                ref = SisenseFolder.refByQualifiedName(qualifiedName);
                break;
            case SisenseWidget.TYPE_NAME:
                ref = SisenseWidget.refByQualifiedName(qualifiedName);
                break;
            case SnowflakeDynamicTable.TYPE_NAME:
                ref = SnowflakeDynamicTable.refByQualifiedName(qualifiedName);
                break;
            case SnowflakePipe.TYPE_NAME:
                ref = SnowflakePipe.refByQualifiedName(qualifiedName);
                break;
            case SnowflakeStream.TYPE_NAME:
                ref = SnowflakeStream.refByQualifiedName(qualifiedName);
                break;
            case SnowflakeTag.TYPE_NAME:
                ref = SnowflakeTag.refByQualifiedName(qualifiedName);
                break;
            case SodaCheck.TYPE_NAME:
                ref = SodaCheck.refByQualifiedName(qualifiedName);
                break;
            case Table.TYPE_NAME:
                ref = Table.refByQualifiedName(qualifiedName);
                break;
            case TablePartition.TYPE_NAME:
                ref = TablePartition.refByQualifiedName(qualifiedName);
                break;
            case TableauCalculatedField.TYPE_NAME:
                ref = TableauCalculatedField.refByQualifiedName(qualifiedName);
                break;
            case TableauDashboard.TYPE_NAME:
                ref = TableauDashboard.refByQualifiedName(qualifiedName);
                break;
            case TableauDatasource.TYPE_NAME:
                ref = TableauDatasource.refByQualifiedName(qualifiedName);
                break;
            case TableauDatasourceField.TYPE_NAME:
                ref = TableauDatasourceField.refByQualifiedName(qualifiedName);
                break;
            case TableauFlow.TYPE_NAME:
                ref = TableauFlow.refByQualifiedName(qualifiedName);
                break;
            case TableauMetric.TYPE_NAME:
                ref = TableauMetric.refByQualifiedName(qualifiedName);
                break;
            case TableauProject.TYPE_NAME:
                ref = TableauProject.refByQualifiedName(qualifiedName);
                break;
            case TableauSite.TYPE_NAME:
                ref = TableauSite.refByQualifiedName(qualifiedName);
                break;
            case TableauWorkbook.TYPE_NAME:
                ref = TableauWorkbook.refByQualifiedName(qualifiedName);
                break;
            case TableauWorksheet.TYPE_NAME:
                ref = TableauWorksheet.refByQualifiedName(qualifiedName);
                break;
            case ThoughtspotAnswer.TYPE_NAME:
                ref = ThoughtspotAnswer.refByQualifiedName(qualifiedName);
                break;
            case ThoughtspotDashlet.TYPE_NAME:
                ref = ThoughtspotDashlet.refByQualifiedName(qualifiedName);
                break;
            case ThoughtspotLiveboard.TYPE_NAME:
                ref = ThoughtspotLiveboard.refByQualifiedName(qualifiedName);
                break;
            case View.TYPE_NAME:
                ref = View.refByQualifiedName(qualifiedName);
                break;
            default:
                // Do nothing — not a supported Catalog subtype
                break;
        }
        return ref;
    }

    /** TBC */
    SortedSet<String> getAdminGroups();

    /** TBC */
    SortedSet<String> getAdminRoles();

    /** TBC */
    SortedSet<String> getAdminUsers();

    /** TBC */
    String getAnnouncementMessage();

    /** TBC */
    String getAnnouncementTitle();

    /** TBC */
    AtlanAnnouncementType getAnnouncementType();

    /** TBC */
    Long getAnnouncementUpdatedAt();

    /** TBC */
    String getAnnouncementUpdatedBy();

    /** TBC */
    String getAssetDbtAccountName();

    /** TBC */
    String getAssetDbtAlias();

    /** TBC */
    String getAssetDbtEnvironmentDbtVersion();

    /** TBC */
    String getAssetDbtEnvironmentName();

    /** TBC */
    Long getAssetDbtJobLastRun();

    /** TBC */
    String getAssetDbtJobLastRunArtifactS3Path();

    /** TBC */
    Boolean getAssetDbtJobLastRunArtifactsSaved();

    /** TBC */
    Long getAssetDbtJobLastRunCreatedAt();

    /** TBC */
    Long getAssetDbtJobLastRunDequedAt();

    /** TBC */
    String getAssetDbtJobLastRunExecutedByThreadId();

    /** TBC */
    String getAssetDbtJobLastRunGitBranch();

    /** TBC */
    String getAssetDbtJobLastRunGitSha();

    /** TBC */
    Boolean getAssetDbtJobLastRunHasDocsGenerated();

    /** TBC */
    Boolean getAssetDbtJobLastRunHasSourcesGenerated();

    /** TBC */
    Boolean getAssetDbtJobLastRunNotificationsSent();

    /** TBC */
    String getAssetDbtJobLastRunOwnerThreadId();

    /** TBC */
    String getAssetDbtJobLastRunQueuedDuration();

    /** TBC */
    String getAssetDbtJobLastRunQueuedDurationHumanized();

    /** TBC */
    String getAssetDbtJobLastRunRunDuration();

    /** TBC */
    String getAssetDbtJobLastRunRunDurationHumanized();

    /** TBC */
    Long getAssetDbtJobLastRunStartedAt();

    /** TBC */
    String getAssetDbtJobLastRunStatusMessage();

    /** TBC */
    String getAssetDbtJobLastRunTotalDuration();

    /** TBC */
    String getAssetDbtJobLastRunTotalDurationHumanized();

    /** TBC */
    Long getAssetDbtJobLastRunUpdatedAt();

    /** TBC */
    String getAssetDbtJobLastRunUrl();

    /** TBC */
    String getAssetDbtJobName();

    /** TBC */
    Long getAssetDbtJobNextRun();

    /** TBC */
    String getAssetDbtJobNextRunHumanized();

    /** TBC */
    String getAssetDbtJobSchedule();

    /** TBC */
    String getAssetDbtJobScheduleCronHumanized();

    /** TBC */
    String getAssetDbtJobStatus();

    /** TBC */
    String getAssetDbtMeta();

    /** TBC */
    String getAssetDbtPackageName();

    /** TBC */
    String getAssetDbtProjectName();

    /** TBC */
    String getAssetDbtSemanticLayerProxyUrl();

    /** TBC */
    String getAssetDbtSourceFreshnessCriteria();

    /** TBC */
    SortedSet<String> getAssetDbtTags();

    /** TBC */
    String getAssetDbtTestStatus();

    /** TBC */
    String getAssetDbtUniqueId();

    /** TBC */
    AtlanIcon getAssetIcon();

    /** TBC */
    SortedSet<String> getAssetMcIncidentNames();

    /** TBC */
    SortedSet<String> getAssetMcIncidentQualifiedNames();

    /** TBC */
    SortedSet<String> getAssetMcIncidentSeverities();

    /** TBC */
    SortedSet<String> getAssetMcIncidentStates();

    /** TBC */
    SortedSet<String> getAssetMcIncidentSubTypes();

    /** TBC */
    SortedSet<String> getAssetMcIncidentTypes();

    /** TBC */
    Long getAssetMcLastSyncRunAt();

    /** TBC */
    SortedSet<String> getAssetMcMonitorNames();

    /** TBC */
    SortedSet<String> getAssetMcMonitorQualifiedNames();

    /** TBC */
    SortedSet<String> getAssetMcMonitorScheduleTypes();

    /** TBC */
    SortedSet<String> getAssetMcMonitorStatuses();

    /** TBC */
    SortedSet<String> getAssetMcMonitorTypes();

    /** TBC */
    Long getAssetSodaCheckCount();

    /** TBC */
    String getAssetSodaCheckStatuses();

    /** TBC */
    String getAssetSodaDQStatus();

    /** TBC */
    Long getAssetSodaLastScanAt();

    /** TBC */
    Long getAssetSodaLastSyncRunAt();

    /** TBC */
    String getAssetSodaSourceURL();

    /** TBC */
    SortedSet<String> getAssetTags();

    /** Glossary terms that are linked to this asset. */
    SortedSet<IGlossaryTerm> getAssignedTerms();

    /** TBC */
    CertificateStatus getCertificateStatus();

    /** TBC */
    String getCertificateStatusMessage();

    /** TBC */
    Long getCertificateUpdatedAt();

    /** TBC */
    String getCertificateUpdatedBy();

    /** TBC */
    String getConnectionName();

    /** TBC */
    String getConnectionQualifiedName();

    /** TBC */
    AtlanConnectorType getConnectorType();

    /** TBC */
    String getDbtQualifiedName();

    /** TBC */
    String getDescription();

    /** TBC */
    String getDisplayName();

    /** TBC */
    SortedSet<IFile> getFiles();

    /** TBC */
    Boolean getHasLineage();

    /** TBC */
    SortedSet<IAirflowTask> getInputToAirflowTasks();

    /** Processes to which this asset provides input. */
    SortedSet<ILineageProcess> getInputToProcesses();

    /** TBC */
    Boolean getIsAIGenerated();

    /** TBC */
    Boolean getIsDiscoverable();

    /** TBC */
    Boolean getIsEditable();

    /** TBC */
    Long getLastRowChangedAt();

    /** TBC */
    String getLastSyncRun();

    /** TBC */
    Long getLastSyncRunAt();

    /** TBC */
    String getLastSyncWorkflowName();

    /** Links that are attached to this asset. */
    SortedSet<ILink> getLinks();

    /** TBC */
    SortedSet<IMCIncident> getMcIncidents();

    /** Monitors that observe this asset. */
    SortedSet<IMCMonitor> getMcMonitors();

    /** TBC */
    SortedSet<IMetric> getMetrics();

    /** TBC */
    String getName();

    /** TBC */
    SortedSet<IAirflowTask> getOutputFromAirflowTasks();

    /** Processes from which this asset is produced as output. */
    SortedSet<ILineageProcess> getOutputFromProcesses();

    /** TBC */
    SortedSet<String> getOwnerGroups();

    /** TBC */
    SortedSet<String> getOwnerUsers();

    /** TBC */
    Double getPopularityScore();

    /** TBC */
    String getQualifiedName();

    /** README that is linked to this asset. */
    IReadme getReadme();

    /** TBC */
    String getSampleDataUrl();

    /** TBC */
    SortedSet<ISchemaRegistrySubject> getSchemaRegistrySubjects();

    /** TBC */
    SortedSet<ISodaCheck> getSodaChecks();

    /** TBC */
    SourceCostUnitType getSourceCostUnit();

    /** TBC */
    Long getSourceCreatedAt();

    /** TBC */
    String getSourceCreatedBy();

    /** TBC */
    String getSourceEmbedURL();

    /** TBC */
    Long getSourceLastReadAt();

    /** TBC */
    String getSourceOwners();

    /** TBC */
    List<PopularityInsights> getSourceQueryComputeCostRecords();

    /** TBC */
    SortedSet<String> getSourceQueryComputeCosts();

    /** TBC */
    Long getSourceReadCount();

    /** TBC */
    List<PopularityInsights> getSourceReadExpensiveQueryRecords();

    /** TBC */
    List<PopularityInsights> getSourceReadPopularQueryRecords();

    /** TBC */
    Double getSourceReadQueryCost();

    /** TBC */
    List<PopularityInsights> getSourceReadRecentUserRecords();

    /** TBC */
    SortedSet<String> getSourceReadRecentUsers();

    /** TBC */
    List<PopularityInsights> getSourceReadSlowQueryRecords();

    /** TBC */
    List<PopularityInsights> getSourceReadTopUserRecords();

    /** TBC */
    SortedSet<String> getSourceReadTopUsers();

    /** TBC */
    Long getSourceReadUserCount();

    /** TBC */
    Double getSourceTotalCost();

    /** TBC */
    String getSourceURL();

    /** TBC */
    Long getSourceUpdatedAt();

    /** TBC */
    String getSourceUpdatedBy();

    /** TBC */
    SortedSet<String> getStarredBy();

    /** TBC */
    Integer getStarredCount();

    /** TBC */
    List<StarredDetails> getStarredDetails();

    /** TBC */
    String getSubType();

    /** TBC */
    String getTenantId();

    /** TBC */
    String getUserDescription();

    /** TBC */
    Double getViewScore();

    /** TBC */
    SortedSet<String> getViewerGroups();

    /** TBC */
    SortedSet<String> getViewerUsers();

    /** Name of the type that defines the asset. */
    String getTypeName();

    /** Globally-unique identifier for the asset. */
    String getGuid();

    /** Human-readable name of the asset. */
    String getDisplayText();

    /** Status of the asset (if this is a related asset). */
    String getEntityStatus();

    /** Type of the relationship (if this is a related asset). */
    String getRelationshipType();

    /** Unique identifier of the relationship (when this is a related asset). */
    String getRelationshipGuid();

    /** Status of the relationship (when this is a related asset). */
    AtlanStatus getRelationshipStatus();

    /** Attributes specific to the relationship (unused). */
    Map<String, Object> getRelationshipAttributes();

    /**
     * Attribute(s) that uniquely identify the asset (when this is a related asset).
     * If the guid is not provided, these must be provided.
     */
    UniqueAttributes getUniqueAttributes();

    /**
     * When true, indicates that this object represents a complete view of the entity.
     * When false, this object is only a reference or some partial view of the entity.
     */
    boolean isComplete();

    /**
     * Indicates whether this object can be used as a valid reference by GUID.
     * @return true if it is a valid GUID reference, false otherwise
     */
    boolean isValidReferenceByGuid();

    /**
     * Indicates whether this object can be used as a valid reference by qualifiedName.
     * @return true if it is a valid qualifiedName reference, false otherwise
     */
    boolean isValidReferenceByQualifiedName();
}