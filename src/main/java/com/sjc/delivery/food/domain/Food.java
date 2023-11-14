package com.sjc.delivery.food.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Food {
    private Long id;
    private Long storeId;
    private String foodName;
    private int price;
    private String foodType;
    private String description;

    public void setId(Long id) {
        this.id = id;
    }
}
