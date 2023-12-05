package com.sjc.delivery.domain.user.dto.request;

import com.sjc.delivery.global.enums.Role;
import com.sjc.delivery.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {
    private String email;
    private String name;
    private String nickName;
    private String password;
    private String phone;
    private Role role;
    public User toEntity(String password) {
        return User.builder()
            .email(this.email)
            .name(this.name)
            .nickName(this.nickName)
            .role(role.USER)
            .phone(this.phone)
            .password(password)
            .build();
    }
}
