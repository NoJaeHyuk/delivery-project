package com.sjc.delivery.global.security.jwt;

import com.sjc.delivery.global.security.UserDetail.CustomUserDetails;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {
    private final CustomUserDetails userDetails;
    private final boolean isAuthenticated;

    public JwtAuthenticationToken(CustomUserDetails userDetails, boolean isAuthenticated) {
        super(userDetails.getAuthorities());
        this.isAuthenticated = isAuthenticated;
        this.userDetails = userDetails;
    }

    public static JwtAuthenticationToken unauthenticated(CustomUserDetails userDetails) {
        return new JwtAuthenticationToken(userDetails, false);
    }

    public static JwtAuthenticationToken authenticated(CustomUserDetails userDetails) {
        return new JwtAuthenticationToken(userDetails, true);
    }

    @Override
    public Object getCredentials() {
        return userDetails.getPassword();
    }

    @Override
    public Object getPrincipal() {
        return userDetails;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
}
