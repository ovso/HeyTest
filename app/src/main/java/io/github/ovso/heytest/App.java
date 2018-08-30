package io.github.ovso.heytest;

import android.content.Context;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.github.ovso.heytest.di.DaggerAppComponent;
import io.github.ovso.heytest.utils.AppInitUtils;
import lombok.Getter;

public class App extends DaggerApplication {

  @Getter public static Context instance;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    AppInitUtils.timer();
  }

  @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerAppComponent.builder().application(this).build();
  }
}
