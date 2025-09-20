package com.investment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "families")
public class UserFamilyEntity {
    @Id
    @GeneratedValue
    private UUID userFamilyId;

    @Column
    private UUID userId;
    
    @Column
    private UUID familyId;
}
