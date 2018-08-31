package io.github.ovso.heytest.ui.brand;

import android.content.Intent;
import android.support.annotation.NonNull;

public interface BrandPresenter {

  void onCreate(@NonNull Intent intent);

  void onDestroy();

  interface View {

    void setupRecyclerView();

    void refresh();

    void showBackButton();

    void setTitle(String title);
  }
}
