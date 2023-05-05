package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="ride_id")
    private RideEntity ride;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="vehicle_station_id")
    private VehicleStationEntity vehicleStation;

}
