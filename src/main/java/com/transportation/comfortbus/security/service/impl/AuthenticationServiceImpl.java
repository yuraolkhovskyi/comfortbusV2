package com.transportation.comfortbus.security.service.impl;

import com.transportation.comfortbus.entity.UserEntity;
import com.transportation.comfortbus.entity.enumeration.UserRole;
import com.transportation.comfortbus.exception.SystemException;
import com.transportation.comfortbus.repository.UserRepository;
import com.transportation.comfortbus.security.dto.AuthenticationRequest;
import com.transportation.comfortbus.security.dto.AuthenticationResponse;
import com.transportation.comfortbus.security.dto.RegisterRequest;
import com.transportation.comfortbus.security.service.AuthenticationService;
import com.transportation.comfortbus.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.transportation.comfortbus.exception.ErrorMessageConstants.BAD_REQUEST_ERROR_MESSAGE;
import static com.transportation.comfortbus.exception.code.ServiceErrorCode.BAD_REQUEST;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userSecurityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(final RegisterRequest request) {
        final String userEmail = request.getEmail();
        if (userSecurityRepository.findByEmail(userEmail).isPresent()) {

            log.error("Not able to register user. User with the specified email {} is already registered", userEmail);
            throw new SystemException(BAD_REQUEST_ERROR_MESSAGE, BAD_REQUEST);
        }

        final UserEntity userSecurityEntity = UserEntity.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(userEmail)
                .registrationDate(LocalDateTime.now())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(UserRole.CLIENT)
                .build();

        userSecurityRepository.save(userSecurityEntity);
        final String token = jwtService.generateToken(userSecurityEntity);
        return new AuthenticationResponse(token);
    }

    @Override
    public AuthenticationResponse authenticate(final AuthenticationRequest authenticationRequest) {
        final String userEmail = authenticationRequest.getEmail();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userEmail,
                        authenticationRequest.getPassword()
                )
        );
        final UserEntity userEntity = userSecurityRepository
                .findByEmail(userEmail)
                .orElseThrow(() -> {
                    log.error("Not able to authenticate user. No user found by the specified email {}", userEmail);
                    throw new SystemException(BAD_REQUEST_ERROR_MESSAGE, BAD_REQUEST);
                });
        final String token = jwtService.generateToken(userEntity);
        return new AuthenticationResponse(token);
    }
}
