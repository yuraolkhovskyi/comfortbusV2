package com.transportation.comfortbus.repository;

import com.transportation.comfortbus.entity.BankingCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingCardRepository extends JpaRepository<BankingCardEntity, Long> {
}
