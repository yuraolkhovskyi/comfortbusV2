package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.VehicleStationDTO;
import com.transportation.comfortbus.entity.VehicleStationEntity;

import java.util.UUID;

public interface VehicleStationService {


    VehicleStationDTO mapVehicleStationFromEntityToDTO(VehicleStationEntity vehicleStationEntity);
}
