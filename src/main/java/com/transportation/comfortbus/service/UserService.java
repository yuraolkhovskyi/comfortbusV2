package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.UserDTO;
import com.transportation.comfortbus.entity.UserEntity;


public interface UserService {

    UserDTO mapUserFromEntityToDTO(final UserEntity administrator);

    UserEntity save(final UserEntity userEntity);

    UserEntity findById(final Long userId);
}
