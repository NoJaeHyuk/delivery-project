package com.sjc.delivery.domain.food.dto.request;

import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.store.entity.Store;
import javax.swing.text.html.parser.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
public class FoodRegisterRequest {
    private String foodName;
    private int price;
    private String description;
    private String foodType;
    private String foodImage;
    private Long storeId;

    public Food toEntity(Store store) {
        return Food.builder()
            .store(store)
            .foodName(this.foodName)
            .foodImage(this.foodImage)
            .foodPrice(this.price)
            .description(this.description)
            .build();
    }
}
