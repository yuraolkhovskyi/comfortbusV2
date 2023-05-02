package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vehicle_stations")
@Entity
public class VehicleStationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy="departureStation")
    private Set<RideEntity> departureStationRides;

    @JsonIgnore
    @OneToMany(mappedBy="arrivalStation")
    private Set<RideEntity> arrivalStationRides;

    @JsonIgnore
    @OneToMany(mappedBy="")
    private Set<IntermediateStopEntity> intermediateStops;


}
