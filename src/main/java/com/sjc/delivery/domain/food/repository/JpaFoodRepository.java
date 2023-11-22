package com.sjc.delivery.domain.food.repository;

import com.sjc.delivery.domain.food.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFoodRepository extends JpaRepository<Food, Long>,FoodRepository {

}