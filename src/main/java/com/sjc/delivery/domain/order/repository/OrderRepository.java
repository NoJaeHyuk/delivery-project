package com.sjc.delivery.domain.order.repository;

import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.food.repository.FoodRepository;
import com.sjc.delivery.domain.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
