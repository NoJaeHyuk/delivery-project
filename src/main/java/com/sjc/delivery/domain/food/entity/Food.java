package com.sjc.delivery.domain.food.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.sjc.delivery.domain.BaseTimeEntity;
import com.sjc.delivery.domain.order.entity.OrderMenu;
import com.sjc.delivery.domain.store.entity.Store;
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

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Food extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    private String foodName;
    private int foodPrice;
    private String foodType;
    @Lob
    private String description;
    private String foodImage;
    private Boolean isDeleted;

    @OneToMany(mappedBy = "food", fetch = LAZY)
    private final List<OrderMenu> orderMenus = new ArrayList<>();

    @Builder
    public Food(Store store, String foodName, int foodPrice, String foodType, String description,
        String foodImage) {
        this.store = store;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodType = foodType;
        this.description = description;
        this.foodImage = foodImage;
        this.isDeleted = false;
    }

    public void updateFood(String foodName, int foodPrice, String foodType, String description,
        String foodImage) {
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.foodType = foodType;
        this.description = description;
        this.foodImage = foodImage;
    }

}
