package io.github.ovso.heytest.ui.main.di;

import dagger.Binds;
import dagger.Module;
import io.github.ovso.heytest.ui.main.MainActivity;
import io.github.ovso.heytest.ui.main.MainPresenter;
import io.github.ovso.heytest.ui.main.OnEndlessRecyclerScrollListener;

@Module public abstract class MainActivityViewModule {

  @Binds abstract MainPresenter.View bindMainView(MainActivity activity);

  @Binds abstract OnEndlessRecyclerScrollListener.OnLoadMoreListener bindOnLoadMoreListener(
      MainActivity activity);
}