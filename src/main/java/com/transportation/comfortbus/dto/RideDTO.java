package com.transportation.comfortbus.dto;

import com.transportation.comfortbus.entity.enumeration.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RideDTO {

    private UUID id;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private VehicleStationDTO departureStation;
    private VehicleStationDTO arrivalStation;
    private RideStatus status;
    private boolean isDirect;
    private BigDecimal price;
    private Integer numberOfTicketsLeft;


    private Set<IntermediateStopDTO> intermediateStops;
    private Set<TicketDTO> tickets;
    private UserDTO administrator;
    private UserDTO driver;
    private VehicleDTO vehicleDTO;

}
