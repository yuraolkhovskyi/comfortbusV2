package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.converter.VehicleStatusEntityConverter;
import com.transportation.comfortbus.entity.converter.VehicleTypeEntityConverter;
import com.transportation.comfortbus.entity.enumeration.VehicleStatus;
import com.transportation.comfortbus.entity.enumeration.VehicleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "vehicles")
@Entity
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.ORDINAL)
    @Convert(converter = VehicleTypeEntityConverter.class)
    private VehicleType type;

    @Column(name = "country_identifier")
    private String countryIdentifier;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    @Convert(converter = VehicleStatusEntityConverter.class)
    private VehicleStatus status;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;

    @Column(name = "max_people")
    private Integer maxPeople;

    @Column(name = "is_wifi")
    private Boolean isWiFi;

    @Column(name = "is_rosette")
    private Boolean isRosette;

    @Column(name = "is_tv")
    private Boolean isTv;

    @Column(name = "is_climate_control")
    private Boolean isClimateControl;

    @Column(name = "pets_allowance")
    private Boolean petsAllowance;

    @Column(name = "is_personal_seat_booking")
    private Boolean isPersonalSeatBooking;

    @Column(name = "personal_bicycle_place")
    private Boolean personalBicyclePlace;

    @Column(name = "seat_light")
    private Boolean seatLight;

    @Column(name = "toilet")
    private Boolean toilet;

    @Column(name = "additional_luggage")
    private Boolean additionalLuggage;

    @Column(name = "seat_belts")
    private Boolean seatBelts;

    @Column(name = "pwd_equipment")
    private Boolean pwdEquipment;

    @Column(name = "is_double_decker")
    private Boolean isDoubleDecker;

    @JsonIgnore
    @OneToMany(mappedBy="vehicle")
    private Set<RideEntity> rides;

    @JsonIgnore
    @OneToMany(mappedBy="vehicle")
    private Set<PassengerSeatEntity> passengerSeats;

}
