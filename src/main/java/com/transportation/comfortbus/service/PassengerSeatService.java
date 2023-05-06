package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.dto.RideDTO;
import com.transportation.comfortbus.dto.RideStatusDTO;
import com.transportation.comfortbus.dto.SearchRideRequestDTO;
import com.transportation.comfortbus.entity.PassengerSeatEntity;
import com.transportation.comfortbus.entity.RideEntity;

import java.util.Set;
import java.util.UUID;

public interface PassengerSeatService {

    Set<PassengerSeatDTO> mapPassengerSeatsFromEntityToDTO(final Set<PassengerSeatEntity> passengerSeatEntities);
}
