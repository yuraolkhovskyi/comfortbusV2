package com.transportation.comfortbus.repository;

import com.transportation.comfortbus.entity.RideEntity;
import com.transportation.comfortbus.entity.TicketBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RideRepository extends JpaRepository<RideEntity, UUID> {



}
