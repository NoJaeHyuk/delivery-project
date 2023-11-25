package com.sjc.delivery.domain.store.dto.request;

import lombok.Getter;

@Getter
public class StoreUpdateRequest {
    private Long store_id;
    private String foodCategory;
    private String storeName;
    private String address;
    private String phone;
    private String description;
    private String storeImage;
    private int minDeliveryPrice;
}
