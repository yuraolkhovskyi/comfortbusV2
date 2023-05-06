package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.RideDTO;
import com.transportation.comfortbus.dto.RideStatusDTO;
import com.transportation.comfortbus.dto.SearchRideRequestDTO;
import com.transportation.comfortbus.entity.RideEntity;

import java.util.Set;
import java.util.UUID;

public interface RideService {

    Set<RideDTO> getActiveRidesByParams(final SearchRideRequestDTO searchRideRequestDTO);

    RideStatusDTO getRideStatus(UUID rideId);

    RideEntity findById(final UUID rideId);
}
