package com.transportation.comfortbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.transportation.comfortbus.entity.enumeration.BankingCardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
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
    private String cardNumber;

    @Column(name = "cvcCode")
    private Integer cvcCode;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "owner")
    private String owner;

    @JsonIgnore
    @OneToMany(mappedBy="bankingCard")
    private Set<TicketBookingEntity> tickets;

}
