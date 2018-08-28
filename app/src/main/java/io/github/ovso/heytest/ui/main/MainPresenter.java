package io.github.ovso.heytest.ui.main;

public interface MainPresenter {

  void onCreated();

  void onSearchClick();

  interface View {

    void navigateToBrand();

    void showSearchText(String text);

    void setupRecyclerView();

    void refresh();
  }
}
