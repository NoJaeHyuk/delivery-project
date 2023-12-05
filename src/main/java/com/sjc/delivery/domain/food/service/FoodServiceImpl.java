package com.sjc.delivery.domain.food.service;

import com.sjc.delivery.domain.food.dto.request.FoodRegisterRequest;
import com.sjc.delivery.domain.food.dto.request.FoodUpdateRequest;
import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.food.repository.FoodRepository;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.store.exception.NoSuchStore;
import com.sjc.delivery.domain.store.repository.StoreRepository;
import com.sjc.delivery.global.enums.ErrorCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;
    private final StoreRepository storeRepository;

    @Override
    public Food findById(Long foodId) {
        return foodRepository.findById(foodId)
            .orElseThrow(() -> new RuntimeException("메뉴가 존재하지 않습니다."));
    }

    @Override
    public List<Food> findByStore(Long storeId) {
        return foodRepository.findAllByStoreIdAndIsDeleted(storeId, false);
    }

    @Override
    @Transactional
    public Food registerFood(FoodRegisterRequest foodRegisterRequest) {
        Store store = storeRepository.findById(foodRegisterRequest.getStoreId())
            .orElseThrow(() -> new NoSuchStore(ErrorCode.STORE_NOT_FOUND));
        return foodRepository.save(foodRegisterRequest.toEntity(store));
    }

    @Override
    @Transactional
    public Food updateFood(FoodUpdateRequest foodUpdateRequest) {
        Food curFood = foodRepository.findById(foodUpdateRequest.getId())
            .orElseThrow(() -> new RuntimeException("메뉴가 존재하지 않습니다."));

        curFood.updateFood(foodUpdateRequest.getFoodName(), foodUpdateRequest.getPrice(),
            foodUpdateRequest.getFoodType(), foodUpdateRequest.getDescription(),
            foodUpdateRequest.getFoodImage());

        return curFood;
    }


}
