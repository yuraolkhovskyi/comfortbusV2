package com.transportation.comfortbus.entity;

import com.transportation.comfortbus.entity.converter.PaymentTypeEntityConverter;
import com.transportation.comfortbus.entity.converter.TicketBookingStatusEntityConverter;
import com.transportation.comfortbus.entity.enumeration.PaymentType;
import com.transportation.comfortbus.entity.enumeration.TicketBookingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "additional_luggage_items")
    private Integer additionalLuggageItems;

    @Column(name = "additional_user_comments")
    private Integer additionalUserComments;

    @Column(name = "payment_type")
    @Convert(converter = PaymentTypeEntityConverter.class)
    private PaymentType paymentType;

    //ride_id
    //user_id
    //banking_card_details_id
}

