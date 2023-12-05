package com.sjc.delivery.global.security;

import com.sjc.delivery.global.jwt.service.JwtService;
import com.sjc.delivery.global.security.jwt.JwtAuthenticationFilter;
import com.sjc.delivery.global.security.jwt.JwtProvider;
import com.sjc.delivery.global.security.login.CustomAuthenticationProcessingFilter;
import com.sjc.delivery.global.security.login.CustomLoginProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public static final String DEFAULT_FILTER_PROCESSES_URL = "/auth/login";
    private final UserDetailsService userDetailsService;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtProvider jwtProvider;
    private final JwtService jwtService;

    public SecurityConfig(
        UserDetailsService userDetailsService,
        AuthenticationConfiguration authenticationConfiguration, JwtProvider jwtProvider,
        JwtService jwtService) {
        this.userDetailsService = userDetailsService;
        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtProvider = jwtProvider;
        this.jwtService = jwtService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomLoginProvider customLoginProvider() {
        return new CustomLoginProvider(passwordEncoder(), userDetailsService);
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        ProviderManager authenticationManager = (ProviderManager) authenticationConfiguration.getAuthenticationManager();
        authenticationManager.getProviders().add(customLoginProvider());
        authenticationManager.getProviders().add(jwtProvider);
        return authenticationManager;
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() throws Exception {
        return new JwtAuthenticationFilter(authenticationManager());
    }

    @Bean
    public CustomAuthenticationProcessingFilter customAuthenticationProcessingFilter()
        throws Exception {
        CustomAuthenticationProcessingFilter filter = new CustomAuthenticationProcessingFilter(
            DEFAULT_FILTER_PROCESSES_URL, jwtService);
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

}
