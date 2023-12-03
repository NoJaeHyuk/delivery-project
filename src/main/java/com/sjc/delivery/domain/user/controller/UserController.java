package com.sjc.delivery.domain.user.controller;

import com.sjc.delivery.domain.user.dto.request.UserRegisterRequest;
import com.sjc.delivery.domain.user.dto.response.UserResponse;
import com.sjc.delivery.domain.user.service.UserService;
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
    public ResponseEntity<ApiResponse<UserResponse>> getLoginUser() {
        //Security 설정 후 로그인 사용자 인증정보 받아서 구현 예정
        Long user_id = 1L;

        return ResponseEntity.ok(ApiResponseUtils.success(
            UserResponse.from(userService.findUser(user_id))));
    }

}
