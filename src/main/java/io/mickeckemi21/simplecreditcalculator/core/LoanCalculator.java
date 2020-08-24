package io.mickeckemi21.simplecreditcalculator.core;

import io.mickeckemi21.simplecreditcalculator.model.Loan;
import io.mickeckemi21.simplecreditcalculator.model.LoanCalculation;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class LoanCalculator {

    /**
     * Calculates Loan Amount with the following formula:
     * <p>
     * <code>loanAmount * i * (1 + i) ^ n / ((1 + i) ^ n - 1)</code>
     *
     */
    public LoanCalculation calculate(Loan loan) {
        final BigDecimal loanAmount = loan.getAmount();
        final Integer n = loan.getNumberOfMonths();
        final BigDecimal i = loan.getAnnualInterestRate()
                .divide(BigDecimal.valueOf(100), 12, RoundingMode.HALF_EVEN)
                .divide(BigDecimal.valueOf(12), 12, RoundingMode.HALF_EVEN);

        final BigDecimal monthlyPayment = loanAmount
                .multiply(
                    i.multiply((i.add(BigDecimal.ONE)).pow(n))
                )
                .divide(
                    BigDecimal.ONE.add(i).pow(n).subtract(BigDecimal.ONE), 12, RoundingMode.HALF_EVEN
                );

        final BigDecimal totalAmount = monthlyPayment.multiply(BigDecimal.valueOf(loan.getNumberOfMonths()));
        final BigDecimal interestAmount = totalAmount.subtract(loan.getAmount());

        return new LoanCalculation(
                monthlyPayment.setScale(2, RoundingMode.HALF_EVEN),
                totalAmount.setScale(2, RoundingMode.HALF_EVEN),
                interestAmount.setScale(2, RoundingMode.HALF_EVEN)
        );
    }

}
