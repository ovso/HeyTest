package io.github.ovso.heytest.ui.brand.di;

import dagger.Binds;
import dagger.Module;
import io.github.ovso.heytest.ui.brand.BrandActivity;
import io.github.ovso.heytest.ui.brand.BrandPresenter;

@Module public abstract class BrandActivityViewModule {

  @Binds abstract BrandPresenter.View bindBrandView(BrandActivity activity);
}