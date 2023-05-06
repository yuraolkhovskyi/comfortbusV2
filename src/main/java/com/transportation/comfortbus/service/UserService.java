package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.UserDTO;
import com.transportation.comfortbus.dto.VehicleDTO;
import com.transportation.comfortbus.entity.UserEntity;
import com.transportation.comfortbus.entity.VehicleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


public interface UserService {

    UserDTO mapUserFromEntityToDTO(final UserEntity administrator);
}
