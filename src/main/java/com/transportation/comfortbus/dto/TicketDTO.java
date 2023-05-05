package com.transportation.comfortbus.dto;

import com.transportation.comfortbus.entity.*;
import com.transportation.comfortbus.entity.enumeration.PaymentType;
import com.transportation.comfortbus.entity.enumeration.TicketBookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDTO {

    private Long id;
    private TicketBookingStatus status;
    private Integer bicycleItems;
    private LocalDateTime bookingDate;
    private Integer additionalLuggageItems;
    private String additionalUserComments;
    private PaymentType paymentType;

    private RideEntity ride;
    private BankingCardEntity bankingCard;
    private UserEntity client;
    private Set<PassengerSeatEntity> passengerSeats;

}
