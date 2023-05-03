package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.converter.PaymentTypeEntityConverter;
import com.transportation.comfortbus.entity.converter.TicketBookingStatusEntityConverter;
import com.transportation.comfortbus.entity.enumeration.PaymentType;
import com.transportation.comfortbus.entity.enumeration.TicketBookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tickets_bookings")
@Entity
public class TicketBookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    @Convert(converter = TicketBookingStatusEntityConverter.class)
    private TicketBookingStatus status;

    @Column(name = "bicycle_items")
    private Integer bicycleItems;

    @Column(name = "booking_date")
    private LocalDateTime bookingDate;


    @Column(name = "additional_luggage_items")
    private Integer additionalLuggageItems;

    @Column(name = "additional_user_comments")
    private String additionalUserComments;

    @Column(name = "payment_type")
    @Convert(converter = PaymentTypeEntityConverter.class)
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name="ride_id")
    private RideEntity ride;

    @ManyToOne
    @JoinColumn(name="banking_card_id")
    private BankingCardEntity bankingCard;

    @ManyToOne
    @JoinColumn(name="client_id")
    private UserEntity client;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "booking_passenger_seat",
            joinColumns = @JoinColumn(name = "ticket_booking_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_seat_id")
    )
    private Set<PassengerSeatEntity> passengerSeats;


}

