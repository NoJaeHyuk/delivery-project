package com.sjc.delivery.domain.user.entity;

import static jakarta.persistence.FetchType.LAZY;

import com.sjc.delivery.domain.BaseTimeEntity;
import com.sjc.delivery.domain.order.entity.Order;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.user.dto.request.UserRegisterRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @Column(name = "user_id")
    private Long id;

    private String userName;
    private String email;
    private String nickName;
    private String password;

    private String userRank;
    private String userRole;
    private Boolean isDeleted;

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private final List<Store> stores = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = LAZY)
    private final List<Order> orders = new ArrayList<>();

    @Builder
    public User(String userName, String email, String nickName,  String userRank,
        String userRole, String password) {
        this.userName = userName;
        this.email = email;
        this.nickName = nickName;
        this.userRank = userRank;
        this.userRole = userRole;
        this.password = password;
        this.isDeleted = false;
    }




}
