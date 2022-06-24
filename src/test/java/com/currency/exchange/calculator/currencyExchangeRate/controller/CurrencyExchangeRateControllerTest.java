package com.currency.exchange.calculator.currencyExchangeRate.controller;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.currency.exchange.calculator.currencyExchangeRate.service.CurrencyCalculatorService;

@WebMvcTest(CurrencyCalculatorController.class)
public class CurrencyExchangeRateControllerTest {
	
    @InjectMocks
    private CurrencyCalculatorController currencyCalculatorController;

    @MockBean
    private CurrencyCalculatorService currencyCalculatorService;

    @Autowired
    private MockMvc mockMvc;
    
    @Mock
    RestTemplate restTemplate;
    

    
    @Test
    public void testGetAllCurrencycode() throws Exception {
    	String currencyValue=null;
		currencyValue = new String(Files.readAllBytes(Paths.get("C:\\Users\\ranja\\workfolder\\CurrencyExchange\\CurrencyExchange\\src\\main\\java\\currencyExchangeValue.txt")));
	
        Mockito.when(currencyCalculatorService.getCurrencyCode()).thenReturn(currencyValue);

        this.mockMvc.perform(get("/api/v1/currencyCode"))
                .andExpect(status().isOk())
                .andReturn();

        Mockito.verify(currencyCalculatorService, Mockito.times(1)).getCurrencyCode();
    }
    
    @Test 
    public void testGetAllCurrencyExchangevalue() throws Exception {
    	
        Mockito.when(currencyCalculatorService.convertedValue(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(10.00);

        this.mockMvc.perform(get("/api/v1/exchangeRate/EUR/USD/100.00"))
                .andExpect(status().isOk())
                .andReturn();

        Mockito.verify(currencyCalculatorService, Mockito.times(1)).convertedValue(Mockito.any(), Mockito.any(), Mockito.any());
    }

}
