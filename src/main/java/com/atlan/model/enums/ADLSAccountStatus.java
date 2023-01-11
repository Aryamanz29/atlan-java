/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum ADLSAccountStatus implements AtlanEnum {
    AVAILABLE("Available"),
    UNAVAILABLE("Unavailable");

    @JsonValue
    @Getter(onMethod_ = {@Override})
    private final String value;

    ADLSAccountStatus(String value) {
        this.value = value;
    }

    public static ADLSAccountStatus fromValue(String value) {
        for (ADLSAccountStatus b : ADLSAccountStatus.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        return null;
    }
}
