package io.github.ovso.heytest.ui.main.adapter;

import android.view.ViewGroup;
import io.github.ovso.heytest.data.network.model.Cars;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.base.adapter.BaseRecyclerAdapter;
import io.github.ovso.heytest.ui.base.adapter.BaseViewHolder;
import io.github.ovso.heytest.ui.base.adapter.OnRecyclerViewItemClickListener;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

public class MainAdapter extends BaseRecyclerAdapter implements BaseAdapterView,
    BaseAdapterDataModel<Cars> {
  @Setter private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
  private List<Cars> items = new ArrayList<>();

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

  @Override public void add(Cars item) {
    items.add(item);
  }

  @Override public void addAll(List<Cars> $items) {
    items.addAll($items);
  }

  @Override public Cars remove(int position) {
    return items.remove(position);
  }

  @Override public Cars getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, Cars item) {
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