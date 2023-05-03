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
@Table(name = "passenger_seats")
@Entity
public class PassengerSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_row")
    private Integer seatRow;

    @Column(name = "place_identifier")
    private String placeIdentifier;

    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private VehicleEntity vehicle;

    @JsonIgnore
    @ManyToMany(mappedBy = "passengerSeats")
    private Set<TicketBookingEntity> tickets;


}
