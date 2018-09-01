package io.github.ovso.heytest.ui.model_group.di;

import dagger.Module;
import dagger.Provides;
import io.github.ovso.heytest.data.network.BrandRequest;
import io.github.ovso.heytest.data.network.ModelGroupRequest;
import io.github.ovso.heytest.data.network.model.Brand;
import io.github.ovso.heytest.data.network.model.ModelGroup;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.brand.BrandPresenter;
import io.github.ovso.heytest.ui.brand.BrandPresenterImpl;
import io.github.ovso.heytest.ui.brand.adapter.BrandAdapter;
import io.github.ovso.heytest.ui.model_group.ModelGroupPresenter;
import io.github.ovso.heytest.ui.model_group.ModelGroupPresenterImpl;
import io.github.ovso.heytest.ui.model_group.adapter.ModelGroupAdapter;
import io.github.ovso.heytest.utils.ResourceProvider;
import io.github.ovso.heytest.utils.SchedulersFacade;
import javax.inject.Singleton;

@Module public class ModelGroupActivityModule {

  @Provides ModelGroupPresenter provideModelGroupPresenter(ModelGroupPresenter.View view,
      ResourceProvider resourceProvider, ModelGroupRequest modelGroupRequest,
      SchedulersFacade schedulersFacade, BaseAdapterDataModel<ModelGroup> adapterDataModel) {
    return new ModelGroupPresenterImpl(view, resourceProvider, modelGroupRequest, schedulersFacade,
        adapterDataModel);
  }

  @Singleton @Provides ModelGroupAdapter provideModelGroupAdapter() {
    return new ModelGroupAdapter();
  }

  @Provides BaseAdapterDataModel<ModelGroup> provideModelGroupAdapterDataModel(ModelGroupAdapter adapter) {
    return adapter;
  }

  @Provides BaseAdapterView provideModelGroupAdapterView(ModelGroupAdapter adapter) {
    return adapter;
  }
}