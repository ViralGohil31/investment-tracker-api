package com.investment.controller;

import com.investment.model.request.InvestmentRequest;
import com.investment.service.InvestmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static com.investment.constant.InvestmentTrackerConstants.REQUEST_ID_HEADER;
import static com.investment.constant.InvestmentTrackerConstants.RECEIVED_REQUEST;
import static com.investment.constant.InvestmentTrackerConstants.COMPLETED_REQUEST;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    @PostMapping
    public ResponseEntity<UUID> createInvestment(
            @RequestHeader(REQUEST_ID_HEADER) UUID requestId,
            @RequestBody InvestmentRequest investmentRequest) {
        log.info(RECEIVED_REQUEST, requestId, "createInvestment");
        UUID investmentId = investmentService.createInvestment(investmentRequest);
        log.info(COMPLETED_REQUEST, requestId, "createInvestment");
        return new ResponseEntity<>(investmentId, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<InvestmentRequest>> getAllInvestments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return null;
    }


}
