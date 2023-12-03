package com.sjc.delivery.domain.store.dto.request;

import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.user.entity.User;
import lombok.Getter;

@Getter
public class StoreRegisterRequest {
    private String foodCategory;
    private String storeName;
    private String address;
    private String phone;
    private String description;
    private String storeImage;
    private int minDeliveryPrice;

    public Store toEntity(User user) {
        return Store.builder()
            .storeName(this.storeName)
            .address(this.address)
            .description(this.description)
            .phone(this.phone)
            .foodCategory(this.foodCategory)
            .storeImage(this.storeImage)
            .user(user)
            .minDeliveryPrice(this.minDeliveryPrice)
            .build();
    }
}
