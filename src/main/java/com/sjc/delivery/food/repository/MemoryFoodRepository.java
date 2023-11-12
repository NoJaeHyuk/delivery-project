package com.sjc.delivery.food.repository;

import com.sjc.delivery.food.domain.Food;
import java.util.HashMap;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryFoodRepository implements FoodRepository {

    private HashMap<Long, Food> db = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Food save(Food food) {
        food.setId(++sequence);
        db.put(food.getId(), food);
        return food;
    }

    @Override
    public Food findById(long id) {
        return db.get(id);
    }

    @Override
    public Food saveAndFlush(Food food) {
        db.put(food.getId(), food);
        return db.get(food.getId());
    }

    @Override
    public void deleteById(long id) {
        db.remove(id);
    }
}
