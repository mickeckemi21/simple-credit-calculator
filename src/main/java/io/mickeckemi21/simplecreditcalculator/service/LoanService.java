package io.mickeckemi21.simplecreditcalculator.service;

import io.mickeckemi21.simplecreditcalculator.dto.LoanCalculationDto;
import io.mickeckemi21.simplecreditcalculator.dto.LoanDto;

public interface LoanService {

    LoanCalculationDto calculateAndInsert(LoanDto loanDto);

}
