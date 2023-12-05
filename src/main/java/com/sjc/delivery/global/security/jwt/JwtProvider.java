package com.sjc.delivery.global.security.jwt;

import com.sjc.delivery.global.jwt.model.JwtPayload;
import com.sjc.delivery.global.jwt.service.JwtService;
import com.sjc.delivery.global.security.UserDetail.CustomUserDetails;
import java.util.Collection;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider implements AuthenticationProvider {

    private final JwtService jwtService;

    public JwtProvider(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public Authentication authenticate(Authentication authentication)
        throws AuthenticationException {
        return processUserAuthentication(authentication);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private Authentication processUserAuthentication(Authentication authentication)
        throws AuthenticationException {
        String accessToken = (String) authentication.getCredentials();
        JwtPayload jwtPayload = jwtService.verifyToken(accessToken);
        return JwtAuthenticationToken.authenticated(CustomUserDetails.loginContext(jwtPayload.id(),
            jwtPayload.email(), jwtPayload.authorities()));
    }
}
