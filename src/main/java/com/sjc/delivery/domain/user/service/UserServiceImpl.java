package com.sjc.delivery.domain.user.service;

import com.sjc.delivery.domain.user.dto.request.UserRegisterRequest;
import com.sjc.delivery.domain.user.entity.User;
import com.sjc.delivery.domain.user.exception.NoSuchUserException;
import com.sjc.delivery.domain.user.repository.UserRepository;
import com.sjc.delivery.global.enums.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserRegisterRequest userRegisterRequest) {
        return userRepository.save(userRegisterRequest.toEntity(passwordEncoder.encode(userRegisterRequest.getPassword())));
    }

    @Override
    public User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchUserException(ErrorCode.MEMBER_NOT_FOUND));
    }
}
