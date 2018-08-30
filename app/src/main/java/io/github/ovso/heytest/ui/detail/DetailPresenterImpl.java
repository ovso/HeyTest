package io.github.ovso.heytest.ui.detail;

import android.content.Context;
import android.support.annotation.NonNull;
import io.github.ovso.heytest.App;
import io.github.ovso.heytest.data.network.DetailRequest;
import io.github.ovso.heytest.data.network.model.Car;
import io.github.ovso.heytest.data.network.model.CarDetail;
import io.github.ovso.heytest.utils.ResourceProvider;
import io.github.ovso.heytest.utils.SchedulersFacade;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class DetailPresenterImpl implements DetailPresenter {
  private DetailPresenter.View view;
  private ResourceProvider resourceProvider;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private DetailRequest request;
  private SchedulersFacade schedulersFacade;

  public DetailPresenterImpl(DetailPresenter.View $view, ResourceProvider $resourceProvider,
      DetailRequest $request, SchedulersFacade $scSchedulersFacade) {
    view = $view;
    resourceProvider = $resourceProvider;
    request = $request;
    schedulersFacade = $scSchedulersFacade;
  }

  @Override public void onCreate(@NonNull Car car) {
    Context context = App.getInstance();
    view.showBackButton();
    view.showTitle(car.getModel_part_name());
    Disposable disposable = request.getCarDetail(car.getId())
        .subscribeOn(schedulersFacade.io())
        .observeOn(schedulersFacade.ui())
        .subscribe(new Consumer<CarDetail>() {
          @Override public void accept(CarDetail carDetail) throws Exception {
            view.setupImages(carDetail.getImage_urls());
            view.setupPagenation(carDetail.getImage_urls().size());
            view.showPrice(Car.toPrice(context, carDetail.getPrice()));
            view.showCarNumber(carDetail.getCar_number());
            view.showMileage(Car.toDistance(context,carDetail.getMileage()));
            view.showInitialRegistrationDate(carDetail.getInitial_registration_date());
            view.showYear(Car.toYear(context,carDetail.getYear()));
            view.showFuel(carDetail.getFuel());
            view.showStatusDisplay(carDetail.getStatus_display());
          }
        }, new Consumer<Throwable>() {
          @Override public void accept(Throwable throwable) throws Exception {

          }
        });

    compositeDisposable.add(disposable);
  }

  @Override public void onDestroy() {
    compositeDisposable.clear();
  }
}
