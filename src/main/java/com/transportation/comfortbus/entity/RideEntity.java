package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.converter.RideStatusEntityConverter;
import com.transportation.comfortbus.entity.enumeration.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rides")
@Entity
public class RideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "arrival_date")
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


    //admin_id

    //driver_id

    //direction from

    //direction to

    //vehicle id

}
