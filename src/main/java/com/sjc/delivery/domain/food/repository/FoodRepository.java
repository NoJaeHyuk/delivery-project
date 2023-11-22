package com.sjc.delivery.domain.food.repository;

import com.sjc.delivery.domain.food.domain.Food;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository {
    Food save(Food food);

    Food findById(long id);

    Food saveAndFlush(Food food);

    int deleteById(long id);
}
