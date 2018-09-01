package io.github.ovso.heytest.ui.model.di;

import dagger.Module;
import dagger.Provides;
import io.github.ovso.heytest.data.network.ModelGroupRequest;
import io.github.ovso.heytest.data.network.ModelRequest;
import io.github.ovso.heytest.data.network.model.Model;
import io.github.ovso.heytest.data.network.model.ModelGroup;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.model.ModelPresenter;
import io.github.ovso.heytest.ui.model.ModelPresenterImpl;
import io.github.ovso.heytest.ui.model.adapter.ModelAdapter;
import io.github.ovso.heytest.ui.model_group.ModelGroupPresenter;
import io.github.ovso.heytest.ui.model_group.ModelGroupPresenterImpl;
import io.github.ovso.heytest.ui.model_group.adapter.ModelGroupAdapter;
import io.github.ovso.heytest.utils.ResourceProvider;
import io.github.ovso.heytest.utils.SchedulersFacade;
import javax.inject.Singleton;

@Module public class ModelActivityModule {

  @Provides ModelPresenter provideModelPresenter(ModelPresenter.View view,
      ResourceProvider resourceProvider, ModelRequest modelRequest,
      SchedulersFacade schedulersFacade, BaseAdapterDataModel<Model> adapterDataModel) {
    return new ModelPresenterImpl(view, resourceProvider, modelRequest, schedulersFacade,
        adapterDataModel);
  }

  @Singleton @Provides ModelAdapter provideModelAdapter() {
    return new ModelAdapter();
  }

  @Provides BaseAdapterDataModel<Model> provideModelAdapterDataModel(ModelAdapter adapter) {
    return adapter;
  }

  @Provides BaseAdapterView provideModelAdapterView(ModelAdapter adapter) {
    return adapter;
  }
}