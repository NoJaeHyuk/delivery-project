package com.sjc.delivery.domain.user.controller;

import com.sjc.delivery.domain.user.dto.request.UserRegisterRequest;
import com.sjc.delivery.domain.user.dto.response.UserResponse;
import com.sjc.delivery.domain.user.service.UserService;
import com.sjc.delivery.global.resolver.Login;
import com.sjc.delivery.global.resolver.LoginInfo;
import com.sjc.delivery.global.response.ApiResponse;
import com.sjc.delivery.global.utils.ApiResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<ApiResponse<UserResponse>> registerUser(@RequestBody UserRegisterRequest userRegisterRequest) {
        return ResponseEntity.ok(ApiResponseUtils.success(
            UserResponse.from(userService.registerUser(userRegisterRequest))));
    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<UserResponse>> getLoginUser(@Login LoginInfo loginInfo) {
        return ResponseEntity.ok(ApiResponseUtils.success(
            UserResponse.from(userService.findUser(loginInfo.userId()))));
    }

}
