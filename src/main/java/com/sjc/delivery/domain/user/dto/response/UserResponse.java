package com.sjc.delivery.domain.user.dto.response;

import com.sjc.delivery.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserResponse {
    private Long id;
    private String userName;
    private String email;
    private String nickName;
    private String userRank;
    private String userRole;

    @Builder
    public UserResponse(Long id, String userName, String email, String nickName, String userRank,
        String userRole) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.nickName = nickName;
        this.userRank = userRank;
        this.userRole = userRole;
    }

    public static UserResponse from(User user){
        return UserResponse.builder()
            .id(user.getId())
            .userName(user.getUserName())
            .email(user.getEmail())
            .nickName(user.getNickName())
            .build();
    }
}
