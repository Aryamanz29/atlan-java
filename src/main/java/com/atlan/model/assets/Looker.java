/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import java.util.SortedSet;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Looker Assets
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = LookerLook.class, name = LookerLook.TYPE_NAME),
    @JsonSubTypes.Type(value = LookerDashboard.class, name = LookerDashboard.TYPE_NAME),
    @JsonSubTypes.Type(value = LookerFolder.class, name = LookerFolder.TYPE_NAME),
    @JsonSubTypes.Type(value = LookerTile.class, name = LookerTile.TYPE_NAME),
    @JsonSubTypes.Type(value = LookerModel.class, name = LookerModel.TYPE_NAME),
    @JsonSubTypes.Type(value = LookerExplore.class, name = LookerExplore.TYPE_NAME),
    @JsonSubTypes.Type(value = LookerProject.class, name = LookerProject.TYPE_NAME),
    @JsonSubTypes.Type(value = LookerQuery.class, name = LookerQuery.TYPE_NAME),
    @JsonSubTypes.Type(value = LookerField.class, name = LookerField.TYPE_NAME),
    @JsonSubTypes.Type(value = LookerView.class, name = LookerView.TYPE_NAME),
})
@Slf4j
public abstract class Looker extends Asset implements ILooker, IBI, ICatalog, IAsset, IReferenceable {

    public static final String TYPE_NAME = "Looker";

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;
}
