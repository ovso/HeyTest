package io.github.ovso.heytest.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import io.github.ovso.heytest.R;
import io.github.ovso.heytest.ui.base.BaseActivity;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.base.adapter.MyViewRecyclerView;
import io.github.ovso.heytest.ui.base.adapter.OnRecyclerViewItemClickListener;
import io.github.ovso.heytest.ui.brand.BrandActivity;
import io.github.ovso.heytest.ui.detail.DetailActivity;
import io.github.ovso.heytest.ui.main.adapter.MainAdapter;
import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainPresenter.View,
    OnRecyclerViewItemClickListener, OnEndlessRecyclerScrollListener.OnLoadMoreListener {

  @Inject MainPresenter presenter;
  @Inject MainAdapter adapter;
  @Inject BaseAdapterView adapterView;
  @Inject OnEndlessRecyclerScrollListener onEndlessRecyclerScrollListener;
  @BindView(R.id.recycler_view) MyViewRecyclerView recyclerView;
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
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
    recyclerView.setOnItemClickListener(this);
    onEndlessRecyclerScrollListener.setLayoutManager(recyclerView.getLayoutManager());
    recyclerView.addOnScrollListener(onEndlessRecyclerScrollListener);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void navigateToDetail(Object data) {
    Intent intent = new Intent(this, DetailActivity.class);
    intent.putExtra("data", (Parcelable) data);
    startActivity(intent);
  }

  @Override public void onListItemClick(View view, Object data, int itemPosition) {
    presenter.onListItemClick(data, itemPosition);
  }

  @Override protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    presenter.onNewIntent(intent);
  }

  @Override public void onLoadMore() {
    presenter.onLoadMore();
  }
}