package com.sjc.delivery.food.repository;

import com.sjc.delivery.food.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository {
    Food save(Food food);

    Food findById(long id);

    Food saveAndFlush(Food food);

    int deleteById(long id);
}
