package com.investment.service;

import com.investment.model.Investment;
import org.springframework.stereotype.Service;

@Service
public class InvestmentService {
    public Investment createInvestment(Investment investment) {
        return investment;
    }

}
