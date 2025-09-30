package com.investment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Data
@Entity
@Table(name = "user_family")
public class UserFamilyEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = false)
    private FamilyEntity family;
}
