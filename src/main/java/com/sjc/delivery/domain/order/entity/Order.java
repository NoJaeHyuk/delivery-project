package com.sjc.delivery.domain.order.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.sjc.delivery.domain.BaseTimeEntity;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "ORDERS")
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentType;
    private String orderType;
    private int totalPrice;
    private String address;
    private String storeRequest;
    private String riderRequest;
    private String status;
    private String storeName;
    private String deliveryPrice;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", fetch = LAZY)
    private final List<OrderMenu> orderMenus = new ArrayList<>();

    @Builder
    public Order(String paymentType, String orderType, int totalPrice, String address,
        String storeRequest, String riderRequest, String status, String storeName,
        String deliveryPrice,
        Store store, User user) {
        this.paymentType = paymentType;
        this.orderType = orderType;
        this.totalPrice = totalPrice;
        this.address = address;
        this.storeRequest = storeRequest;
        this.riderRequest = riderRequest;
        this.status = status;
        this.storeName = storeName;
        this.deliveryPrice = deliveryPrice;
        this.store = store;
        this.user = user;
    }
}
