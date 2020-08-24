package io.mickeckemi21.simplecreditcalculator.adapter;

import io.mickeckemi21.simplecreditcalculator.dto.LoanCalculationDto;
import io.mickeckemi21.simplecreditcalculator.dto.LoanDto;
import io.mickeckemi21.simplecreditcalculator.model.Loan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LoanAdapter {

    @Mapping(target = "annualInterestRate", source = "annualInterestPercent")
    Loan loanDtoToLoan(LoanDto loanDto);

    @Mapping(target = "interestAmount", source = "loan.loanCalculation.interestAmount")
    @Mapping(target = "totalAmount", source = "loan.loanCalculation.totalAmount")
    @Mapping(target = "paymentAmount", source = "loan.loanCalculation.monthlyPayment")
    @Mapping(target = "numberOfMonths", source = "loan.numberOfMonths")
    LoanCalculationDto loanToLoanCalculationDto(Loan loan);

}
