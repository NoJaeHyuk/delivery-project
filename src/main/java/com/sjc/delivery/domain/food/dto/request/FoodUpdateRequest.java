package com.sjc.delivery.domain.food.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
public class FoodUpdateRequest {
    private Long id;
    private String foodName;
    private int price;
    private String description;
    private String foodType;
    private String foodImage;
}
