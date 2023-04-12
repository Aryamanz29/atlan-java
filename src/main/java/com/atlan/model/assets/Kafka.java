/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright 2022 Atlan Pte. Ltd. */
package com.atlan.model.assets;

import com.atlan.model.enums.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * TBC
 */
@Getter
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = KafkaTopic.class, name = KafkaTopic.TYPE_NAME),
    @JsonSubTypes.Type(value = KafkaConsumerGroup.class, name = KafkaConsumerGroup.TYPE_NAME),
})
public abstract class Kafka extends EventStore {

    public static final String TYPE_NAME = "Kafka";
}