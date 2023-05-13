package com.transportation.comfortbus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IntermediateStopDTO {

    private Long id;
    private LocalDateTime stopStartTime;
    private LocalDateTime stopEndTime;
    private VehicleStationDTO vehicleStationDTO;

}
