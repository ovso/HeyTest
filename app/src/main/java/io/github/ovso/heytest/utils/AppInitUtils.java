package io.github.ovso.heytest.utils;

import io.github.ovso.heytest.BuildConfig;
import timber.log.Timber;

public class AppInitUtils {

  private AppInitUtils() {

  }

  public static void timer() {
    if (BuildConfig.DEBUG) {
      Timber.plant(new Timber.DebugTree());
    }
  }
}