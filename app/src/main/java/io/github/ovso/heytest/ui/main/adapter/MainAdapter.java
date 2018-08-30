package io.github.ovso.heytest.ui.main.adapter;

import android.view.ViewGroup;
import io.github.ovso.heytest.data.network.model.Car;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.base.adapter.BaseRecyclerAdapter;
import io.github.ovso.heytest.ui.base.adapter.BaseViewHolder;
import io.github.ovso.heytest.ui.base.adapter.OnRecyclerViewItemClickListener;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

public class MainAdapter extends BaseRecyclerAdapter implements BaseAdapterView,
    BaseAdapterDataModel<Car> {
  @Setter private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
  private List<Car> items = new ArrayList<>();

  @Override public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return MainViewHolder.create(parent);
  }

  @Override
  public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof MainViewHolder) {
      MainViewHolder holder = (MainViewHolder) viewHolder;
      holder.bind(items.get(position));
      holder.setOnRecyclerViewItemClickListener(onRecyclerViewItemClickListener);
      holder.setItemPosition(position);
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void add(Car item) {
    items.add(item);
  }

  @Override public void addAll(List<Car> $items) {
    items.addAll($items);
  }

  @Override public Car remove(int position) {
    return items.remove(position);
  }

  @Override public Car getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, Car item) {
    items.add(index, item);
  }

  @Override public int getSize() {
    return items.size();
  }

  @Override public void clear() {
    items.clear();
  }

  @Override public void refresh() {
    notifyDataSetChanged();
  }
}