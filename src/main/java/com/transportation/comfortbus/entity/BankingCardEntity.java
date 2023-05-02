package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.enumeration.BankingCardStatus;
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
@Table(name = "banking_card")
@Entity
public class BankingCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    private BankingCardStatus status;

    @Column(name = "number")
    private Integer cardNumber;

    @Column(name = "cvcCode")
    private Integer cvcCode;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @JsonIgnore
    @OneToMany(mappedBy="bankingCard")
    private Set<TicketBookingEntity> tickets;

}
