package io.github.ovso.heytest.data.network;

import io.github.ovso.heytest.data.network.model.Car;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface MainService {
  @GET("cars") Single<List<Car>> getCars(@QueryMap Map<String, String> queryMap);

  @GET("cars/{car_id}") Single<Object> getCarDetail(@Path("car_id") int carId);
}
