package com.sjc.delivery.domain.food.dto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class FoodDto {
    private Long id;
    private Long storeId;
    @NotBlank
    private String foodName;
    private int price;
    private String foodType;
    private String description;
}
