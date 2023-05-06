package com.transportation.comfortbus.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PassengerSeatDTO {

    private Long id;
    private Integer seatRow;
    private String placeIdentifier;
    @JsonIgnore
    private VehicleEntity vehicle;

}
