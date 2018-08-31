package io.github.ovso.heytest.data.network;

import io.github.ovso.heytest.data.network.model.Brand;
import io.github.ovso.heytest.data.network.model.CarDetail;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import okhttp3.Headers;

public class BrandRequest extends BaseRequest<BrandService> {

  @Inject
  public BrandRequest() {

  }

  @Override protected Class getApiClass() {
    return BrandService.class;
  }

  @Override protected Headers createHeaders() {
    return new Headers.Builder().build();
  }

  @Override protected String getBaseUrl() {
    return ApiEndPoint.CARS.getUrl();
  }

  public Single<List<Brand>> getBrands() {
    return getApi().getBrands();
  }
}