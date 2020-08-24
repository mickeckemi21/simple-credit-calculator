package io.mickeckemi21.simplecreditcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanCalculation {

    @NotNull
    @Column(nullable = false)
    protected BigDecimal monthlyPayment;

    @NotNull
    @Column(nullable = false)
    protected BigDecimal totalAmount;

    @NotNull
    @Column(nullable = false)
    protected BigDecimal interestAmount;

}
