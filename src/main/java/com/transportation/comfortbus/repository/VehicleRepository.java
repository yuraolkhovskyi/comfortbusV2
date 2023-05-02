package com.transportation.comfortbus.repository;

import com.transportation.comfortbus.entity.VehicleEntity;
import com.transportation.comfortbus.entity.VehicleStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

}
