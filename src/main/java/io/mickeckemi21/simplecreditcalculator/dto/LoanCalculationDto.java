package io.mickeckemi21.simplecreditcalculator.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanCalculationDto {

    @NotNull
    private BigDecimal amount;

    @NotNull
    private BigDecimal totalAmount;

    @NotNull
    private BigDecimal interestAmount;

    @NotNull
    @JsonIgnore
    private BigDecimal paymentAmount;

    @NotNull
    @JsonIgnore
    private Integer numberOfMonths;

    private List<LoanItem> items = new ArrayList<>();

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoanItem {

        @NotNull
        private Integer month;

        @NotNull
        private BigDecimal paymentAmount;

    }

    public void generateItemList() {
        this.items = new ArrayList<>(this.numberOfMonths);
        for (int i = 1; i <= this.numberOfMonths; i++) {
            final LoanItem loanItem = new LoanItem(i, this.paymentAmount);
            this.items.add(loanItem);
        }
    }

}
