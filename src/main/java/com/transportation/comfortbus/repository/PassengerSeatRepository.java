package com.transportation.comfortbus.repository;

import com.transportation.comfortbus.entity.PassengerSeatEntity;
import com.transportation.comfortbus.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerSeatRepository extends JpaRepository<PassengerSeatEntity, Long> {

}
