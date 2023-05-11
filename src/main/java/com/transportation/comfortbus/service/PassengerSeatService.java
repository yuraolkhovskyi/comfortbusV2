package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.entity.PassengerSeatEntity;

import java.util.Set;

public interface PassengerSeatService {

    Set<PassengerSeatDTO> mapPassengerSeatsFromEntityToDTO(final Set<PassengerSeatEntity> passengerSeatEntities);

    Set<PassengerSeatEntity> mapPassengerSeatsFromDTOToEntity(final Set<PassengerSeatDTO> passengerSeatEntities);

    Set<PassengerSeatEntity> findByIds(final Set<Integer> passengerSeats);

    void removePassengerSeatsByTicketBookingId(final Long ticketBookingId);
}
