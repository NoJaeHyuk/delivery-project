package com.sjc.delivery.domain.user.service;

import com.sjc.delivery.domain.user.dto.request.UserRegisterRequest;
import com.sjc.delivery.domain.user.entity.User;
import com.sjc.delivery.domain.user.repository.UserRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User registerUser(UserRegisterRequest userRegisterRequest) {
        // Security 설정 후 PasswordEncoder로 비밀번호 변환 필요
        String password = userRegisterRequest.getPassword();

        return userRepository.save(userRegisterRequest.toEntity(password));
    }

    @Override
    public User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("사용자 정보가 없습니다."));
    }
}
