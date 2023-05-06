package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.dto.TicketDTO;
import com.transportation.comfortbus.entity.TicketBookingEntity;

import java.util.Set;
import java.util.UUID;

public interface TicketService {

    Set<TicketDTO> getPassengerSeatsByRideId(final Long ticketId);

    Set<TicketDTO> mapTicketsFromEntityToDTO(final Set<TicketBookingEntity> tickets);

    Set<TicketDTO> getTicketBookingsByRideId(final UUID rideId);

    Set<PassengerSeatDTO> getAvailablePassengerSeatForBookingByRideId(final UUID rideId);
}
