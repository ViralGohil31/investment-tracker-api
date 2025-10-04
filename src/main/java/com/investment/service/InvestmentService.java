package com.investment.service;

import com.investment.model.request.InvestmentRequest;
import com.investment.repository.InvestmentRepository;
import com.investment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final UserRepository userRepository;

    public UUID createInvestment(InvestmentRequest investmentRequest) {
        return null;
    }

}
