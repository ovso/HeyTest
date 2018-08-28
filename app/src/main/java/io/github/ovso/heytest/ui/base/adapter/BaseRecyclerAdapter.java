package io.github.ovso.heytest.ui.base.adapter;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseRecyclerAdapter
    extends RecyclerView.Adapter<BaseViewHolder> {

  @Override public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view =
        LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(viewType), parent, false);
    return createViewHolder(view, viewType);
  }

  protected abstract BaseViewHolder createViewHolder(View view, int viewType);

  @LayoutRes public abstract int getLayoutRes(int viewType);

  @Override public abstract void onBindViewHolder(BaseViewHolder viewHolder, int position);

  @Override public abstract int getItemCount();
}