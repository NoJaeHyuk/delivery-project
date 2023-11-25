package com.sjc.delivery.domain.food.service;

import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.food.repository.FoodRepository;
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
        //return foodRepository.findById(id);
        return null;
    }

    @Override
    public Food saveAndFlush(Food food) {
        return foodRepository.saveAndFlush(food);
    }

    @Override
    public int deleteById(long id) {
        //return foodRepository.deleteById(id);
        return 0;
    }
}