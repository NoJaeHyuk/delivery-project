package com.sjc.delivery.domain.order.service.orderMenu;

import com.sjc.delivery.domain.order.dto.request.CartRequest;
import com.sjc.delivery.domain.order.entity.OrderMenu;
import java.util.List;

public interface OrderMenuService {

    OrderMenu registerCart(CartRequest cartRequest, Long userId);

    List<OrderMenu> getCart(Long userId);
}
