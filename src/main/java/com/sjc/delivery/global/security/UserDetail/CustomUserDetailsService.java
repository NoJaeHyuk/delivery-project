package com.sjc.delivery.global.security.UserDetail;

import com.sjc.delivery.domain.user.entity.User;
import com.sjc.delivery.domain.user.repository.UserRepository;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmailAndIsDeleted(email, false)
            .orElseThrow(() -> new UsernameNotFoundException("no such user"));

        return new CustomUserDetails(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword(),
            Set.of(new SimpleGrantedAuthority(user.getRole().name()))
        );
    }
}
