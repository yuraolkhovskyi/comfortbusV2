package com.transportation.comfortbus.rest;

import com.transportation.comfortbus.dto.*;
import com.transportation.comfortbus.dto.enumeration.RideFilterType;
import com.transportation.comfortbus.entity.enumeration.RideStatus;
import com.transportation.comfortbus.service.RideService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/ride")
public class RideRestController {

    private final RideService rideService;

    //admin driver client
    @GetMapping(value = "/search")
    public Set<RideDTO> getRidesByParams(@RequestParam(value = "departureCity") String departureCity,
                                         @RequestParam(value = "departureCountry") String departureCountry,
                                         @RequestParam(value = "arrivalCountry") String arrivalCountry,
                                         @RequestParam(value = "arrivalCity") String arrivalCity,
                                         @RequestParam(value = "departureDate") LocalDate departureDate,
                                         @RequestParam(value = "amountOfAdultPassengers") Integer amountOfAdultPassengers,

                                         //optional
                                         @RequestParam(value = "arrivalDate", required = false) LocalDate arrivalDate,

                                         //return
                                         @RequestParam(value = "returnTicket", required = false) Boolean returnTicket, // if true than returnDate should be specified
                                         @RequestParam(value = "returnDateDeparture", required = false) LocalDate returnDateDeparture,
                                         @RequestParam(value = "returnDateArrival", required = false) LocalDate returnDateArrival,

                                         @RequestParam(value = "priceRangeFrom", required = false) BigDecimal priceRangeFrom,
                                         @RequestParam(value = "priceRangeTo", required = false) BigDecimal priceRangeTo,

                                         @RequestParam(value = "amountOfKidsPassengers", required = false) Integer amountOfKidsPassengers,
                                         @RequestParam(value = "amountOfPersonalKidsSeats", required = false) Integer amountOfKidsSeats,

                                         @RequestParam(value = "isDirect", required = false) Boolean isDirect,
                                         @RequestParam(value = "isWiFi", required = false) Boolean isWiFi,
                                         @RequestParam(value = "isRosette", required = false) Boolean isRosette,
                                         @RequestParam(value = "isClimateControl", required = false) Boolean isClimateControl,
                                         @RequestParam(value = "petsAllowance", required = false) Boolean petsAllowance,
                                         @RequestParam(value = "isPersonalSeatBooking", required = false) Boolean isPersonalSeatBooking,
                                         @RequestParam(value = "personalBicyclePlace", required = false) Boolean personalBicyclePlace,
                                         @RequestParam(value = "seatLight", required = false) Boolean seatLight,
                                         @RequestParam(value = "toilet", required = false) Boolean toilet,
                                         @RequestParam(value = "additionalLuggage", required = false) Boolean additionalLuggage,
                                         @RequestParam(value = "seatBelts", required = false) Boolean seatBelts,
                                         @RequestParam(value = "pwdEquipment", required = false) Boolean pwdEquipment,
                                         @RequestParam(value = "isDoubleDecker", required = false) Boolean isDoubleDecker,
                                         @RequestParam(value = "filterBy", required = false) RideFilterType rideFilterType
    ) {
        final SearchRideRequestDTO searchRideRequestDTO = new SearchRideRequestDTO()
                .setDepartureCity(departureCity)
                .setDepartureCountry(departureCountry)
                .setArrivalCountry(arrivalCountry)
                .setArrivalCity(arrivalCity)
                .setDepartureDate(departureDate)
                .setAmountOfAdultPassengers(amountOfAdultPassengers)
                .setArrivalDate(arrivalDate)
                .setReturnTicket(returnTicket)
                .setReturnDateDeparture(returnDateDeparture)
                .setReturnDateArrival(returnDateArrival)
                .setPriceRangeFrom(priceRangeFrom)
                .setPriceRangeTo(priceRangeTo)
                .setAmountOfKidsPassengers(amountOfKidsPassengers)
                .setAmountOfKidsSeats(amountOfKidsSeats)
                .setIsDirect(isDirect)
                .setIsWiFi(isWiFi)
                .setIsRosette(isRosette)
                .setIsClimateControl(isClimateControl)
                .setPetsAllowance(petsAllowance)
                .setIsPersonalSeatBooking(isPersonalSeatBooking)
                .setPersonalBicyclePlace(personalBicyclePlace)
                .setSeatLight(seatLight)
                .setToilet(toilet)
                .setAdditionalLuggage(additionalLuggage)
                .setSeatBelts(seatBelts)
                .setPwdEquipment(pwdEquipment)
                .setIsDoubleDecker(isDoubleDecker)
                .setRideFilterType(rideFilterType);
        return rideService.getActiveRidesByParams(searchRideRequestDTO);
    }

    //admin driver
    @GetMapping(value = "/{rideId}/status")
    public RideStatusDTO getRideStatusByRideId(@PathVariable(value = "rideId") UUID rideId) {
        return rideService.getRideStatusByRideId(rideId);
    }

    //admin driver
    @GetMapping(value = "/{rideId}/details")
    public RideDTO getAllRideDetailsById(@PathVariable UUID rideId) {
        return rideService.getAllRideDetailsById(rideId);
    }


    //admin driver
    @GetMapping(value = "/get/driver/{driverId}")
    public Set<RideDTO> getAllRidesByDriverId(@PathVariable Long driverId) {
        return rideService.getRidesByDriverId(driverId);
    }


    //only admin access
    @GetMapping(value = "/get/admin/{adminId}")
    public Set<RideDTO> getAllRidesByAdminId(@PathVariable Long adminId) {
        return rideService.getRidesByAdminId(adminId);
    }

    //only admin access
    @PostMapping(value = "/create")
    public RideDTO createRide(@RequestBody CreateRideDTO createRideDTO) {
        return rideService.createRide(createRideDTO);
    }

    //admin
    @PostMapping(value = "/{rideId}/delete")
    public void deleteRide(@PathVariable UUID rideId) {
        rideService.deleteRideById(rideId);
    }

    //admin
    @PostMapping(value = "/{rideId}/change-status/{rideStatus}")
    public ChangeRideStatusDTO changeRideStatus(@PathVariable final UUID rideId,
                                                @PathVariable final RideStatus rideStatus) {
        return rideService.changeRideStatus(rideId, rideStatus);
    }

}
