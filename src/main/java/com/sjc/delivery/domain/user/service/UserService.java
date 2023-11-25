package com.sjc.delivery.domain.user.service;

import com.sjc.delivery.domain.user.dto.request.UserRegisterRequest;
import com.sjc.delivery.domain.user.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {

    User registerUser(UserRegisterRequest userRegisterRequest);

    User findUser(Long user_id);
}
