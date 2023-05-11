package com.transportation.comfortbus.repository;

import com.transportation.comfortbus.entity.TicketBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.UUID;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBookingEntity, Long> {

    @Query(value = "SELECT tbe FROM TicketBookingEntity tbe JOIN tbe.passengerSeats ps WHERE tbe.id = :ticketIt")
    Set<TicketBookingEntity> getPassengerSeatsByTicketId(@RequestParam Long ticketIt);

    Set<TicketBookingEntity> findTicketBookingEntitiesByRideId(@RequestParam UUID rideId);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM booking_passenger_seat where ticket_booking_id=?1")
    void removeAllBookedPassengerSeatsByTicketBookingId(@RequestParam Long ticketBookingId);

}
