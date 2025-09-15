package com.investment.controller;

import com.investment.model.Investment;
import com.investment.service.InvestmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    @PostMapping
    public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment) {
        Investment invested = investmentService.createInvestment(investment);
        return new ResponseEntity<>(invested, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Investment>> getAllInvestments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return null;
    }


}
