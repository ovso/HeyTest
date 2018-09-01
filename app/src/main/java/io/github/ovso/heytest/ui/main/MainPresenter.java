package io.github.ovso.heytest.ui.main;

import android.content.Intent;

public interface MainPresenter {

  void onCreated();

  void onSearchClick();

  void onListItemClick(Object data, int itemPosition);

  void onNewIntent(Intent intent);

  interface View {

    void navigateToBrand();

    void showSearchText(String text);

    void setupRecyclerView();

    void refresh();

    void navigateToDetail(Object data);
  }
}
