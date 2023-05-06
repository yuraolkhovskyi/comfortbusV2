package com.transportation.comfortbus.repository;

import com.transportation.comfortbus.entity.TicketBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.UUID;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBookingEntity, Long> {


//    @Query(value = "SELECT ce FROM CourseEntity ce " + " JOIN ce.people uss WHERE uss.id = :userId")
//    Set<CourseEntity> getCourseEntitiesByUserId(@RequestParam Long userId);

    @Query(value = "SELECT tbe FROM TicketBookingEntity tbe JOIN tbe.passengerSeats ps WHERE tbe.id = :ticketIt")
    Set<TicketBookingEntity> getPassengerSeatsByTicketId(@RequestParam Long ticketIt);

    Set<TicketBookingEntity> findTicketBookingEntitiesByRideId(@RequestParam UUID rideId);

}
