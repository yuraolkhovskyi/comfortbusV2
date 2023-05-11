package com.transportation.comfortbus.service.impl;


import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.entity.PassengerSeatEntity;
import com.transportation.comfortbus.repository.PassengerSeatRepository;
import com.transportation.comfortbus.service.PassengerSeatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class PassengerSeatServiceImpl implements PassengerSeatService {

    private final ModelMapper modelMapper;
    private final PassengerSeatRepository passengerSeatRepository;

    @Override
    public Set<PassengerSeatDTO> mapPassengerSeatsFromEntityToDTO(final Set<PassengerSeatEntity> passengerSeatEntities) {
        final Set<PassengerSeatDTO> result = new HashSet<>();
        for (PassengerSeatEntity passengerSeatEntity : passengerSeatEntities) {
            result.add(modelMapper.map(passengerSeatEntity, PassengerSeatDTO.class));
        }
        return result;
    }

    @Override
    public Set<PassengerSeatEntity> mapPassengerSeatsFromDTOToEntity(Set<PassengerSeatDTO> passengerSeatDTOS) {

        final Set<PassengerSeatEntity> result = new HashSet<>();
        for (final PassengerSeatDTO passengerSeatDTO : passengerSeatDTOS) {
            result.add(modelMapper.map(passengerSeatDTO, PassengerSeatEntity.class));
        }
        return result;

    }

    @Override
    public Set<PassengerSeatEntity> findByIds(final Set<Integer> passengerSeats) {
        final Set<PassengerSeatEntity> result = new HashSet<>();
        for (final Integer passengerSeatId : passengerSeats) {
            final PassengerSeatEntity passengerSeatEntity = passengerSeatRepository
                    .findById(passengerSeatId.longValue()).orElseThrow();
            result.add(passengerSeatEntity);
        }
        return result;
    }

    @Override
    public void removePassengerSeatsByTicketBookingId(Long ticketBookingId) {
//        passengerSeatRepository.
    }

}
