package io.github.ovso.heytest.ui.detail;

import android.support.annotation.NonNull;
import io.github.ovso.heytest.data.network.model.Cars;

public interface DetailPresenter {
  void onCreate(@NonNull Cars cars);

  interface View {

    void showBackButton();

    void showTitle(String title);
  }
}
