/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum KafkaTopicCompressionType implements AtlanEnum {
    UNCOMPRESSED("uncompressed"),
    ZSTD("zstd"),
    LZ4("lz4"),
    SNAPPY("snappy"),
    GZIP("gzip"),
    PRODUCER("producer");

    @JsonValue
    @Getter(onMethod_ = {@Override})
    private final String value;

    KafkaTopicCompressionType(String value) {
        this.value = value;
    }

    public static KafkaTopicCompressionType fromValue(String value) {
        for (KafkaTopicCompressionType b : KafkaTopicCompressionType.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        return null;
    }
}