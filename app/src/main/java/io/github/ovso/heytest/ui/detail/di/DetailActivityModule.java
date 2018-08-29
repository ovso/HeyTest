package io.github.ovso.heytest.ui.detail.di;

import dagger.Module;
import dagger.Provides;
import io.github.ovso.heytest.ui.detail.DetailPresenter;
import io.github.ovso.heytest.ui.detail.DetailPresenterImpl;
import io.github.ovso.heytest.utils.ResourceProvider;

@Module public class DetailActivityModule {

  @Provides DetailPresenter provideDetailPresenter(DetailPresenter.View view,
      ResourceProvider resourceProvider) {
    return new DetailPresenterImpl(view, resourceProvider);
  }
}