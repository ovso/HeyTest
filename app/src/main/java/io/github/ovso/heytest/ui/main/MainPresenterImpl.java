package io.github.ovso.heytest.ui.main;

import io.github.ovso.heytest.R;
import io.github.ovso.heytest.utils.ResourceProvider;

public class MainPresenterImpl implements MainPresenter {

  private MainPresenter.View view;
  private ResourceProvider resourceProvider;

  public MainPresenterImpl(MainPresenter.View $view, ResourceProvider $ResourceProvider) {
    view = $view;
    resourceProvider = $ResourceProvider;
  }

  @Override public void onCreated() {
    view.showSearchText(resourceProvider.getString(R.string.car_search));
  }

  @Override public void onSearchClick() {
    view.navigateToBrand();
  }
}
