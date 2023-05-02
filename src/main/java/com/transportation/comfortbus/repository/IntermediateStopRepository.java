package com.transportation.comfortbus.repository;

import com.transportation.comfortbus.entity.RideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntermediateStopRepository extends JpaRepository<RideEntity, Long> {

}
