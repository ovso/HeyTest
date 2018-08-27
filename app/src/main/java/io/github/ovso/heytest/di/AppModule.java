package io.github.ovso.heytest.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.github.ovso.heytest.utils.ResourceProvider;
import javax.inject.Singleton;

@Module public class AppModule {
  @Provides Context provideContext(Application application) {
    return application;
  }

  /*
  @Singleton @Provides ResourceProvider provideResourceProvider(Context context) {
    return new ResourceProvider(context);
  }
  */
}
