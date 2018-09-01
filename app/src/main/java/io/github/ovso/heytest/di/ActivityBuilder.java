package io.github.ovso.heytest.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import io.github.ovso.heytest.ui.brand.BrandActivity;
import io.github.ovso.heytest.ui.brand.di.BrandActivityModule;
import io.github.ovso.heytest.ui.brand.di.BrandActivityViewModule;
import io.github.ovso.heytest.ui.detail.DetailActivity;
import io.github.ovso.heytest.ui.detail.di.DetailActivityModule;
import io.github.ovso.heytest.ui.detail.di.DetailActivityViewModule;
import io.github.ovso.heytest.ui.main.MainActivity;
import io.github.ovso.heytest.ui.main.di.MainActivityModule;
import io.github.ovso.heytest.ui.main.di.MainActivityViewModule;
import io.github.ovso.heytest.ui.model.ModelActivity;
import io.github.ovso.heytest.ui.model.di.ModelActivityModule;
import io.github.ovso.heytest.ui.model.di.ModelActivityViewModule;
import io.github.ovso.heytest.ui.model_group.ModelGroupActivity;
import io.github.ovso.heytest.ui.model_group.di.ModelGroupActivityModule;
import io.github.ovso.heytest.ui.model_group.di.ModelGroupActivityViewModule;
import javax.inject.Singleton;

@Module(includes = { AndroidSupportInjectionModule.class })
public abstract class ActivityBuilder {
  @Singleton @ContributesAndroidInjector(modules = {
      MainActivityModule.class,
      MainActivityViewModule.class
  })
  abstract MainActivity bindMainActivity();

  @Singleton @ContributesAndroidInjector(modules = {
      BrandActivityModule.class,
      BrandActivityViewModule.class
  })
  abstract BrandActivity bindBrandActivity();

  @Singleton @ContributesAndroidInjector(modules = {
      ModelGroupActivityModule.class,
      ModelGroupActivityViewModule.class
  })
  abstract ModelGroupActivity bindModelGroupActivity();

  @Singleton @ContributesAndroidInjector(modules = {
      ModelActivityModule.class,
      ModelActivityViewModule.class
  })
  abstract ModelActivity bindModelActivity();

  @Singleton @ContributesAndroidInjector(modules = {
      DetailActivityModule.class, DetailActivityViewModule.class
  })
  abstract DetailActivity bindDetailActivity();
}
