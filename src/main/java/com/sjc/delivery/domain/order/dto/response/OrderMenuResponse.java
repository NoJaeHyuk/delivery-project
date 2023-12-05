package com.sjc.delivery.domain.order.dto.response;

import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.store.entity.Store;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderMenuResponse {
    private Long id;
    private String food_name;
    private String food_price;
    private int order_count;
    private String foodName;
    private int foodPrice;
    private String storeName;

    @Builder
    public OrderMenuResponse(Long id, String food_name, String food_price, int order_count,
        Food food, Store store) {
        this.id = id;
        this.food_name = food_name;
        this.food_price = food_price;
        this.order_count = order_count;
        this.foodName = food.getFoodName();
        this.storeName = store.getStoreName();
        this.foodPrice = food.getFoodPrice();
    }
}
