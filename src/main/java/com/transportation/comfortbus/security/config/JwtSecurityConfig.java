package com.transportation.comfortbus.security.config;

import com.transportation.comfortbus.entity.enumeration.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class JwtSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests()
                //
                .requestMatchers(
                        "/api/auth/**"
                ).permitAll()

                //
                .requestMatchers(
                        "/api/ride/search",
                        "/api/ticket/get/ride/{rideId}/available-passenger-seat",
                        "/api/ticket/book",
                        "/api/ticket/{ticketId}/change-status/{ticketStatus}"
                ).hasAnyAuthority(UserRole.CLIENT.name(), UserRole.DRIVER.name(), UserRole.ADMIN.name())


                .requestMatchers(
                        "/api/ride/{rideId}/status",
                        "/api/ride/{rideId}/details",
                        "/api/ride/get/driver/{driverId}",
                        "/api/ticket/**"
                ).hasAnyAuthority(UserRole.ADMIN.name(), UserRole.DRIVER.name())


                .requestMatchers(
                        "/api/config/**",
                        "/api/ride/**",
                        "/api/ticket/**"
                ).hasAnyAuthority(UserRole.ADMIN.name())


                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();

    }

}
