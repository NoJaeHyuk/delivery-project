package com.sjc.delivery.domain.order.controller;

import com.sjc.delivery.domain.order.dto.request.CartRequest;
import com.sjc.delivery.domain.order.dto.response.OrderMenuResponse;
import com.sjc.delivery.domain.order.entity.OrderMenu;
import com.sjc.delivery.domain.order.service.orderMenu.OrderMenuService;
import com.sjc.delivery.global.resolver.Login;
import com.sjc.delivery.global.resolver.LoginInfo;
import com.sjc.delivery.global.response.ApiResponse;
import com.sjc.delivery.global.utils.ApiResponseUtils;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orderMenus")
@RequiredArgsConstructor
public class OrderMenuController {

    private final OrderMenuService orderMenuService;


    @PostMapping("")
    public ResponseEntity<ApiResponse<OrderMenuResponse>> registerCart(@RequestBody CartRequest cartRequest,
        @Login LoginInfo loginInfo){

        OrderMenu orderMenu = orderMenuService.registerCart(cartRequest, loginInfo.userId());

        return ResponseEntity.ok(ApiResponseUtils.success(OrderMenuResponse.builder()
            .id(orderMenu.getId())
            .food(orderMenu.getFood())
            .store(orderMenu.getStore())
            .order_count(orderMenu.getOrder_count())
            .build()));
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<OrderMenuResponse>>> getCart(@Login LoginInfo loginInfo){
        List<OrderMenu> carts = orderMenuService.getCart(loginInfo.userId());

        List<OrderMenuResponse> foodResponses = carts.stream()
            .map(m -> OrderMenuResponse.builder()
                .id(m.getId())
                .food(m.getFood())
                .store(m.getStore())
                .order_count(m.getOrder_count())
                .build())
            .collect(Collectors.toList());

        return ResponseEntity.ok(ApiResponseUtils.success(foodResponses));
    }
}
