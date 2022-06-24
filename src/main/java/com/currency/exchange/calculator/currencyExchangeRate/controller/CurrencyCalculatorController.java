package com.currency.exchange.calculator.currencyExchangeRate.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.currency.exchange.calculator.currencyExchangeRate.service.CurrencyCalculatorService;

@CrossOrigin
@Component
@RestController
@RequestMapping("/api/v1")
public class CurrencyCalculatorController {
	
	public final String ERRORMSG = "something went wrong. Please check stacktrace";  
		
	
	@Autowired
	CurrencyCalculatorService service;
	
	@GetMapping("/currencyCode")
	public String getCurrencyCode() throws IOException {
		return service.getCurrencyCode();
		
	}
	
	@GetMapping("/exchangeRate/{source}/{currency}/{value}")
	public Double getExchangeRate(@PathVariable String source, @PathVariable String currency, @PathVariable Double value) throws IOException {
		return service.convertedValue(source,currency,value);
	}
	
	@ExceptionHandler(Exception.class)
	public String currencyExchangeExceptionHandler() {
		return ERRORMSG;
		
	}
	

}
