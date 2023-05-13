package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.*;
import com.transportation.comfortbus.entity.RideEntity;
import com.transportation.comfortbus.entity.enumeration.RideStatus;

import java.util.Set;
import java.util.UUID;

public interface RideService {

    Set<RideDTO> getActiveRidesByParams(final SearchRideRequestDTO searchRideRequestDTO);

    RideStatusDTO getRideStatusByRideId(UUID rideId);

    RideEntity findById(final UUID rideId);

    RideDTO getAllRideDetailsById(final UUID rideId);

    Set<RideDTO> getRidesByDriverId(final Long driverId);

    Set<RideDTO> getRidesByAdminId(Long adminId);

    RideDTO createRide(CreateRideDTO rideDTO);

    void deleteRideById(final UUID rideId);

    ChangeRideStatusDTO changeRideStatus(final UUID rideId, final RideStatus rideStatus);
}
