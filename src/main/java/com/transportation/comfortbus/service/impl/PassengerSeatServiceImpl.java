package com.transportation.comfortbus.service.impl;


import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.entity.PassengerSeatEntity;
import com.transportation.comfortbus.service.PassengerSeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class PassengerSeatServiceImpl implements PassengerSeatService {

    private final ModelMapper modelMapper;

    @Override
    public Set<PassengerSeatDTO> mapPassengerSeatsFromEntityToDTO(final Set<PassengerSeatEntity> passengerSeatEntities) {
        final Set<PassengerSeatDTO> result = new HashSet<>();
        for (PassengerSeatEntity passengerSeatEntity : passengerSeatEntities) {
            result.add(modelMapper.map(passengerSeatEntity, PassengerSeatDTO.class));
        }
        return result;
    }

}
