package io.github.ovso.heytest.data.network;

import io.github.ovso.heytest.data.network.model.BrandGroup;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ModelGroupService {
  @GET("car_meta/brands/{id}") Single<BrandGroup> getBrandDetail(@Path("id") int id);
}
