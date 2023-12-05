package com.sjc.delivery.domain.user.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.sjc.delivery.domain.BaseTimeEntity;
import com.sjc.delivery.domain.order.entity.Order;
import com.sjc.delivery.domain.order.entity.OrderMenu;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.global.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String nickName;
    private String password;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role; // 사용자 권한
    private Boolean isDeleted;

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private final List<Store> stores = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private final List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private final List<OrderMenu> orderMenus = new ArrayList<>();

    @Builder
    public User(String email, String name, String nickName,
        Role role, String password, String phone) {
        this.email = email;
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.isDeleted = false;
        this.role = role;
        this.phone = phone;
    }
}
