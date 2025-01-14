/* SPDX-License-Identifier: Apache-2.0
   Copyright 2023 Atlan Pte. Ltd. */
import com.atlan.pkg.CustomConfig
import com.atlan.pkg.serde.WidgetSerde
import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import javax.annotation.processing.Generated

/**
 * Expected configuration for the Enrichment Migrator custom package.
 */
@Generated("com.atlan.pkg.CustomPackage")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class EnrichmentMigratorCfg(
    @JsonProperty("source_connection") val sourceConnection: String? = null,
    @JsonProperty("source_qn_prefix") val sourceQnPrefix: String? = null,
    @JsonProperty("target_connection") val targetConnection: String? = null,
    @JsonProperty("fail_on_errors") val failOnErrors: Boolean? = null,
    @JsonProperty("limit_type") val limitType: String? = null,
    @JsonDeserialize(using = WidgetSerde.MultiSelectDeserializer::class)
    @JsonSerialize(using = WidgetSerde.MultiSelectSerializer::class)
    @JsonProperty("attributes_list") val attributesList: List<String>? = null,
    @JsonProperty("cm_limit_type") val cmLimitType: String? = null,
    @JsonProperty("custom_metadata") val customMetadata: String? = null,
) : CustomConfig()
