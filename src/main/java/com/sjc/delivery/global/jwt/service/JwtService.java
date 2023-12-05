package com.sjc.delivery.global.jwt.service;

import com.sjc.delivery.global.jwt.JwtUtils;
import com.sjc.delivery.global.jwt.dto.TokenResponse;
import com.sjc.delivery.global.jwt.model.JwtPayload;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JwtService {
    private final JwtUtils jwtUtils;

    public JwtPayload verifyToken(String token) {
        return jwtUtils.verifyToken(token);
    }

    @Transactional
    public TokenResponse createJwtToken(Long userPK, String name,
        Collection<GrantedAuthority> authorities) {
        String accessToken = jwtUtils.createToken(userPK, name, authorities);
        String refreshToken = jwtUtils.createRefreshToken(userPK);

        jwtUtils.verifyToken(accessToken);
        return new TokenResponse(accessToken, refreshToken);
    }


}
