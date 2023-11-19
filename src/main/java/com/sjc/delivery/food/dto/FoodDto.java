package com.sjc.delivery.food.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FoodDto {
    private Long id;
    private Long storeId;
    private String foodName;
    private int price;
    private String foodType;
    private String description;
}
