package com.investment.mapper;

import com.investment.entity.InvestmentEntity;
import com.investment.entity.UserEntity;
import com.investment.model.request.InvestmentRequest;
import com.investment.model.response.InvestmentResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class InvestmentMapper {

    public InvestmentEntity toEntity(InvestmentRequest request, UserEntity user) {
        return InvestmentEntity.builder()
                .user(user)
                .name(request.name())
                .type(request.assetType())
                .amount(request.investedAmount())
                .currency(request.currency())
                .purchaseDate(LocalDate.parse(request.InvestmentDate()))
                .build();
    }

    public InvestmentResponse toResponse(InvestmentEntity investment) {
        return InvestmentResponse.builder()
                .name(investment.getName())
                .assetType(investment.getType())
                .investedAmount(investment.getAmount())
                .currency(investment.getCurrency())
                .InvestmentDate(investment.getPurchaseDate().toString())
                .build();
    }
}
