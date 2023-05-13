package com.transportation.comfortbus.repository;

import com.transportation.comfortbus.entity.RideEntity;
import com.transportation.comfortbus.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;
import java.util.UUID;

@Repository
public interface RideRepository extends JpaRepository<RideEntity, UUID> {

    @Query(value = "select re from RideEntity re where re.driver= :driver")
    Set<RideEntity> findAllByDriverId(@RequestParam UserEntity driver);

    @Query(value = "select re from RideEntity re where re.administrator= :administrator")
    Set<RideEntity> findAllByAdminId(@RequestParam final UserEntity administrator);


//    @Query(value = "SELECT ce FROM CourseEntity ce " + " JOIN ce.people uss WHERE uss.id = :userId")
//    Set<CourseEntity> getCourseEntitiesByUserId(@RequestParam Long userId);
}
