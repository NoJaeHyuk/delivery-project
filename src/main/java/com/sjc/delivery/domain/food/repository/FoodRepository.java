package com.sjc.delivery.domain.food.repository;

import com.sjc.delivery.domain.food.entity.Food;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByStoreIdAndIsDeleted(Long storeId, Boolean isDeleted);
}