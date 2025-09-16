package com.investment.model.request;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record InvestmentRequest(
        UUID id,
        String assetIdentificationNumber,
        String assetType,
        String name,
        String InvestmentDate,
        String currency,
        String maturityDate,
        BigDecimal investedAmount,
        String rateOfInterest,
        String createdDate,
        String updatedDate
) {
}
