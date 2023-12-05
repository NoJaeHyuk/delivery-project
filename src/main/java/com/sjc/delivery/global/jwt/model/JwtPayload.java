package com.sjc.delivery.global.jwt.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

public record JwtPayload (
    Long id,
    String email,
    Collection<GrantedAuthority> authorities){
}
