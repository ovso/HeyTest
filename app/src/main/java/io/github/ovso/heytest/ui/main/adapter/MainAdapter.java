package io.github.ovso.heytest.ui.main.adapter;

import android.view.View;
import io.github.ovso.heytest.R;
import io.github.ovso.heytest.data.network.model.Cars;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.base.adapter.BaseRecyclerAdapter;
import io.github.ovso.heytest.ui.base.adapter.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends BaseRecyclerAdapter implements BaseAdapterView,
    BaseAdapterDataModel<Cars> {
  private List<Cars> items = new ArrayList<>();

  @Override protected BaseViewHolder createViewHolder(View view, int viewType) {
    return MainViewHolder.create(view.getContext());
  }

  @Override public int getLayoutRes(int viewType) {
    return R.layout.list_item_main;
  }

  @Override
  public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof MainViewHolder) {
      MainViewHolder holder = (MainViewHolder) viewHolder;
      holder.bind(items.get(position));
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