package io.mickeckemi21.simplecreditcalculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.mickeckemi21.simplecreditcalculator.SimpleCreditCalculatorApplication;
import io.mickeckemi21.simplecreditcalculator.dto.LoanDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = SimpleCreditCalculatorApplication.class)
class InstallmentControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    private final LoanDto testLoanDto = new LoanDto(BigDecimal.valueOf(1000.00d), 10, BigDecimal.valueOf(5.00d));

    @Test
    void givenAmountAndNumberOfMonthsAndAnnualInterestPercent_whenPost_thenExpectStatusOk() throws Exception {
        // given

        this.mockMvc.perform(
                // when
                post("/installment-plan")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsBytes(this.testLoanDto)))
                // then
                .andExpect(status().isOk());
    }

    @Test
    void givenAmountAndNumberOfMonthsAndAnnualInterestPercent_whenPost_thenResponseBodyContainsAmountAndEqualTo1000_00() throws Exception {
        // given

        this.mockMvc.perform(
                // when
                post("/installment-plan")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsBytes(this.testLoanDto)))
                // then
                .andExpect(
                        jsonPath("$.amount", is(notNullValue())))
                .andExpect(
                        jsonPath("$.amount", equalTo(1000.00d)));
    }

    @Test
    void givenAmountAndNumberOfMonthsAndAnnualInterestPercent_whenPost_thenResponseBodyContainsTotalAmountEqualsTo1023_06() throws Exception {
        // given

        this.mockMvc.perform(
                // when
                post("/installment-plan")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsBytes(this.testLoanDto)))
                // then
                .andExpect(
                        jsonPath("$.totalAmount", is(notNullValue())))
                .andExpect(
                        jsonPath("$.totalAmount", equalTo(1023.06d)));
    }

    @Test
    void givenAmountAndNumberOfMonthsAndAnnualInterestPercent_whenPost_thenResponseBodyContainsInterestAmountEqualsTo123_06() throws Exception {
        // given

        this.mockMvc.perform(
                // when
                post("/installment-plan")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsBytes(this.testLoanDto)))
                // then
                .andExpect(
                        jsonPath("$.interestAmount", is(notNullValue())))
                .andExpect(
                        jsonPath("$.interestAmount", equalTo(23.06d)));
    }

    @Test
    void givenAmountAndNumberOfMonthsAndAnnualInterestPercent_whenPost_thenResponseBodyContainsItemsAndItemsLengthEqualsTo10AndAllItemsPaymentAmountEqualsTo102_31() throws Exception {
        // given

        this.mockMvc.perform(
                // when
                post("/installment-plan")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.mapper.writeValueAsBytes(this.testLoanDto)))
                // then
                .andExpect(
                        jsonPath("$.items", is(notNullValue())))
                .andExpect(
                        jsonPath("$.items.length()", equalTo(10)))
                .andExpect(
                        jsonPath("$.items[?(@.paymentAmount == '102.31')]", hasSize(10)));
    }

}