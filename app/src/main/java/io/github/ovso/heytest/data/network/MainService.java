package io.github.ovso.heytest.data.network;

import io.github.ovso.heytest.data.network.model.Cars;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface MainService {
  @GET("cars") Single<List<Cars>> getCars(@QueryMap Map<String, String> queryMap);
}
