package com.currency.exchange.calculator.currencyExchangeRate.controller;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.currency.exchange.calculator.currencyExchangeRate.service.CurrencyCalculatorService;

@WebMvcTest(CurrencyCalculatorController.class)
public class CurrencyExchangeRateControllerTest {
	
    @InjectMocks
    private CurrencyCalculatorController currencyCalculatorController;

    @MockBean
    private CurrencyCalculatorService currencyCalculatorService;

    private MockMvc mockMvc;

    
    @Test // 
    public void testGetAllCurrencycode() throws Exception {
        Mockito.when(currencyCalculatorService.getCurrencyCode());

        this.mockMvc.perform(get("/api/v1/currencyCode"))
                .andExpect(status().isOk())
                .andReturn();

        Mockito.verify(currencyCalculatorService, Mockito.times(1)).getCurrencyCode();
    }
    
    @Test // Get all actions controller
    public void testGetAllCurrencyExchangevalue() throws Exception {
        Mockito.when(currencyCalculatorService.convertedValue(Mockito.any(), Mockito.any(), Mockito.any()));

        this.mockMvc.perform(get("/api/v1/exchangeRate"))
                .andExpect(status().isOk())
                .andReturn();

        Mockito.verify(currencyCalculatorService, Mockito.times(1)).convertedValue(Mockito.any(), Mockito.any(), Mockito.any());
    }

}
