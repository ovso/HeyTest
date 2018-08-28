package io.github.ovso.heytest.data.network.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString public class Cars {
  private int id;
  private String main_image_url;
  private String status;
  private String status_display;
  private String model_part_name;
  private String grade_part_name;
  private int year;
  private int mileage;
  private int price;
  private int discounted_price;
  private String absolute_url;
}
