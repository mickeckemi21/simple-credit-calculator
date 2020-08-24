package io.mickeckemi21.simplecreditcalculator.service;

import io.mickeckemi21.simplecreditcalculator.adapter.LoanAdapter;
import io.mickeckemi21.simplecreditcalculator.core.LoanCalculator;
import io.mickeckemi21.simplecreditcalculator.dto.LoanCalculationDto;
import io.mickeckemi21.simplecreditcalculator.dto.LoanDto;
import io.mickeckemi21.simplecreditcalculator.model.Loan;
import io.mickeckemi21.simplecreditcalculator.model.LoanCalculation;
import io.mickeckemi21.simplecreditcalculator.repository.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanAdapter adapter;
    private final LoanRepository repository;
    private final LoanCalculator calculator;

    public LoanServiceImpl(LoanAdapter adapter, LoanRepository repository, LoanCalculator calculator) {
        this.adapter = adapter;
        this.repository = repository;
        this.calculator = calculator;
    }

    @Override
    public LoanCalculationDto calculateAndInsert(LoanDto loanDto) {
        final Loan loan = this.adapter.loanDtoToLoan(loanDto);

        final LoanCalculation loanCalculation = calculateLoan(loan);
        // bind embeddable component and save to DB
        loan.setLoanCalculation(loanCalculation);
        saveLoan(loan);

        return this.adapter.loanToLoanCalculationDto(loan);
    }

    private void saveLoan(Loan loan) {
        this.repository.save(loan);
    }

    private LoanCalculation calculateLoan(Loan loan) {
        return this.calculator.calculate(loan);
    }

}
