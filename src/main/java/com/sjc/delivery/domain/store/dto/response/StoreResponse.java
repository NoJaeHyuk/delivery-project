package com.sjc.delivery.domain.store.dto.response;

import com.sjc.delivery.domain.food.dto.response.FoodResponse;
import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.store.entity.Store;
import lombok.Builder;
import lombok.Getter;

@Getter
public class StoreResponse {

    private Long id;
    private String storeName;
    private String foodCategory;
    private String address;
    private String phone;
    private String description;
    private String storeImage;
    private int minDeliveryPrice;

    @Builder
    public StoreResponse(Long id, String storeName, String foodCategory, String address,
        String phone,
        String description, String storeImage, int minDeliveryPrice) {
        this.id = id;
        this.storeName = storeName;
        this.foodCategory = foodCategory;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.storeImage = storeImage;
        this.minDeliveryPrice = minDeliveryPrice;
    }

    public static StoreResponse toResponse(Store store) {
        return StoreResponse.builder()
            .id(store.getId())
            .storeName(store.getStoreName())
            .foodCategory(store.getFoodCategory())
            .address(store.getAddress())
            .phone(store.getPhone())
            .description(store.getDescription())
            .storeImage(store.getStoreImage())
            .build();
    }
}
