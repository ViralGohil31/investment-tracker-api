package com.investment.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Data
@Entity
@Table(name = "families")
public class FamilyEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String familyName;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<UserFamilyEntity> users;

}
