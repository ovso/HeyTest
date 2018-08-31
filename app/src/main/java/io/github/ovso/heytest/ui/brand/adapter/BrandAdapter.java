package io.github.ovso.heytest.ui.brand.adapter;

import android.view.ViewGroup;
import io.github.ovso.heytest.data.network.model.Brand;
import io.github.ovso.heytest.data.network.model.Car;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterDataModel;
import io.github.ovso.heytest.ui.base.adapter.BaseAdapterView;
import io.github.ovso.heytest.ui.base.adapter.BaseRecyclerAdapter;
import io.github.ovso.heytest.ui.base.adapter.BaseViewHolder;
import io.github.ovso.heytest.ui.base.adapter.OnRecyclerViewItemClickListener;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

public class BrandAdapter extends BaseRecyclerAdapter implements BaseAdapterView,
    BaseAdapterDataModel<Brand> {
  @Setter private OnRecyclerViewItemClickListener onRecyclerViewItemClickListener;
  private List<Brand> items = new ArrayList<>();

  @Override public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return BrandViewHolder.create(parent);
  }

  @Override
  public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
    if (viewHolder instanceof BrandViewHolder) {
      BrandViewHolder holder = (BrandViewHolder) viewHolder;
      holder.bind(items.get(position));
      holder.setOnRecyclerViewItemClickListener(onRecyclerViewItemClickListener);
      holder.setItemPosition(position);
    }
  }

  @Override public int getItemCount() {
    return getSize();
  }

  @Override public void add(Brand item) {
    items.add(item);
  }

  @Override public void addAll(List<Brand> $items) {
    items.addAll($items);
  }

  @Override public Brand remove(int position) {
    return items.remove(position);
  }

  @Override public Brand getItem(int position) {
    return items.get(position);
  }

  @Override public void add(int index, Brand item) {
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