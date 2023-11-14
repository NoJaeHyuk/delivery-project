package com.sjc.delivery.food.service;

import com.sjc.delivery.food.domain.Food;
import com.sjc.delivery.food.repository.FoodRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{

    private final FoodRepository foodRepository;

    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public Food findById(long id) {
        return foodRepository.findById(id);
    }

    @Override
    public Food saveAndFlush(Food food) {
        return foodRepository.saveAndFlush(food);
    }

    @Override
    public void deleteById(long id) {
        foodRepository.deleteById(id);
    }
}
