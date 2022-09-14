/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Instance of an asset where we cannot determine (have not yet modeled) its detailed information.
 * In the meanwhile, this provides a catch-all case where at least the basic asset information is
 * available.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class IndistinctAsset extends Asset {
    private static final long serialVersionUID = 2L;

    /** Create a non-transient typeName to ensure it is included in serde. */
    @Getter(onMethod_ = {@Override})
    @Setter(onMethod_ = {@Override})
    @Builder.Default
    String typeName = TYPE_NAME;

    /**
     * Builds the minimal object necessary to update an asset that is not yet strongly typed.
     *
     * @param qualifiedName of the asset
     * @param name of the asset
     * @return the minimal request necessary to update the asset, as a builder
     */
    public static IndistinctAssetBuilder<?, ?> updater(String qualifiedName, String name) {
        return IndistinctAsset.builder().qualifiedName(qualifiedName).name(name);
    }

    /**
     * Builds the minimal object necessary to apply an update to an asset that is not yet strongly typed,
     * from a potentially more-complete asset object.
     *
     * @return the minimal object necessary to update the asset, as a builder
     */
    @Override
    protected IndistinctAssetBuilder<?, ?> trimToRequired() {
        return updater(this.getQualifiedName(), this.getName());
    }
}