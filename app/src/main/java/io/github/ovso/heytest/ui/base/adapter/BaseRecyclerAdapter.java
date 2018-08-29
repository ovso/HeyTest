package io.github.ovso.heytest.ui.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public abstract class BaseRecyclerAdapter
    extends RecyclerView.Adapter<BaseViewHolder> {

  @Override public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return createViewHolder(parent, viewType);
  }

  @Override public abstract void onBindViewHolder(BaseViewHolder viewHolder, int position);

  @Override public abstract int getItemCount();
}