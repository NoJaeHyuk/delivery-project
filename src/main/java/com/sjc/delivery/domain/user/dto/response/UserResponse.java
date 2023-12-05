package com.sjc.delivery.domain.user.dto.response;

import com.sjc.delivery.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
    private Long id;
    private String email;
    private String nickName;
    private String name;

    @Builder
    public UserResponse(Long id, String email, String nickName, String name) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.name = name;
    }

    public static UserResponse from(User user){
        return UserResponse.builder()
            .id(user.getId())
            .email(user.getEmail())
            .nickName(user.getNickName())
            .name(user.getName())
            .build();
    }
}
