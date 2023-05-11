package com.transportation.comfortbus.dto;

import com.transportation.comfortbus.entity.enumeration.BankingCardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankingCardDTO {

    private Long id;
    private BankingCardStatus status;
    private String cardNumber;
    private Integer cvcCode;
    private LocalDateTime expirationDate;
    private String owner;


    public BankingCardDTO(String cardNumber,
                          Integer cvcCode,
                          LocalDateTime expirationDate,
                          String owner) {
        this.cardNumber = cardNumber;
        this.cvcCode = cvcCode;
        this.expirationDate = expirationDate;
        this.owner = owner;
    }
}
