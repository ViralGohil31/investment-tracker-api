package com.investment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "investments")
public class InvestmentEntity {
    private UUID id;
    private String userId;
    private String name;
    private String type;
    private BigDecimal amount;
    private String currency;
    private String purchase_date;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

}
