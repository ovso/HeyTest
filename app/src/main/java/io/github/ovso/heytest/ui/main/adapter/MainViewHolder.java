package io.github.ovso.heytest.ui.main.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.Glide;
import io.github.ovso.heytest.R;
import io.github.ovso.heytest.data.SaleStatus;
import io.github.ovso.heytest.data.network.model.Car;
import io.github.ovso.heytest.ui.base.adapter.BaseViewHolder;

public class MainViewHolder extends BaseViewHolder {
  @BindView(R.id.image_view) ImageView imageView;
  @BindView(R.id.grand_part_name_text_view) TextView grandPartNameTextView;
  @BindView(R.id.model_part_name_text_view) TextView modelPartNameTextView;
  @BindView(R.id.year_text_view) TextView yearTextView;
  @BindView(R.id.distance_text_view) TextView distanceTextView;
  @BindView(R.id.price_text_view) TextView priceTextView;
  @BindView(R.id.root_view) ConstraintLayout rootView;
  @BindView(R.id.status_text_view) TextView statusTextView;

  private MainViewHolder(View itemView) {
    super(itemView);
  }

  public void bind(Car cars) {
    super.bind(cars);
    Context context = itemView.getContext();

    Glide.with(context).load(cars.getMain_image_url()).into(imageView);
    grandPartNameTextView.setText(cars.getGrade_part_name());
    modelPartNameTextView.setText(cars.getModel_part_name());
    yearTextView.setText(Car.toYear(context, cars.getYear()));
    distanceTextView.setText(Car.toDistance(context, cars.getMileage()));
    priceTextView.setText(Car.toPrice(context, cars.getPrice()));

    switch (SaleStatus.toStatus(cars.getStatus())) {

      case FOR_SALE:
        statusTextView.setBackgroundColor(
            ContextCompat.getColor(context, android.R.color.holo_blue_dark));
        break;
      case ON_SALE:
        statusTextView.setBackgroundColor(
            ContextCompat.getColor(context, android.R.color.holo_green_dark));
        break;
      case SOLD_OUT:
        statusTextView.setBackgroundColor(
            ContextCompat.getColor(context, android.R.color.darker_gray));
        break;
    }
    statusTextView.setText(cars.getStatus_display());

  }

  public static MainViewHolder create(ViewGroup parent) {
    return new MainViewHolder(
        LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_item_main_span, parent, false));
  }

  @OnClick(R.id.root_view) void onItemClick() {
    onRecyclerViewItemClickListener.onListItemClick(itemView, data, itemPosition);
  }
}