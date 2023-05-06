package com.transportation.comfortbus.service.impl;


import com.transportation.comfortbus.dto.VehicleDTO;
import com.transportation.comfortbus.entity.VehicleEntity;
import com.transportation.comfortbus.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService {

    private final ModelMapper modelMapper;


    @Override
    public VehicleDTO mapVehicleFromEntityToDTO(VehicleEntity vehicleEntity) {
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }
}
