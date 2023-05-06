package com.transportation.comfortbus.service.impl;

import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.dto.TicketDTO;
import com.transportation.comfortbus.entity.BankingCardEntity;
import com.transportation.comfortbus.entity.PassengerSeatEntity;
import com.transportation.comfortbus.entity.RideEntity;
import com.transportation.comfortbus.entity.TicketBookingEntity;
import com.transportation.comfortbus.repository.TicketBookingRepository;
import com.transportation.comfortbus.service.BankingCardService;
import com.transportation.comfortbus.service.PassengerSeatService;
import com.transportation.comfortbus.service.RideService;
import com.transportation.comfortbus.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketBookingRepository ticketBookingRepository;
    private final PassengerSeatService passengerSeatService;
    private final BankingCardService bankingCardService;
    private final RideService rideService;
    private final ModelMapper modelMapper;


    @Override
    public Set<TicketDTO> getPassengerSeatsByRideId(final Long ticketId) {

        final Set<TicketBookingEntity> passengerSeatsByRideId = ticketBookingRepository
                .getPassengerSeatsByTicketId(ticketId);

        return mapTicketsFromEntityToDTO(passengerSeatsByRideId);
    }

    @Override
    public Set<TicketDTO> mapTicketsFromEntityToDTO(final Set<TicketBookingEntity> ticketsEntities) {
        final Set<TicketDTO> result = new HashSet<>();
        for (TicketBookingEntity ticketEntity : ticketsEntities) {
            final TicketDTO ticketDTO = mapTicketFromEntityToDTO(ticketEntity);
            result.add(ticketDTO);
        }
        return result;
    }

    @Override
    public Set<TicketDTO> getTicketBookingsByRideId(final UUID rideId) {


        final Set<TicketBookingEntity> ticketBookingEntitiesByRideId = ticketBookingRepository
                .findTicketBookingEntitiesByRideId(rideId);

        return mapTicketsFromEntityToDTO(ticketBookingEntitiesByRideId);
    }

    @Override
    public Set<PassengerSeatDTO> getAvailablePassengerSeatForBookingByRideId(final UUID rideId) {
        final Set<TicketDTO> ticketBookingsByRideId = getTicketBookingsByRideId(rideId);

        final Set<PassengerSeatEntity> bookedPassengerSeats = ticketBookingsByRideId.stream()
                .map(TicketDTO::getPassengerSeats)
                .flatMap(Set::stream)
                .collect(Collectors.toSet());

        final RideEntity rideEntity = rideService.findById(rideId);
        final Set<PassengerSeatEntity> allPassengerSeatsByVehicle = rideEntity.getVehicle().getPassengerSeats();

        allPassengerSeatsByVehicle.removeAll(bookedPassengerSeats);

        return passengerSeatService.mapPassengerSeatsFromEntityToDTO(allPassengerSeatsByVehicle).stream()
                .sorted(Comparator.comparing(PassengerSeatDTO::getId))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private TicketDTO mapTicketFromEntityToDTO(final TicketBookingEntity ticketEntity) {
        final TicketDTO ticketDTO = modelMapper.map(ticketEntity, TicketDTO.class);

        final BankingCardEntity bankingCardEntity = ticketEntity.getBankingCard();
        if (Objects.nonNull(bankingCardEntity)) {
            ticketDTO.setBankingCard(bankingCardService.mapBankingCardFromEntityToDTO(bankingCardEntity));
        }

        return ticketDTO;
    }

}
