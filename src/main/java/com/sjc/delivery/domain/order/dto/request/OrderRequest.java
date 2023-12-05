package com.sjc.delivery.domain.order.dto.request;

import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.order.entity.Order;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.user.entity.User;
import lombok.Getter;

@Getter
public class OrderRequest {
    private String paymentType;
    private String orderType;
    private int totalPrice;
    private String address;
    private String storeRequest;
    private String riderRequest;
    private Long storeId;
    private String deliveryPrice;

    public Order toEntity(Store store, User user) {
        return Order.builder()
            .store(store)
            .user(user)
            .address(this.address)
            .totalPrice(this.totalPrice)
            .orderType(this.orderType)
            .paymentType(this.paymentType)
            .storeRequest(this.storeRequest)
            .riderRequest(this.riderRequest)
            .deliveryPrice(this.deliveryPrice)
            .build();
    }

}
