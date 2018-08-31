package io.github.ovso.heytest.ui.brand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import butterknife.BindView;
import io.github.ovso.heytest.R;
import io.github.ovso.heytest.ui.base.BaseActivity;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.base.adapter.MyViewRecyclerView;
import io.github.ovso.heytest.ui.base.adapter.OnRecyclerViewItemClickListener;
import io.github.ovso.heytest.ui.brand.adapter.BrandAdapter;
import javax.inject.Inject;

public class BrandActivity extends BaseActivity implements BrandPresenter.View,
    OnRecyclerViewItemClickListener {

  @Inject BrandPresenter presenter;
  @Inject BrandAdapter adapter;
  @Inject BaseAdapterView adapterView;
  @BindView(R.id.recycler_view) MyViewRecyclerView recyclerView;

  @Override protected int getLayoutResID() {
    return R.layout.activity_brand;
  }

  @Override protected void onCreated(@Nullable Bundle savedInstanceState) {
    presenter.onCreate(getIntent());
  }

  @Override protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }

  @Override public void setupRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
    recyclerView.setOnItemClickListener(this);
  }

  @Override public void refresh() {
    adapterView.refresh();
  }

  @Override public void showBackButton() {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override public void setTitle(String title) {
    super.setTitle(title);
  }

  @Override public void onListItemClick(View view, Object data, int itemPosition) {

  }

  @Override public boolean isTitle() {
    return true;
  }
}
