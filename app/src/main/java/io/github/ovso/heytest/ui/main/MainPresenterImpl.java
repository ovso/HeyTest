package io.github.ovso.heytest.ui.main;

import android.content.Intent;
import io.github.ovso.heytest.R;
import io.github.ovso.heytest.data.RequestType;
import io.github.ovso.heytest.data.network.MainRequest;
import io.github.ovso.heytest.data.network.model.Car;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.heytest.utils.ResourceProvider;
import io.github.ovso.heytest.utils.SchedulersFacade;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import timber.log.Timber;

public class MainPresenterImpl implements MainPresenter {

  private MainPresenter.View view;
  private ResourceProvider resourceProvider;
  private MainRequest mainRequest;
  private CompositeDisposable compositeDisposable = new CompositeDisposable();
  private SchedulersFacade schedulers;
  private BaseAdapterDataModel<Car> adapterDataModel;
  private RequestType requestType;
  private int page = 1;

  public MainPresenterImpl(MainPresenter.View $view, ResourceProvider $ResourceProvider,
      MainRequest $mainRequest, SchedulersFacade $schedulers,
      BaseAdapterDataModel<Car> $adapterDataModel) {
    view = $view;
    resourceProvider = $ResourceProvider;
    mainRequest = $mainRequest;
    schedulers = $schedulers;
    adapterDataModel = $adapterDataModel;
  }

  @Override public void onCreated() {
    requestType = RequestType.ALL;

    view.showSearchText(resourceProvider.getString(R.string.car_search));
    view.setupRecyclerView();
    compositeDisposable.add(
        mainRequest.getCars(page).subscribeOn(schedulers.io()).observeOn(schedulers.ui()).subscribe(
            new Consumer<List<Car>>() {
              @Override public void accept(List<Car> items) throws Exception {
                Timber.d(items.toString());
                adapterDataModel.addAll(items);
                view.refresh();
              }
            }, new Consumer<Throwable>() {
              @Override public void accept(Throwable throwable) throws Exception {
                Timber.d(throwable);
              }
            }));
  }

  @Override public void onSearchClick() {
    view.navigateToBrand();
  }

  @Override public void onListItemClick(Object data, int itemPosition) {
    Timber.d("data = " + data);
    view.navigateToDetail(data);
  }

  @Override public void onNewIntent(Intent intent) {
    requestType = RequestType.SINGLE;

    if (intent.hasExtra("id") && intent.hasExtra("name")) {
      view.showSearchText(intent.getStringExtra("name"));
      int id = intent.getIntExtra("id", 0);

      Disposable disposable = mainRequest.getCars(page, id)
          .subscribeOn(schedulers.io())
          .observeOn(schedulers.ui())
          .subscribe(
              new Consumer<List<Car>>() {
                @Override public void accept(List<Car> cars) throws Exception {
                  adapterDataModel.clear();
                  view.refresh();
                  adapterDataModel.addAll(cars);
                  view.refresh();
                }
              }, new Consumer<Throwable>() {
                @Override public void accept(Throwable throwable) throws Exception {
                  Timber.d(throwable);
                }
              });
      compositeDisposable.add(disposable);
    }
  }

  @Override public void onLoadMore() {
    switch (requestType) {

      case ALL:

        break;
      case SINGLE:
        break;
    }
  }
}