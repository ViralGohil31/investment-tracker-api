package com.investment.service;

import com.investment.entity.UserEntity;
import com.investment.exception.UserNotFoundException;
import com.investment.model.request.InvestmentRequest;
import com.investment.repository.InvestmentRepository;
import com.investment.repository.UserRepository;
import com.investment.util.SecurityUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final UserRepository userRepository;

    public UUID createInvestment(InvestmentRequest investmentRequest) {
        String userId = SecurityUtil.getCurrentUserId();

        UserEntity user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new UserNotFoundException("User not found"));



        return null;
    }

}
