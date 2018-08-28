package io.github.ovso.heytest.data.network;

import io.github.ovso.heytest.data.network.model.Cars;
import io.reactivex.Single;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import okhttp3.Headers;

public class MainRequest extends BaseRequest<MainService> {

  @Inject
  public MainRequest() {

  }

  @Override protected Class getApiClass() {
    return MainService.class;
  }

  @Override protected Headers createHeaders() {
    return new Headers.Builder().build();
  }

  @Override protected String getBaseUrl() {
    return ApiEndPoint.CARS.getUrl();
  }

  public Single<List<Cars>> getCars() {
    Map<String, String> queryMap = new HashMap<>();
    queryMap.put("format", "json");
    queryMap.put("page", "1");
    return getApi().getCars(queryMap);
  }
}