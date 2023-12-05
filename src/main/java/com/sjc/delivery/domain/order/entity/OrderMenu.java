package com.sjc.delivery.domain.order.entity;

import com.sjc.delivery.domain.BaseTimeEntity;
import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class OrderMenu extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String food_name;
    private String food_price;
    private int order_count;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean isDeleted;

    @Builder
    public OrderMenu(int order_count, Food food, Store store) {
        this.order_count = order_count;
        this.food = food;
        this.store = store;
        this.isDeleted = false;
    }

    public void deleteOrderMenu(){
        this.isDeleted = true;
    }

    public boolean isStore(Long storeId){
        return this.store.getId() == storeId;
    }
}
