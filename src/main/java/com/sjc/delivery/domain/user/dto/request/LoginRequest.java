package com.sjc.delivery.domain.user.dto.request;

import lombok.Getter;

@Getter
public class LoginRequest {

    private String email;
    private String password;
}
