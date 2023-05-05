package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.RideDTO;
import com.transportation.comfortbus.dto.SearchRideRequestDTO;

import java.util.Set;

public interface RideService {

    Set<RideDTO> getActiveRidesByParams(final SearchRideRequestDTO searchRideRequestDTO);

}
