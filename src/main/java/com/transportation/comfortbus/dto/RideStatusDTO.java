package com.transportation.comfortbus.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.transportation.comfortbus.entity.enumeration.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class RideStatusDTO {

    private RideStatus rideStatus;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String coordinates;

}
