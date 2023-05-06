package com.transportation.comfortbus.service;

import com.transportation.comfortbus.dto.BankingCardDTO;
import com.transportation.comfortbus.dto.UserDTO;
import com.transportation.comfortbus.entity.BankingCardEntity;
import com.transportation.comfortbus.entity.UserEntity;


public interface BankingCardService {

    BankingCardDTO mapBankingCardFromEntityToDTO(final BankingCardEntity bankingCard);

}
