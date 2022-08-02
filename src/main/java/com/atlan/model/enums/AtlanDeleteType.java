/* SPDX-License-Identifier: Apache-2.0 */
package com.atlan.model.enums;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

public enum AtlanDeleteType implements AtlanEnum {
  @SerializedName("HARD")
  HARD("HARD"),

  @SerializedName("SOFT")
  SOFT("SOFT"),

  @SerializedName("DEFAULT")
  DEFAULT("DEFAULT");

  @Getter(onMethod_ = {@Override})
  private final String value;

  AtlanDeleteType(String value) {
    this.value = value;
  }
}
