package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.IntermediateStopDTO;
import com.transportation.comfortbus.entity.RideEntity;

import java.util.Set;


public interface IntermediateStopService {

    Set<IntermediateStopDTO> mapIntermediateStopsFromEntityToDTO(final RideEntity rideEntity);

}
