package io.github.ovso.heytest.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import io.github.ovso.heytest.R;
import io.github.ovso.heytest.data.network.model.Cars;
import io.github.ovso.heytest.ui.base.BaseActivity;
import javax.inject.Inject;

public class DetailActivity extends BaseActivity implements DetailPresenter.View {
  @Inject DetailPresenter presenter;

  @Override protected int getLayoutResID() {
    return R.layout.activity_detail;
  }

  @Override protected void onCreated(@Nullable Bundle savedInstanceState) {
    if (getIntent().hasExtra("data")) {
      Cars cars = getIntent().getParcelableExtra("data");
      presenter.onCreate(cars);
    }
  }

  @Override public void showBackButton() {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override public void showTitle(String title) {
    setTitle(title);
  }

  @Override public boolean isTitle() {
    return true;
  }
}