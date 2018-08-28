package io.github.ovso.heytest.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import io.github.ovso.heytest.R;
import io.github.ovso.heytest.ui.base.BaseActivity;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.brand.BrandActivity;
import io.github.ovso.heytest.ui.main.adapter.MainAdapter;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenter.View {

  @Inject MainPresenter presenter;
  @Inject MainAdapter adapter;
  @Inject BaseAdapterView adapterView;

  @BindView(R.id.recycler_view) RecyclerView recyclerView;
  @BindView(R.id.search_text_view) TextView searchTextView;

  @Override protected int getLayoutResID() {
    return R.layout.activity_main;
  }

  @Override protected void onCreated(@Nullable Bundle savedInstanceState) {
    presenter.onCreated();
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @OnClick(R.id.search_text_view) void onSearchClick() {
    presenter.onSearchClick();
  }

  @Override public void navigateToBrand() {
    Intent intent = new Intent(this, BrandActivity.class);
    startActivity(intent);
  }

  @Override public void showSearchText(String text) {
    searchTextView.setText(text);
  }

  @Override public void setupRecyclerView() {
    recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    recyclerView.setAdapter(adapter);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }
}