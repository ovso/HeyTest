package io.github.ovso.heytest.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import io.github.ovso.heytest.R;
import io.github.ovso.heytest.data.network.model.Cars;
import io.github.ovso.heytest.ui.base.adapter.BaseViewHolder;

public class MainViewHolder extends BaseViewHolder {
  @BindView(R.id.image_view) ImageView imageView;

  private MainViewHolder(View itemView) {
    super(itemView);
  }

  public void bind(Cars cars) {
    Glide.with(itemView.getContext()).load(cars.getMain_image_url()).into(imageView);
  }

  public static MainViewHolder create(Context context) {
    return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_main, null));
  }
}
