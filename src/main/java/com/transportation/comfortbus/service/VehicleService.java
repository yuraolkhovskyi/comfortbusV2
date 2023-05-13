package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.VehicleDTO;
import com.transportation.comfortbus.entity.VehicleEntity;

public interface VehicleService {

    VehicleDTO mapVehicleFromEntityToDTO(VehicleEntity vehicleEntity);

    VehicleEntity findById(final Long vehicleId);
}
