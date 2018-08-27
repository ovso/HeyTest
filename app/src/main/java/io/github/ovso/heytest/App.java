package io.github.ovso.heytest;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.github.ovso.heytest.di.DaggerAppComponent;
import io.github.ovso.heytest.utils.AppInitUtils;

public class App extends DaggerApplication {

  @Override public void onCreate() {
    super.onCreate();
    AppInitUtils.timer();
  }

  @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerAppComponent.builder().application(this).build();
  }
}
