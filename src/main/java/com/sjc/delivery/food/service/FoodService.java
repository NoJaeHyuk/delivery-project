package com.sjc.delivery.food.service;

import com.sjc.delivery.food.domain.Food;

public interface FoodService {

    Food save(Food food);

    Food findById(long id);

    Food saveAndFlush(Food food);

    void deleteById(long id);

}
