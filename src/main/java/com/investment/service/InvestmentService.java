package com.investment.service;

import com.investment.entity.InvestmentEntity;
import com.investment.entity.UserEntity;
import com.investment.exception.UserNotFoundException;
import com.investment.mapper.InvestmentMapper;
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
    private final InvestmentMapper investmentMapper;

    public UUID createInvestment(InvestmentRequest investmentRequest) {
        UUID userId = SecurityUtil.getCurrentUserId();

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        InvestmentEntity investmentEntity = investmentMapper.toEntity(investmentRequest, user);

        investmentRepository.save(investmentEntity);
        return UUID.randomUUID();
    }

}
