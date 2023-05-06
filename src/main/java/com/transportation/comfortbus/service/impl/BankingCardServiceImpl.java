package com.transportation.comfortbus.service.impl;


import com.transportation.comfortbus.dto.BankingCardDTO;
import com.transportation.comfortbus.entity.BankingCardEntity;
import com.transportation.comfortbus.service.BankingCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BankingCardServiceImpl implements BankingCardService {

    private final ModelMapper modelMapper;

    @Override
    public BankingCardDTO mapBankingCardFromEntityToDTO(final BankingCardEntity bankingCard) {
        return modelMapper.map(bankingCard, BankingCardDTO.class);
    }

}