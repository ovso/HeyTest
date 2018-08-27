package io.github.ovso.heytest.ui.main.di;

import dagger.Module;
import dagger.Provides;
import io.github.ovso.heytest.ui.main.MainPresenter;
import io.github.ovso.heytest.ui.main.MainPresenterImpl;
import io.github.ovso.heytest.utils.ResourceProvider;

@Module public class MainActivityModule {

  @Provides MainPresenter provideMainPresenter(MainPresenter.View view,
      ResourceProvider resourceProvider) {
    return new MainPresenterImpl(view, resourceProvider);
  }
}