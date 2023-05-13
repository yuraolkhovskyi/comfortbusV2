package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.converter.RideStatusEntityConverter;
import com.transportation.comfortbus.entity.enumeration.RideStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
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
    @OneToMany(mappedBy = "ride")
    private Set<IntermediateStopEntity> intermediateStops;

    @JsonIgnore
    @OneToMany(mappedBy = "ride")
    private Set<TicketBookingEntity> tickets;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private UserEntity administrator;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private UserEntity driver;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "departure_station_id")
    private VehicleStationEntity departureStation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "arrival_station_id")
    private VehicleStationEntity arrivalStation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;


}
