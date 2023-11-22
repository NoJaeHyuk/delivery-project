package com.sjc.delivery.domain.food.repository;

import com.sjc.delivery.domain.food.domain.Food;
import java.util.HashMap;

//@Repository
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
    public int deleteById(long id) {
        if(!db.containsKey(id)){
            return 0;
        }
        db.remove(id);
        return 1;
    }
}
