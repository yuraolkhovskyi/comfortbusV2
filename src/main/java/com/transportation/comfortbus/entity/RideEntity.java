package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.converter.RideStatusEntityConverter;
import com.transportation.comfortbus.entity.enumeration.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rides")
@Entity
public class RideEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "uuid")
    private UUID id;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    @Convert(converter = RideStatusEntityConverter.class)
    private RideStatus status;

    @Column(name = "is_direct")
    private boolean isDirect;

    @Column(name = "price")
    private BigDecimal price;

    @JsonIgnore
    @OneToMany(mappedBy="ride")
    private Set<IntermediateStopEntity> intermediateStops;

    @JsonIgnore
    @OneToMany(mappedBy="ride")
    private Set<TicketBookingEntity> tickets;

    @ManyToOne
    @JoinColumn(name="administrator_id")
    private UserEntity administrator;

    @ManyToOne
    @JoinColumn(name="driver_id")
    private UserEntity driver;


    @ManyToOne
    @JoinColumn(name="departure_station_id")
    private VehicleStationEntity departureStation;

    @ManyToOne
    @JoinColumn(name="arrival_station_id")
    private VehicleStationEntity arrivalStation;

    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private VehicleEntity vehicle;


}
