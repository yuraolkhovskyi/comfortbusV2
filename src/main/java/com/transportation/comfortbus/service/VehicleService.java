package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.RideDTO;
import com.transportation.comfortbus.dto.RideStatusDTO;
import com.transportation.comfortbus.dto.SearchRideRequestDTO;
import com.transportation.comfortbus.dto.VehicleDTO;
import com.transportation.comfortbus.entity.RideEntity;
import com.transportation.comfortbus.entity.VehicleEntity;

import java.util.Set;
import java.util.UUID;

public interface VehicleService {

    VehicleDTO mapVehicleFromEntityToDTO(VehicleEntity vehicleEntity);
}
