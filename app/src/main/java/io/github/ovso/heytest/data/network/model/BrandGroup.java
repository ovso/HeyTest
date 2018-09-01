package io.github.ovso.heytest.data.network.model;

import java.util.List;
import lombok.Getter;

@Getter public class BrandGroup extends Brand {
  private List<ModelGroup> model_groups;
}
