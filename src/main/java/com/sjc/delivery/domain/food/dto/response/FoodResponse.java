package com.sjc.delivery.domain.food.dto.response;

import com.sjc.delivery.domain.food.entity.Food;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FoodResponse {
    private Long id;
    private String foodName;
    private int foodPrice;
    private String foodType;
    private String description;
    private String foodImage;

    @Builder
    public FoodResponse(Long id, String foodName, int foodPrice, String foodType,
        String description,
        String foodImage) {
        this.id = id;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodType = foodType;
        this.description = description;
        this.foodImage = foodImage;
    }

    public static FoodResponse toResponse(Food food){
        return FoodResponse.builder()
            .id(food.getId())
            .foodName(food.getFoodName())
            .foodType(food.getFoodType())
            .foodPrice(food.getFoodPrice())
            .description(food.getDescription())
            .foodImage(food.getFoodImage())
            .build();
    }
}
