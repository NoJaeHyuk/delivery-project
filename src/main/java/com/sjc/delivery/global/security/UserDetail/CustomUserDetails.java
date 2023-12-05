package com.sjc.delivery.global.security.UserDetail;

import java.util.Collection;
import java.util.Collections;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
public class CustomUserDetails implements UserDetails {
    private final Long userId;
    private final String name;
    private final String username;
    private final String password;
    private final Collection<GrantedAuthority> authorities;

    public CustomUserDetails(Long userId, String name, String username, String password,
        Collection<GrantedAuthority> authorities) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static CustomUserDetails withToken(String token) {
        return new CustomUserDetails(null, null, null, token, Collections.emptySet());
    }

    public static CustomUserDetails loginContext(Long userId, String name, Collection<GrantedAuthority> authorities) {
        return new CustomUserDetails(userId, name, name, null, authorities);
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
