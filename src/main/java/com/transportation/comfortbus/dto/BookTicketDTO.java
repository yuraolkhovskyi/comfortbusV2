package com.transportation.comfortbus.dto;

import com.transportation.comfortbus.entity.enumeration.PaymentType;
import com.transportation.comfortbus.entity.enumeration.TicketBookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class BookTicketDTO {

    private Long id;
    private TicketBookingStatus status;
    private Integer bicycleItems;
    private LocalDateTime bookingDate;
    private Integer additionalLuggageItems;
    private String additionalUserComments;
    private PaymentType paymentType;

    private UUID rideId;
    private BankingCardDTO bankingCard;
    private UserDTO client;
    private Set<Integer> passengerSeatsIds;

}
