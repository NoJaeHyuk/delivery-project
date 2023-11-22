package com.sjc.delivery.domain.food.controller;

import com.sjc.delivery.domain.food.domain.Food;
import com.sjc.delivery.domain.food.dto.FoodDto;
import com.sjc.delivery.domain.food.service.FoodService;
import jakarta.validation.Valid;
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
    public FoodDto registFood(@Valid @RequestBody FoodDto foodDto){
        // DTO -> Entity 변환
        Food request = toEntity(foodDto);
        Food response = foodService.save(request);

        // Entity -> DTO 변환
        return toResponse(response);
    }

    @GetMapping("/foods/{foodId}")
    public Food getFood(@PathVariable Long foodId){
        return foodService.findById(foodId);
    }

    @PutMapping("/foods")
    public FoodDto updateFood(@RequestBody FoodDto foodDto){
        Food request = toEntity(foodDto);
        Food response = foodService.saveAndFlush(request);
        return toResponse(response);
    }

    @DeleteMapping("/foods/{foodId}")
    public int updateFood(@PathVariable Long foodId){
        return foodService.deleteById(foodId);
    }

    public static Food toEntity(FoodDto req) {
        return Food.builder()
            .foodName(req.getFoodName())
            .foodType(req.getFoodType())
            .price(req.getPrice())
            .description(req.getDescription())
            .build();
    }

    public static FoodDto toResponse (Food entity) {
        return FoodDto.builder()
            .id(entity.getId())
            .foodName(entity.getFoodName())
            .foodType(entity.getFoodType())
            .price(entity.getPrice())
            .description(entity.getDescription())
            .build();
    }
}
