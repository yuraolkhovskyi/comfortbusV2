package com.transportation.comfortbus.rest;

import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.dto.TicketDTO;
import com.transportation.comfortbus.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/ticket")
public class TicketRestController {

    private final TicketService ticketService;

    @GetMapping(value = "/get/ride/{rideId}")
    public Set<TicketDTO> getTicketBookingsByRideId(@PathVariable(value = "rideId") UUID rideId) {
        return ticketService.getTicketBookingsByRideId(rideId);
    }

    @GetMapping(value = "/get/ride/{rideId}/available-passenger-seat")
    public Set<PassengerSeatDTO> getAvailablePassengerSeatForBookingByRideId(@PathVariable(value = "rideId") UUID rideId) {
        return ticketService.getAvailablePassengerSeatForBookingByRideId(rideId);
    }

}
