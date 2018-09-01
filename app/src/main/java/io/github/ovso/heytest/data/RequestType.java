package io.github.ovso.heytest.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor public enum RequestType {
  ALL(1), SINGLE(2);
  private int value;
}
