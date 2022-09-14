/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.model.relations.GuidReference;
import com.atlan.model.relations.Reference;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Instance of a README in Atlan, with its detailed information.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class Readme extends Resource {
    private static final long serialVersionUID = 2L;

    public static final String TYPE_NAME = "Readme";

    /** Fixed typeName for READMEs. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /** Asset to which the README is linked. */
    @Attribute
    Reference asset;

    /**
     * Builds the minimal object necessary to create a README.
     *
     * @param assetTypeName type of the asset to which the README should be attached
     * @param assetGuid the GUID of the asset to which the README should be attached
     * @param assetName name of the asset to which the README should be attached
     * @param content the HTML content to use for the README
     * @return the minimal object necessary to create the README and attach it to the asset, as a builder
     */
    public static ReadmeBuilder<?, ?> creator(
            String assetTypeName, String assetGuid, String assetName, String content) {
        return Readme.builder()
                .qualifiedName(generateQualifiedName(assetGuid))
                .name(generateName(assetName))
                .description(content)
                .asset(GuidReference.to(assetTypeName, assetGuid));
    }

    /**
     * Builds the minimal object necessary to update a README.
     *
     * @param assetGuid the GUID of the asset to which the README is attached
     * @param assetName name of the asset to which the README is attached
     * @return the minimal object necessary to update the README, as a builder
     */
    public static ReadmeBuilder<?, ?> updater(String assetGuid, String assetName) {
        return Readme.builder().qualifiedName(generateQualifiedName(assetGuid)).name(generateName(assetName));
    }

    /**
     * Builds the minimal object necessary to apply an update to a readme, from a potentially
     * more-complete readme object.
     *
     * @return the minimal object necessary to update the readme, as a builder
     */
    @Override
    protected ReadmeBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }

    /**
     * Generate a unique README name.
     * @param assetGuid GUID of the asset to which the README should be attached
     * @return a unique name for the README
     */
    private static String generateQualifiedName(String assetGuid) {
        return assetGuid + "/readme";
    }

    /**
     * Generate a readable README name (although this does not appear anywhere in the UI).
     * @param assetName name of the asset to which the README should be attached
     * @return a readable name for the README
     */
    private static String generateName(String assetName) {
        return assetName + " Readme";
    }
}