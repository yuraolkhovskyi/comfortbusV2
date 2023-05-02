package com.transportation.comfortbus.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "address")
    private String address;

    //bus id
}
