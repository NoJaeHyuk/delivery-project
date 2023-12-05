package com.sjc.delivery.domain.store.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.sjc.delivery.domain.BaseTimeEntity;
import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.order.entity.Order;
import com.sjc.delivery.domain.order.entity.OrderMenu;
import com.sjc.delivery.domain.user.entity.User;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Store extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String storeName;

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

    @OneToMany(mappedBy = "store", fetch = LAZY)
    private final List<OrderMenu> orderMenus = new ArrayList<>();

    @Builder
    public Store(User user, String storeName, String foodCategory, String address, String phone,
        String description, String storeImage, int minDeliveryPrice) {
        this.user = user;
        this.storeName = storeName;
        this.foodCategory = foodCategory;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.storeImage = storeImage;
        this.minDeliveryPrice = minDeliveryPrice;
    }

    public void updateStore(String storeName, String foodCategory, String address, String phone,
        String description, String storeImage, int minDeliveryPrice){

        if(storeName != null){
            this.storeName = storeName;
        }

        if(foodCategory != null){
            this.foodCategory = foodCategory;
        }

        if(address != null){
            this.address = address;
        }

        if(phone != null){
            this.phone = phone;
        }

        if(description != null){
            this.description = description;
        }

        if(storeImage != null){
            this.storeImage = storeImage;
        }

        this.minDeliveryPrice = minDeliveryPrice;
    }
}
