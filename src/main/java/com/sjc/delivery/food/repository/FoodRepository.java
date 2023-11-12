package com.sjc.delivery.food.repository;

import com.sjc.delivery.food.domain.Food;

public interface FoodRepository {

    Food save(Food food);

    Food findById(long id);

    Food saveAndFlush(Food food);

    void deleteById(long id);
}
