package com.investment.repository;

import com.investment.entity.UserFamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserFamilyRepository extends JpaRepository<UserFamilyEntity, UUID> {
    List<UserFamilyEntity> findByUserId(UUID userId);
    List<UserFamilyEntity> findByFamilyId(UUID familyId);
}
