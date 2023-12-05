package com.sjc.delivery.domain.order.service;

import com.sjc.delivery.domain.order.dto.request.OrderRequest;
import com.sjc.delivery.domain.order.entity.Order;

public interface OrderService {

    Order registerOrder(OrderRequest orderRequest, Long userId);
}
