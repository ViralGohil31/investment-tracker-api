package com.investment.model.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record InvestmentResponse(
        String assetIdentificationNumber,
        String assetType,
        String name,
        String InvestmentDate,
        String currency,
        String maturityDate,
        BigDecimal investedAmount,
        String rateOfInterest
) {
}
