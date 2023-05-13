package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.VehicleStationDTO;
import com.transportation.comfortbus.entity.VehicleStationEntity;

public interface VehicleStationService {


    VehicleStationDTO mapVehicleStationFromEntityToDTO(VehicleStationEntity vehicleStationEntity);

    VehicleStationEntity findById(final Long departureStationId);
}
