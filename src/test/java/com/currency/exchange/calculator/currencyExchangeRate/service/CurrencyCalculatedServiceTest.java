package com.currency.exchange.calculator.currencyExchangeRate.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.currency.exchange.calculator.currencyExchangeRate.model.CurrencyEnum;

@WebMvcTest
public class CurrencyCalculatedServiceTest {
	
	CurrencyCalculatorService currencyCalculatorService;
	Map<String, Double> rates = null;

    @BeforeEach
    public void setup() {
        rates = new HashMap();
        rates.put(CurrencyEnum.EUR.name(), 0.656703);
        rates.put(CurrencyEnum.USD.name(), 0.867623);
        rates.put(CurrencyEnum.INR.name(), 0.789800);
       
    }

    @Test
    public void shouldExchangeValueEurToInr() throws IOException {
        assertEquals(90.42, currencyCalculatorService.convertedValue(CurrencyEnum.EUR.name(), CurrencyEnum.INR.name(), 100.00));
    }

 }
