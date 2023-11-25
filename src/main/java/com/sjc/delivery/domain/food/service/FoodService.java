package com.sjc.delivery.domain.food.service;

import com.sjc.delivery.domain.food.entity.Food;

public interface FoodService {

    Food save(Food food);

    Food findById(long id);

    Food saveAndFlush(Food food);

    int deleteById(long id);

}
