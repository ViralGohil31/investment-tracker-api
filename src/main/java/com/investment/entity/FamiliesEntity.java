package com.investment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "families")
public class FamiliesEntity {

    @Id
    @GeneratedValue
    private UUID familyId;

    @Column(nullable = false)
    private String familyName;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}
