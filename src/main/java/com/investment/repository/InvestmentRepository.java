package com.investment.repository;

import com.investment.entity.InvestmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface InvestmentRepository extends JpaRepository<InvestmentEntity, UUID> {
    List<InvestmentEntity> findByUserId(UUID userId);
}
