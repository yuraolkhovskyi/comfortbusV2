package com.transportation.comfortbus.service.impl;

import com.transportation.comfortbus.dto.VehicleStationDTO;
import com.transportation.comfortbus.entity.VehicleStationEntity;
import com.transportation.comfortbus.service.VehicleStationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleStationServiceImpl implements VehicleStationService {

    private final ModelMapper modelMapper;

    @Override
    public VehicleStationDTO mapVehicleStationFromEntityToDTO(final VehicleStationEntity vehicleStationEntity) {
        return modelMapper.map(vehicleStationEntity, VehicleStationDTO.class);
    }

}
