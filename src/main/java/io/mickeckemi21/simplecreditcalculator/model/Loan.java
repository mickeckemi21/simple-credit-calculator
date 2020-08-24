package io.mickeckemi21.simplecreditcalculator.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotNull
    @Column(nullable = false)
    protected BigDecimal amount;

    @NotNull
    @Column(nullable = false)
    protected Integer numberOfMonths;

    @NotNull
    @Column(nullable = false)
    protected BigDecimal annualInterestRate;

    protected LoanCalculation loanCalculation;

}
