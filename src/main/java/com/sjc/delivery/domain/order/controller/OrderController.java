package com.sjc.delivery.domain.order.controller;

import com.sjc.delivery.domain.order.dto.request.OrderRequest;
import com.sjc.delivery.domain.order.entity.Order;
import com.sjc.delivery.domain.order.service.OrderService;
import com.sjc.delivery.global.resolver.Login;
import com.sjc.delivery.global.resolver.LoginInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<?> registerOrder(@RequestBody OrderRequest orderRequest, @Login LoginInfo loginInfo){

        Order order = orderService.registerOrder(orderRequest, loginInfo.userId());

        return ResponseEntity.ok().build();
    }

}
