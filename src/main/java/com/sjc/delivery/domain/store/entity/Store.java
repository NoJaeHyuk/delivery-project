package com.sjc.delivery.domain.store.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.sjc.delivery.domain.BaseTimeEntity;
import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.order.entity.Order;
import com.sjc.delivery.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String foodCategory;

    private String address;

    private String phone;

    @Lob
    private String description;

    private String storeImage;

    private int minDeliveryPrice;

    @OneToMany(mappedBy = "store", fetch = LAZY)
    private final List<Food> foods = new ArrayList<>();

    @OneToMany(mappedBy = "store", fetch = LAZY)
    private final List<Order> orders = new ArrayList<>();

}
