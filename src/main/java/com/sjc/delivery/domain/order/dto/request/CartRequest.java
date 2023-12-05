package com.sjc.delivery.domain.order.dto.request;

import lombok.Getter;

@Getter
public class CartRequest {
    private Long storeId;
    private Long foodId;
    private int order_count;
}
