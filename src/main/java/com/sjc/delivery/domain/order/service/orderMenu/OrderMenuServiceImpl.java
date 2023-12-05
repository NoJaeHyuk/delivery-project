package com.sjc.delivery.domain.order.service.orderMenu;

import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.food.exception.NoSuchFood;
import com.sjc.delivery.domain.food.repository.FoodRepository;
import com.sjc.delivery.domain.order.dto.request.CartRequest;
import com.sjc.delivery.domain.order.entity.OrderMenu;
import com.sjc.delivery.domain.order.repository.OrderMenuRepository;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.store.exception.NoSuchStore;
import com.sjc.delivery.domain.store.repository.StoreRepository;
import com.sjc.delivery.global.enums.ErrorCode;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderMenuServiceImpl implements OrderMenuService {

    private final OrderMenuRepository orderMenuRepository;
    private final FoodRepository foodRepository;
    private final StoreRepository storeRepository;

    @Transactional
    @Override
    public OrderMenu registerCart(CartRequest cartRequest, Long userId) {
        // 같은 업체가 아닌 경우 비활성화 처리
        Optional<OrderMenu> beforeOrderMenu = orderMenuRepository.findFirstByUserIdAndIsDeleted(
            userId, false);

        if (beforeOrderMenu.isPresent()) {
            if (beforeOrderMenu.get().isStore(cartRequest.getStoreId())) {
                orderMenuRepository.updateByUserId(userId);
            }
        }

        Food food = foodRepository.findById(cartRequest.getFoodId())
            .orElseThrow(() -> new NoSuchFood(ErrorCode.FOOD_NOT_FOUND));
        Store store = storeRepository.findById(cartRequest.getStoreId())
            .orElseThrow(() -> new NoSuchStore(
                ErrorCode.STORE_NOT_FOUND));

        // 신규 등록
        OrderMenu newOrderMenu = orderMenuRepository.save(OrderMenu.builder()
            .food(food)
            .store(store)
            .order_count(cartRequest.getOrder_count())
            .build());

        return newOrderMenu;
    }

    @Override
    public List<OrderMenu> getCart(Long userId) {

        List<OrderMenu> orderMenus = orderMenuRepository.findByUserIdAndIsDeleted(userId, false);

        return orderMenus;
    }
}
