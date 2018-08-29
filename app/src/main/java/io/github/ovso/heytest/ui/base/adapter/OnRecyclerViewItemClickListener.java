package io.github.ovso.heytest.ui.base.adapter;

import android.view.View;

public interface OnRecyclerViewItemClickListener<T> {
  void onListItemClick(View view, T data, int itemPosition);
}