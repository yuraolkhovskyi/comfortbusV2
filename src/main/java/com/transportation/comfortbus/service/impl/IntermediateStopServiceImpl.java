package com.transportation.comfortbus.service.impl;


import com.transportation.comfortbus.dto.IntermediateStopDTO;
import com.transportation.comfortbus.entity.IntermediateStopEntity;
import com.transportation.comfortbus.entity.RideEntity;
import com.transportation.comfortbus.repository.IntermediateStopRepository;
import com.transportation.comfortbus.service.IntermediateStopService;
import com.transportation.comfortbus.service.VehicleStationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class IntermediateStopServiceImpl implements IntermediateStopService {

    private final ModelMapper modelMapper;
    private final IntermediateStopRepository intermediateStopRepository;
    private final VehicleStationService vehicleStationService;

    @Override
    public Set<IntermediateStopDTO> mapIntermediateStopsFromEntityToDTO(final RideEntity rideEntity) {

        final Set<IntermediateStopDTO> result = new HashSet<>();
        for (final IntermediateStopEntity intermediateStopEntity : rideEntity.getIntermediateStops()) {

            final IntermediateStopDTO intermediateStopDTO = modelMapper.map(intermediateStopEntity, IntermediateStopDTO.class);
            intermediateStopDTO.setVehicleStationDTO(vehicleStationService.mapVehicleStationFromEntityToDTO(intermediateStopEntity.getVehicleStation()));
            result.add(intermediateStopDTO);
        }

        return result;
    }

    @Override
    public Set<IntermediateStopEntity> mapIntermediateStopsFromDTOsToEntities(final Set<Long> intermediateStopDTOS) {

        final Set<IntermediateStopEntity> result = new HashSet<>();

        for (Long intermediateStopId : intermediateStopDTOS) {
            IntermediateStopEntity intermediateStopEntity = intermediateStopRepository
                    .findById(intermediateStopId).orElseThrow();
            result.add(intermediateStopEntity);
        }

        return result;
    }

}
