/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import java.util.Map;
import java.util.SortedSet;
import javax.annotation.processing.Generated;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Base class for resources.
 */
@Generated(value = "com.atlan.generators.ModelGeneratorV2")
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ReadmeTemplate.class, name = ReadmeTemplate.TYPE_NAME),
    @JsonSubTypes.Type(value = Readme.class, name = Readme.TYPE_NAME),
    @JsonSubTypes.Type(value = File.class, name = File.TYPE_NAME),
    @JsonSubTypes.Type(value = Link.class, name = Link.TYPE_NAME),
})
@Slf4j
@SuppressWarnings("cast")
public abstract class Resource extends Asset implements IResource, ICatalog, IAsset, IReferenceable {

    public static final String TYPE_NAME = "Resource";

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> inputToProcesses;

    /** TBC */
    @Attribute
    Boolean isGlobal;

    /** TBC */
    @Attribute
    String link;

    /** TBC */
    @Attribute
    @Singular
    SortedSet<ILineageProcess> outputFromProcesses;

    /** TBC */
    @Attribute
    String reference;

    /** TBC */
    @Attribute
    @Singular("putResourceMetadata")
    Map<String, String> resourceMetadata;
}
