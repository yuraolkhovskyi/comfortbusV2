package com.transportation.comfortbus.service.impl;

import com.transportation.comfortbus.dto.UserDTO;
import com.transportation.comfortbus.entity.UserEntity;
import com.transportation.comfortbus.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;


    @Override
    public UserDTO mapUserFromEntityToDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
}
