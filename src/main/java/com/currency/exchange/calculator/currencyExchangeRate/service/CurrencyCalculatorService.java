package com.currency.exchange.calculator.currencyExchangeRate.service;

import java.io.IOException;

public interface CurrencyCalculatorService {
	
	public Double convertedValue(String fromCur, String toCur, Double value) throws IOException ;
	public String getCurrencyCode() throws IOException ;

}
