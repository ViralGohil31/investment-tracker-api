package com.investment.service;

import com.investment.model.request.InvestmentRequest;
import com.investment.repository.InvestmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    public UUID createInvestment(InvestmentRequest investmentRequest) {
        return null;
    }

}
