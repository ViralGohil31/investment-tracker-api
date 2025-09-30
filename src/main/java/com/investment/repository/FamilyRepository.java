package com.investment.repository;

import com.investment.entity.FamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FamilyRepository extends JpaRepository<FamilyEntity, UUID> {

}
