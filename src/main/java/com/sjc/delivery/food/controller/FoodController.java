package com.sjc.delivery.food.controller;

import com.sjc.delivery.food.domain.Food;
import com.sjc.delivery.food.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping("/foods")
    public String registFood(@RequestBody Food food){
        foodService.save(food);
        return "ok";
    }

    @GetMapping("/foods/{foodId}")
    public Food getFood(@PathVariable Long foodId){
        return foodService.findById(foodId);
    }

    @PutMapping("/foods")
    public String updateFood(@RequestBody Food food){
        foodService.saveAndFlush(food);
        return "ok";
    }

    @DeleteMapping("/foods/{foodId}")
    public String updateFood(@PathVariable Long foodId){
        foodService.deleteById(foodId);
        return "ok";
    }
}
