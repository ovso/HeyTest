package io.github.ovso.heytest.ui.detail.di;

import dagger.Module;
import dagger.Provides;
import io.github.ovso.heytest.data.network.DetailRequest;
import io.github.ovso.heytest.ui.detail.DetailPresenter;
import io.github.ovso.heytest.ui.detail.DetailPresenterImpl;
import io.github.ovso.heytest.ui.detail.fragment.DetailAdapter;
import io.github.ovso.heytest.utils.ResourceProvider;
import io.github.ovso.heytest.utils.SchedulersFacade;

@Module public class DetailActivityModule {

  @Provides DetailPresenter provideDetailPresenter(DetailPresenter.View view,
      ResourceProvider resourceProvider, DetailRequest request, SchedulersFacade schedulersFacade) {
    return new DetailPresenterImpl(view, resourceProvider, request, schedulersFacade);
  }
}