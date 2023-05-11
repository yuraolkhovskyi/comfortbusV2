package com.transportation.comfortbus.dto;

import com.transportation.comfortbus.dto.enumeration.RideFilterType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class SearchRideRequestDTO {

    private String departureCity;
    private String departureCountry;
    private LocalDate departureDate;
    private String arrivalCountry;
    private String arrivalCity;
    private Integer amountOfAdultPassengers;

    private LocalDate arrivalDate;
    private Boolean returnTicket; // TODO: 05.05.2023
    private LocalDate returnDateDeparture;
    private LocalDate returnDateArrival;
    private BigDecimal priceRangeFrom;
    private BigDecimal priceRangeTo;
    private Integer amountOfKidsPassengers;
    private Integer amountOfKidsSeats;
    private Boolean isDirect;
    private Boolean isWiFi;
    private Boolean isRosette;
    private Boolean isClimateControl;
    private Boolean petsAllowance;
    private Boolean isPersonalSeatBooking;
    private Boolean personalBicyclePlace;
    private Boolean seatLight;
    private Boolean toilet;
    private Boolean additionalLuggage;
    private Boolean seatBelts;
    private Boolean pwdEquipment;
    private Boolean isDoubleDecker;
    private RideFilterType rideFilterType;

}
