package com.sjc.delivery.domain.food.controller;

import com.sjc.delivery.domain.food.dto.request.FoodRegisterRequest;
import com.sjc.delivery.domain.food.dto.request.FoodUpdateRequest;
import com.sjc.delivery.domain.food.dto.response.FoodResponse;
import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.food.service.FoodService;
import com.sjc.delivery.global.utils.ApiResponseUtils;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/food")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @PostMapping("")
    public ResponseEntity<?> registerFood(@RequestBody FoodRegisterRequest foodRegisterRequest) {
        return ResponseEntity.ok(
            ApiResponseUtils.success("OK", FoodResponse.toResponse(foodService.registerFood(foodRegisterRequest))));
    }

    @PutMapping("")
    public ResponseEntity<?> updateFood(@RequestBody FoodUpdateRequest foodUpdateRequest) {
        return ResponseEntity.ok(
            ApiResponseUtils.success("OK", FoodResponse.toResponse(foodService.updateFood(foodUpdateRequest))));
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<?> getFood(@PathVariable Long foodId) {
        return ResponseEntity.ok().body(
            ApiResponseUtils.success("OK", FoodResponse.toResponse(foodService.findById(foodId))));
    }

    @GetMapping("/store/{storeId}")
    public ResponseEntity<?> getFoodByStore(@PathVariable Long storeId) {
        List<Food> byStore = foodService.findByStore(storeId);

        List<FoodResponse> foodResponses = byStore.stream()
            .map(m -> FoodResponse.toResponse(m))
            .collect(Collectors.toList());

        return ResponseEntity.ok(ApiResponseUtils.success("OK", foodResponses));
    }

}
