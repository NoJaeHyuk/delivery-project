package com.sjc.delivery.domain.food.service;

import com.sjc.delivery.domain.food.dto.request.FoodRegisterRequest;
import com.sjc.delivery.domain.food.dto.request.FoodUpdateRequest;
import com.sjc.delivery.domain.food.entity.Food;
import java.util.List;

public interface FoodService {
    Food findById(Long foodId);
    List<Food> findByStore(Long storeId);

    Food registerFood(FoodRegisterRequest foodRegisterRequest);

    Food updateFood(FoodUpdateRequest foodUpdateRequest);
}

