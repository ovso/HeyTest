package io.github.ovso.heytest.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor public enum Status {
  FOR_SALE("for_sale"), ON_SALE("on_sale"), SOLD_OUT("sold_out");
  private String value;

  public static Status toStatus(String statusString) {
    for (Status status : Status.values()) {
      if (status.getValue().equals(statusString)) {
        return status;
      }
    }
    return Status.FOR_SALE;
  }
}
