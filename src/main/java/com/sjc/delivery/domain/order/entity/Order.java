package com.sjc.delivery.domain.order.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.sjc.delivery.domain.BaseTimeEntity;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.user.entity.User;
import jakarta.persistence.Column;
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
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "ORDERS")
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private String orderLot;
    private String paymentType;
    private int totalPrice;
    private String request;
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


}
