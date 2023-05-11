package com.transportation.comfortbus.service.impl;

import com.transportation.comfortbus.dto.BankingCardDTO;
import com.transportation.comfortbus.dto.BookTicketDTO;
import com.transportation.comfortbus.dto.PassengerSeatDTO;
import com.transportation.comfortbus.dto.TicketDTO;
import com.transportation.comfortbus.entity.*;
import com.transportation.comfortbus.entity.enumeration.PaymentType;
import com.transportation.comfortbus.entity.enumeration.TicketBookingStatus;
import com.transportation.comfortbus.entity.enumeration.UserRole;
import com.transportation.comfortbus.repository.TicketBookingRepository;
import com.transportation.comfortbus.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class TicketServiceImpl implements TicketService {

    private final TicketBookingRepository ticketBookingRepository;
    private final PassengerSeatService passengerSeatService;
    private final BankingCardService bankingCardService;
    private final UserService userService;
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

    @Override
    public BookTicketDTO bookTicket(final BookTicketDTO bookTicketDTO) {
        final TicketBookingEntity ticketBookingEntity = new TicketBookingEntity();

        ticketBookingEntity.setBookingDate(LocalDateTime.now());
        ticketBookingEntity.setStatus(TicketBookingStatus.BOOKED);
        ticketBookingEntity.setBicycleItems(bookTicketDTO.getBicycleItems());
        ticketBookingEntity.setRide(rideService.findById(bookTicketDTO.getRideId()));
        ticketBookingEntity.setPaymentType(bookTicketDTO.getPaymentType());
        ticketBookingEntity.setAdditionalLuggageItems(bookTicketDTO.getAdditionalLuggageItems());
        ticketBookingEntity.setAdditionalUserComments(bookTicketDTO.getAdditionalUserComments());

        if (bookTicketDTO.getPaymentType() == PaymentType.CREDIT_CARD) {
            final BankingCardDTO bankingCard = bookTicketDTO.getBankingCard();
            final BankingCardEntity bankingCardEntity = new BankingCardEntity()
                    .setCardNumber(bankingCard.getCardNumber())
                    .setCvcCode(bankingCard.getCvcCode())
                    .setOwner(bankingCard.getOwner())
                    .setStatus(bankingCard.getStatus())
                    .setExpirationDate(bankingCard.getExpirationDate());
            bankingCardService.save(bankingCardEntity);
            ticketBookingEntity.setBankingCard(bankingCardEntity);
        }

        final UserEntity clientUserEntity = new UserEntity()
                .setFirstname(bookTicketDTO.getClient().getFirstname())
                .setLastname(bookTicketDTO.getClient().getLastname())
                .setEmail(bookTicketDTO.getClient().getEmail())
                .setRegistrationDate(LocalDateTime.now())
                .setRole(UserRole.CLIENT);
        final UserEntity savedUserEntity = userService.save(clientUserEntity);
        ticketBookingEntity.setClient(savedUserEntity);

        final Set<PassengerSeatEntity> passengerSeatEntities = passengerSeatService
                .findByIds(bookTicketDTO.getPassengerSeatsIds());
        ticketBookingEntity.setPassengerSeats(passengerSeatEntities);

        final TicketBookingEntity saveTicket = ticketBookingRepository.save(ticketBookingEntity);

        return bookTicketDTO.setStatus(TicketBookingStatus.BOOKED).setId(saveTicket.getId());
    }

    @Override
    public TicketDTO changeStatusOfATicketBooking(final Long ticketId,
                                                  final TicketBookingStatus ticketStatus) {
        final TicketBookingEntity ticketBookingEntity = ticketBookingRepository.findById(ticketId).orElseThrow();

        switch (ticketStatus) {
            case CANCELLED -> {
                ticketBookingEntity.setStatus(TicketBookingStatus.CANCELLED).setPassengerSeats(null);
                deleteAllPassengerSeatsByTicketBookingId(ticketBookingEntity.getId());
//                paymentService.returnPaidMoney();
            }
            case PAID -> ticketBookingEntity.setStatus(TicketBookingStatus.PAID);
        }
        ticketBookingRepository.save(ticketBookingEntity);

        return mapTicketFromEntityToDTO(ticketBookingEntity);
    }

    @Transactional
    public void deleteAllPassengerSeatsByTicketBookingId(final Long ticketBookingId) {
        ticketBookingRepository.removeAllBookedPassengerSeatsByTicketBookingId(ticketBookingId);
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
