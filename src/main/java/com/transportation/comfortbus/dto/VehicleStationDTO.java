package com.transportation.comfortbus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transportation.comfortbus.entity.enumeration.CountryCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleStationDTO {

    @JsonProperty(value = "countryCode")
    private CountryCode country;
    private String city;
    private String address;

}
