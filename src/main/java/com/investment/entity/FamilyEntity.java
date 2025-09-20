package com.investment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "families")
public class FamilyEntity {

    @Id
    @GeneratedValue
    private UUID familyId;

    @Column(nullable = false)
    private String familyName;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "family", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserFamilyEntity> users;

}
