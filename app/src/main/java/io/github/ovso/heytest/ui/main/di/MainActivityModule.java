package io.github.ovso.heytest.ui.main.di;

import dagger.Module;
import dagger.Provides;
import io.github.ovso.heytest.data.network.MainRequest;
import io.github.ovso.heytest.data.network.model.Cars;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.main.MainPresenter;
import io.github.ovso.heytest.ui.main.MainPresenterImpl;
import io.github.ovso.heytest.ui.main.adapter.MainAdapter;
import io.github.ovso.heytest.utils.ResourceProvider;
import io.github.ovso.heytest.utils.SchedulersFacade;
import javax.inject.Singleton;
import timber.log.Timber;

@Module public class MainActivityModule {

  @Provides MainPresenter provideMainPresenter(MainPresenter.View view,
      ResourceProvider resourceProvider, MainRequest request, SchedulersFacade schedulersFacade,
      BaseAdapterDataModel<Cars> adapterDataModel) {
    return new MainPresenterImpl(view, resourceProvider, request, schedulersFacade,
        adapterDataModel);
  }

  @Singleton @Provides MainAdapter provideMainAdapter() {
    return new MainAdapter();
  }

  @Provides BaseAdapterDataModel<Cars> provideMainAdapterDataModel(MainAdapter adapter) {
    return adapter;
  }

  @Provides BaseAdapterView provideMainAdapterView(MainAdapter adapter) {
    return adapter;
  }
}