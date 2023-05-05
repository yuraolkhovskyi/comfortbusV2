package com.transportation.comfortbus.service.impl;

import com.transportation.comfortbus.dto.*;
import com.transportation.comfortbus.entity.*;
import com.transportation.comfortbus.exception.SystemException;
import com.transportation.comfortbus.exception.code.ServiceErrorCode;
import com.transportation.comfortbus.repository.RideRepository;
import com.transportation.comfortbus.service.RideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final ModelMapper modelMapper;

    @Override
    public Set<RideDTO> getActiveRidesByParams(final SearchRideRequestDTO searchRideRequestDTO) {
        validateSearchRequest(searchRideRequestDTO);

        final List<RideEntity> rideEntities = rideRepository.findAll();
        final Set<RideDTO> rideDTOS = mapRideEntitiesToDO(rideEntities);

        return rideDTOS.stream()
                .filter(rideDTO -> isMatchingTheCriteria(searchRideRequestDTO, rideEntities, rideDTO))
                .collect(Collectors.toSet());
    }

    private boolean isMatchingTheCriteria(final SearchRideRequestDTO searchRideRequestDTO,
                                          final List<RideEntity> rideEntities,
                                          final RideDTO rideDTO) {
        if (!searchRideRequestDTO.getDepartureCity().contains(rideDTO.getDepartureStation().getCity())) {
            return false;
        }

        if (!searchRideRequestDTO.getDepartureCountry().contains(rideDTO.getDepartureStation().getCountry().getCountryName())) {
            return false;
        }

        if (searchRideRequestDTO.getDepartureDate().compareTo(rideDTO.getDepartureDate().toLocalDate()) != 0) {
            return false;
        }

        if (!searchRideRequestDTO.getArrivalCountry().contains(rideDTO.getArrivalStation().getCountry().getCountryName())) {
            return false;
        }

        if (!searchRideRequestDTO.getArrivalCity().contains(rideDTO.getArrivalStation().getCity())) {
            return false;
        }

        final RideEntity rideEntity = rideEntities.stream().filter(e -> e.getId().equals(rideDTO.getId())).findFirst().orElseThrow();
        Integer numberOfSeatsLeftForBooking = calculateNumberOfSeatsLeft(rideEntity);
        if (numberOfSeatsLeftForBooking < searchRideRequestDTO.getAmountOfAdultPassengers()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getArrivalDate())
                && searchRideRequestDTO.getArrivalDate().compareTo(rideDTO.getArrivalDate().toLocalDate()) != 0) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getPriceRangeFrom())
                && searchRideRequestDTO.getPriceRangeFrom().compareTo(rideDTO.getPrice()) > 0) {
            return false;
        }


        if (Objects.nonNull(searchRideRequestDTO.getPriceRangeTo())
                && searchRideRequestDTO.getPriceRangeTo().compareTo(rideDTO.getPrice()) < 0) {
            return false;
        }

        Integer amountOfKidsPassengers = Optional.ofNullable(searchRideRequestDTO.getAmountOfKidsPassengers()).orElse(0);
        final int approximateNumberOfBookedSeatsTotal = numberOfSeatsLeftForBooking - (amountOfKidsPassengers + searchRideRequestDTO.getAmountOfAdultPassengers());
        if (approximateNumberOfBookedSeatsTotal < 0) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getIsDirect()) && searchRideRequestDTO.getIsDirect() != rideDTO.isDirect()) {
            return false;
        }

        final VehicleDTO vehicleDTO = rideDTO.getVehicleDTO();
        if (Objects.nonNull(searchRideRequestDTO.getIsWiFi())
                && searchRideRequestDTO.getIsWiFi() != vehicleDTO.getIsWiFi()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getIsRosette()) && searchRideRequestDTO.getIsRosette() != vehicleDTO.getIsRosette()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getIsClimateControl())
                && searchRideRequestDTO.getIsClimateControl() != vehicleDTO.getIsClimateControl()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getPetsAllowance()) &&
                searchRideRequestDTO.getPetsAllowance() != vehicleDTO.getPetsAllowance()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getIsPersonalSeatBooking())
                && searchRideRequestDTO.getIsPersonalSeatBooking() != vehicleDTO.getIsPersonalSeatBooking()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getPersonalBicyclePlace())
                && searchRideRequestDTO.getPersonalBicyclePlace() != vehicleDTO.getPersonalBicyclePlace()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getSeatLight())
                && searchRideRequestDTO.getSeatLight() != vehicleDTO.getSeatLight()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getToilet()) && searchRideRequestDTO.getToilet() != vehicleDTO.getToilet()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getAdditionalLuggage())
                && searchRideRequestDTO.getAdditionalLuggage() != vehicleDTO.getAdditionalLuggage()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getSeatBelts())
                && searchRideRequestDTO.getSeatBelts() != vehicleDTO.getSeatBelts()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getPwdEquipment())
                && searchRideRequestDTO.getPwdEquipment() != vehicleDTO.getPwdEquipment()) {
            return false;
        }

        if (Objects.nonNull(searchRideRequestDTO.getIsDoubleDecker())
                && searchRideRequestDTO.getIsDoubleDecker() != vehicleDTO.getIsDoubleDecker()) {
            return false;
        }

        return true;
    }

    private void validateSearchRequest(final SearchRideRequestDTO searchRideRequestDTO) {
        if (Objects.isNull(searchRideRequestDTO.getDepartureCity())) {
            throw new SystemException("Departure city mandatory parameter is missing", ServiceErrorCode.BAD_REQUEST);
        }
        if (Objects.isNull(searchRideRequestDTO.getDepartureCountry())) {
            throw new SystemException("Departure country mandatory parameter is missing", ServiceErrorCode.BAD_REQUEST);
        }
        if (Objects.isNull(searchRideRequestDTO.getArrivalCountry())) {
            throw new SystemException("Arrival country mandatory parameter is missing", ServiceErrorCode.BAD_REQUEST);
        }
        if (Objects.isNull(searchRideRequestDTO.getArrivalCity())) {
            throw new SystemException("Arrival city mandatory parameter is missing", ServiceErrorCode.BAD_REQUEST);
        }
        if (Objects.isNull(searchRideRequestDTO.getDepartureDate())) {
            throw new SystemException("Departure date mandatory parameter is missing", ServiceErrorCode.BAD_REQUEST);
        }
        if (Objects.isNull(searchRideRequestDTO.getAmountOfAdultPassengers())) {
            throw new SystemException("Amount Of Adult Passengers mandatory parameter is missing", ServiceErrorCode.BAD_REQUEST);
        }

    }

    private Set<RideDTO> mapRideEntitiesToDO(List<RideEntity> all) {
        final Set<RideDTO> result = new HashSet<>();
        for (RideEntity rideEntity : all) {

            final RideDTO rideDTO = modelMapper.map(rideEntity, RideDTO.class);

            rideDTO.setIntermediateStops(mapIntermediateStopsFromEntityToDTO(rideEntity));

            final Integer numberOfFreeSeatsLeft = calculateNumberOfSeatsLeft(rideEntity);
            rideDTO.setNumberOfTicketsLeft(numberOfFreeSeatsLeft);


            rideDTO.setDepartureStation(mapVehicleStationFromEntityToDTO(rideEntity.getDepartureStation()));
            rideDTO.setArrivalStation(mapVehicleStationFromEntityToDTO(rideEntity.getArrivalStation()));
            rideDTO.setVehicleDTO(mapVehicleFromEntityToDTO(rideEntity.getVehicle()));
            rideDTO.setAdministrator(mapUserFromEntityToDTO(rideEntity.getAdministrator()));
            rideDTO.setDriver(mapUserFromEntityToDTO(rideEntity.getDriver()));

            result.add(rideDTO);

        }
        return result;
    }

    private Integer calculateNumberOfSeatsLeft(RideEntity rideEntity) {
        return rideEntity.getVehicle().getNumberOfSeats() - getNumberOfTotalBookedSeats(rideEntity.getTickets());
    }

    private Integer getNumberOfTotalBookedSeats(final Set<TicketBookingEntity> tickets) {
//
//        for (TicketBookingEntity ticket : tickets) {
//
//            final TicketDTO ticketDTO = modelMapper.map(ticket, TicketDTO.class);
//
//
//            mapRideFromEntityToDTO(ticket.getRide())
//
//        }


        int sum = 0;
        for (TicketBookingEntity ticket : tickets) {
            Set<PassengerSeatEntity> passengerSeats = ticket.getPassengerSeats();
            int size = passengerSeats.size();
            sum += size;
        }
        return sum;

    }

    private RideDTO mapRideFromEntityToDTO(final RideEntity rideEntity) {
        modelMapper.map(rideEntity, RideDTO.class);
        return null;
    }

    private UserDTO mapUserFromEntityToDTO(final UserEntity administrator) {
        return modelMapper.map(administrator, UserDTO.class);
    }

    private VehicleDTO mapVehicleFromEntityToDTO(final VehicleEntity vehicle) {
        return modelMapper.map(vehicle, VehicleDTO.class);
    }

    private Set<IntermediateStopDTO> mapIntermediateStopsFromEntityToDTO(final RideEntity rideEntity) {

        final Set<IntermediateStopDTO> result = new HashSet<>();
        for (final IntermediateStopEntity intermediateStopEntity : rideEntity.getIntermediateStops()) {

            final IntermediateStopDTO intermediateStopDTO = modelMapper.map(intermediateStopEntity, IntermediateStopDTO.class);
            intermediateStopDTO.setVehicleStationDTO(mapVehicleStationFromEntityToDTO(intermediateStopEntity.getVehicleStation()));
            result.add(intermediateStopDTO);
        }

        return result;
    }

    private VehicleStationDTO mapVehicleStationFromEntityToDTO(final VehicleStationEntity vehicleStationEntity) {
        return modelMapper.map(vehicleStationEntity, VehicleStationDTO.class);
    }

}
