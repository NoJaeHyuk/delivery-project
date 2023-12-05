package com.sjc.delivery.global.security.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sjc.delivery.domain.user.dto.request.LoginRequest;
import com.sjc.delivery.global.jwt.service.JwtService;
import com.sjc.delivery.global.security.UserDetail.CustomUserDetails;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.StringUtils;

public class CustomAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private final ObjectMapper objectMapper;
    private final JwtService jwtService;

    public CustomAuthenticationProcessingFilter(String defaultFilterProcessesUrl, JwtService jwtService) {
        super(defaultFilterProcessesUrl);
        this.jwtService = jwtService;
        objectMapper = new ObjectMapper();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
        HttpServletResponse response)
        throws AuthenticationException, IOException {

        LoginRequest loginRequest = objectMapper.readValue(request.getReader(),
            LoginRequest.class);

        if (!StringUtils.hasText(loginRequest.getEmail()) || !StringUtils.hasText(
            loginRequest.getPassword())) {
            throw new UsernameNotFoundException("Username Or Password is Empty");
        }

        CustomAuthenticationToken authRequest = CustomAuthenticationToken.unauthenticated(
            loginRequest.getEmail(), loginRequest.getPassword());
        setDetails(request, authRequest);

        return getAuthenticationManager()
            .authenticate(authRequest);
    }

    protected void setDetails(HttpServletRequest request, CustomAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
        HttpServletResponse response, FilterChain chain, Authentication authentication)
        throws IOException {

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        // response
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        objectMapper.writeValue(response.getWriter(), jwtService.createJwtToken(userDetails.getUserId(), userDetails.getUsername(),
            (Collection<GrantedAuthority>) userDetails.getAuthorities()));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException ex) throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");

        String errorMessage = "Authentication Failed";
        if (ex instanceof BadCredentialsException) {
            errorMessage = "Invalid Username Or Password";
        } else if (ex instanceof InsufficientAuthenticationException) {
            errorMessage = "Invalid Secret Key";
        } else if (ex instanceof UsernameNotFoundException) {
            errorMessage = ex.getMessage();
        }

        objectMapper.writeValue(response.getWriter(), null);
    }
}
