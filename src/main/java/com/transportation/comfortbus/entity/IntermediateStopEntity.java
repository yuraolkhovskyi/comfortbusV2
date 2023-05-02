package com.transportation.comfortbus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "intermediate_stops")
@Entity
public class IntermediateStopEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stop_start_time")
    private LocalDateTime stopStartTime;

    @Column(name = "stop_end_time")
    private LocalDateTime stopEndTime;

    @ManyToOne
    @JoinColumn(name="ride_id")
    private RideEntity ride;

    @ManyToOne
    @JoinColumn(name="vehicle_station_id")
    private VehicleStationEntity vehicleStation;


    //ride_id

    //station_id

}
