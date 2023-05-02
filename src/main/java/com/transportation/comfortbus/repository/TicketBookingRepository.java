package com.transportation.comfortbus.repository;

import com.transportation.comfortbus.entity.TicketBookingEntity;
import com.transportation.comfortbus.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingRepository extends JpaRepository<TicketBookingEntity, Long> {
}
