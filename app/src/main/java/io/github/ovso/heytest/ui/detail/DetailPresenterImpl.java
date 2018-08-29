package io.github.ovso.heytest.ui.detail;

import android.support.annotation.NonNull;
import io.github.ovso.heytest.data.network.model.Cars;
import io.github.ovso.heytest.utils.ResourceProvider;

public class DetailPresenterImpl implements DetailPresenter {
  private DetailPresenter.View view;
  private ResourceProvider resourceProvider;

  public DetailPresenterImpl(DetailPresenter.View $view, ResourceProvider $resourceProvider) {
    view = $view;
    resourceProvider = $resourceProvider;
  }

  @Override public void onCreate(@NonNull Cars cars) {
    view.showBackButton();
    view.showTitle(cars.getModel_part_name());
  }
}
