package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.converter.CountryCodeEntityConverter;
import com.transportation.comfortbus.entity.enumeration.CountryCode;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @Enumerated(EnumType.ORDINAL)
    @Convert(converter = CountryCodeEntityConverter.class)
    private CountryCode country;

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
    @OneToMany(mappedBy="vehicleStation")
    private Set<IntermediateStopEntity> intermediateStops;


}
