package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.BookTicketDTO;
import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.dto.TicketDTO;
import com.transportation.comfortbus.entity.TicketBookingEntity;
import com.transportation.comfortbus.entity.enumeration.TicketBookingStatus;

import java.util.Set;
import java.util.UUID;

public interface TicketService {

    Set<TicketDTO> getPassengerSeatsByRideId(final Long ticketId);

    Set<TicketDTO> mapTicketsFromEntityToDTO(final Set<TicketBookingEntity> tickets);

    Set<TicketDTO> getTicketBookingsByRideId(final UUID rideId);

    Set<PassengerSeatDTO> getAvailablePassengerSeatForBookingByRideId(final UUID rideId);

    BookTicketDTO bookTicket(final BookTicketDTO bookTicketDTO);

    TicketDTO changeStatusOfATicketBooking(final Long ticketId, final TicketBookingStatus ticketStatus);
}
