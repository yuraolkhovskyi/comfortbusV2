package com.transportation.comfortbus.security.service;

import com.transportation.comfortbus.security.dto.AuthenticationRequest;
import com.transportation.comfortbus.security.dto.AuthenticationResponse;
import com.transportation.comfortbus.security.dto.RegisterRequest;

public interface AuthenticationService {

    AuthenticationResponse register(final RegisterRequest request);

    AuthenticationResponse authenticate(final AuthenticationRequest authenticationRequest);
}
