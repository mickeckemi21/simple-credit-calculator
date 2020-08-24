package io.mickeckemi21.simplecreditcalculator.controller;

import io.mickeckemi21.simplecreditcalculator.dto.LoanCalculationDto;
import io.mickeckemi21.simplecreditcalculator.dto.LoanDto;
import io.mickeckemi21.simplecreditcalculator.service.LoanService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/installment-plan")
public class InstallmentController {

    private final LoanService service;

    public InstallmentController(LoanService service) {
        this.service = service;
    }

    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public LoanCalculationDto createInstallmentPlan(@Valid @RequestBody LoanDto loanDto) {
        final LoanCalculationDto loanCalculationDto = this.service.calculateAndInsert(loanDto);
        loanCalculationDto.generateItemList();
        return loanCalculationDto;
    }

}
