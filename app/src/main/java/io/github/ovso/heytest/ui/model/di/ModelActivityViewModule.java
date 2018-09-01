package io.github.ovso.heytest.ui.model.di;

import dagger.Binds;
import dagger.Module;
import io.github.ovso.heytest.ui.model.ModelActivity;
import io.github.ovso.heytest.ui.model.ModelPresenter;
import io.github.ovso.heytest.ui.model_group.ModelGroupActivity;
import io.github.ovso.heytest.ui.model_group.ModelGroupPresenter;

@Module public abstract class ModelActivityViewModule {

  @Binds abstract ModelPresenter.View bindModelView(ModelActivity activity);
}