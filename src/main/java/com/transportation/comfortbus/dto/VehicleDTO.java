package com.transportation.comfortbus.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.PassengerSeatEntity;
import com.transportation.comfortbus.entity.RideEntity;
import com.transportation.comfortbus.entity.converter.VehicleStatusEntityConverter;
import com.transportation.comfortbus.entity.converter.VehicleTypeEntityConverter;
import com.transportation.comfortbus.entity.enumeration.VehicleStatus;
import com.transportation.comfortbus.entity.enumeration.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDTO {

    @JsonIgnore
    private Long id;
    private VehicleType type;
    private String countryIdentifier;
    private VehicleStatus status;
    private Integer numberOfSeats;
    private Integer maxPeople;
    private Boolean isWiFi;
    private Boolean isRosette;
    private Boolean isTv;
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

//    private Set<RideEntity> rides;
//    private Set<PassengerSeatEntity> passengerSeats;
//
}
