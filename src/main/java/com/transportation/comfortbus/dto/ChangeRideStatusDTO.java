package com.transportation.comfortbus.dto;

import com.transportation.comfortbus.entity.enumeration.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class ChangeRideStatusDTO {

    private UUID id;
    private RideStatus rideStatus;

}
