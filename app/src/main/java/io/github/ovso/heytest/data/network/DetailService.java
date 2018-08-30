package io.github.ovso.heytest.data.network;

import io.github.ovso.heytest.data.network.model.CarDetail;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DetailService {
  @GET("cars/{car_id}") Single<CarDetail> getCarDetail(@Path("car_id") int carId);
}
