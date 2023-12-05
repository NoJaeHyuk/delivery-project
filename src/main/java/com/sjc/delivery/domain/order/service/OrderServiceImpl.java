package com.sjc.delivery.domain.order.service;

import com.sjc.delivery.domain.order.dto.request.OrderRequest;
import com.sjc.delivery.domain.order.entity.Order;
import com.sjc.delivery.domain.order.repository.OrderMenuRepository;
import com.sjc.delivery.domain.order.repository.OrderRepository;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.store.exception.NoSuchStore;
import com.sjc.delivery.domain.store.repository.StoreRepository;
import com.sjc.delivery.domain.user.entity.User;
import com.sjc.delivery.domain.user.exception.NoSuchUserException;
import com.sjc.delivery.domain.user.repository.UserRepository;
import com.sjc.delivery.global.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMenuRepository orderMenuRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public Order registerOrder(OrderRequest orderRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchUserException(
            ErrorCode.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(orderRequest.getStoreId())
            .orElseThrow(() -> new NoSuchStore(ErrorCode.STORE_NOT_FOUND));

        Order newOrder = orderRepository.save(orderRequest.toEntity(store, user));
        orderMenuRepository.updateOrderByUserId(newOrder.getId(), userId);

        return newOrder;
    }
}
