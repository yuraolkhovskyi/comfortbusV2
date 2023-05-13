package com.transportation.comfortbus.dto;

import com.transportation.comfortbus.entity.enumeration.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRideDTO {

    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Long departureStationId;
    private Long arrivalStationId;
    private RideStatus status;
    private boolean isDirect;
    private BigDecimal price;

    private Set<Long> intermediateStops;
    private Long administratorId;
    private Long driverId;
    private Long vehicleId;

}
