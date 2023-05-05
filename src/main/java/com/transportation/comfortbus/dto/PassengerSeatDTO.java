package com.transportation.comfortbus.dto;

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
    private VehicleEntity vehicle;

}
