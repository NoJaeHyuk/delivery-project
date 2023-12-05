package com.sjc.delivery.global.jwt;

import com.sjc.delivery.global.enums.Role;
import com.sjc.delivery.global.jwt.exception.BadTokenException;
import com.sjc.delivery.global.jwt.model.JwtPayload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    public static final String USER_ID_KEY = "user-key";
    public static final String USER_NAME_KEY = "user-name";
    @Value("${jwt.secret}")
    private String secretKey;
    private final long tokenValidTime = 1000L * 60 * 60;
    private final long refreshTokenValidTime = 1000L * 60 * 60 * 24;

    public String createToken(Long userPK, String name,
        Collection<? extends GrantedAuthority> authorities) {
        Date expiryDate = new Date(new Date().getTime() + tokenValidTime);
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
            .setSubject(userPK.toString())
            // Gson 에서 Long 을 Double 로 Parse 하는 Issue가 있어서 String으로 Wrapping함.
            .claim(USER_ID_KEY, Objects.requireNonNull(userPK.toString()))
            .claim(USER_NAME_KEY, Objects.requireNonNull(name))
            .claim("roles", authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(",")))
            .setIssuedAt(new Date())
            .setExpiration(expiryDate)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public JwtPayload verifyToken(String jwtToken) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        try {
            Claims payload = Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(jwtToken)
                .getBody();

            Collection<GrantedAuthority> authorities =
                Arrays.stream(payload.get("roles").toString().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            return new JwtPayload(Long.parseLong(payload.get(USER_ID_KEY, String.class)),
                payload.get(USER_NAME_KEY, String.class), authorities);
        } catch (JwtException e) {
            throw new BadTokenException(e.getMessage());
        }
    }

    public String createRefreshToken(Long userPK) {
        Date expiryDate = new Date(new Date().getTime() + refreshTokenValidTime);
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
            .setSubject(userPK.toString())
            .claim(USER_ID_KEY, Objects.requireNonNull(userPK.toString()))
            .setIssuedAt(new Date())
            .setExpiration(expiryDate)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

}
