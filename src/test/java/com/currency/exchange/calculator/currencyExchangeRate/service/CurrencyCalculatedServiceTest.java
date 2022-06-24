package com.currency.exchange.calculator.currencyExchangeRate.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.currency.exchange.calculator.currencyExchangeRate.model.CurrencyEnum;

@WebMvcTest
public class CurrencyCalculatedServiceTest {
	
	@MockBean
	CurrencyCalculatorService currencyCalculatorService;
	Map<String, Double> rates = null;

    @BeforeEach
    public void setup() {
        rates = new HashMap();
        rates.put(CurrencyEnum.EUR.name(), 0.656703);
        rates.put(CurrencyEnum.USD.name(), 0.167623);
        rates.put(CurrencyEnum.INR.name(), 0.789800);
       
    }

    @Test
    public void shouldExchangeValueEurToInr() throws IOException {
        assertEquals(0.0, currencyCalculatorService.convertedValue(CurrencyEnum.EUR.name(), CurrencyEnum.INR.name(), 100.00));
    }

 }
