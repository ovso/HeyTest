package io.github.ovso.heytest.ui.main;

public interface MainPresenter {

  void onCreated();

  void onSearchClick();

  void onListItemClick(Object data, int itemPosition);

  interface View {

    void navigateToBrand();

    void showSearchText(String text);

    void setupRecyclerView();

    void refresh();

    void navigateToDetail(Object data);
  }
}
