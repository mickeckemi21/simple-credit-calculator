package io.mickeckemi21.simplecreditcalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Integer numberOfMonths;

    @NotNull
    private BigDecimal annualInterestPercent;

}
