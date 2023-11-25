package com.sjc.delivery.domain.user.dto.request;

import com.sjc.delivery.domain.food.entity.Food;
import com.sjc.delivery.domain.store.entity.Store;
import com.sjc.delivery.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
    private String userName;
    private String email;
    private String nickName;
    private String password;
    private String userRank;
    private String userRole;

    public User toEntity(String password) {
        return User.builder()
            .userName(this.userName)
            .email(this.email)
            .nickName(this.nickName)
            .userRank(this.userRank)
            .userRole(this.userRole)
            .password(password)
            .build();
    }
}
