package com.transportation.comfortbus.rest;

import com.transportation.comfortbus.dto.BookTicketDTO;
import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.dto.TicketDTO;
import com.transportation.comfortbus.entity.enumeration.TicketBookingStatus;
import com.transportation.comfortbus.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/ticket")
public class TicketRestController {

    private final TicketService ticketService;

    //admin driver
    @GetMapping(value = "/get/ride/{rideId}")
    public Set<TicketDTO> getTicketBookingsByRideId(@PathVariable(value = "rideId") UUID rideId) {
        return ticketService.getTicketBookingsByRideId(rideId);
    }

    //admin driver client
    @GetMapping(value = "/get/ride/{rideId}/available-passenger-seat")
    public Set<PassengerSeatDTO> getAvailablePassengerSeatForBookingByRideId(@PathVariable(value = "rideId") UUID rideId) {
        return ticketService.getAvailablePassengerSeatForBookingByRideId(rideId);
    }

    //admin driver client
    @PostMapping(value = "/book")
    public BookTicketDTO bookTicket(@RequestBody BookTicketDTO bookTicketDTO) {
        return ticketService.bookTicket(bookTicketDTO);
    }

    //admin driver client
    @PostMapping(value = "/{ticketId}/change-status/{ticketStatus}")
    public TicketDTO changeStatusOfATicketBooking(@PathVariable Long ticketId,
                                                  @PathVariable TicketBookingStatus ticketStatus) {
        return ticketService.changeStatusOfATicketBooking(ticketId, ticketStatus);
    }

}
