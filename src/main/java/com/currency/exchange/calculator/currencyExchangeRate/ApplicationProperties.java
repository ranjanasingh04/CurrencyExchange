package com.currency.exchange.calculator.currencyExchangeRate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ApplicationProperties {
	
	@Value("${api.key}")
	private String apiKey;
	
	@Value("${api.url}")
	private String apiUrl;
	
	@Value("${api.url.exchange.rate}")
	private String exchangeRate;
	
	@Value("${currency.exchange.rest.client.connect.timeout:2000}")
	private Integer currencyExchangeRestclientConnectTimeout;

	@Value("${currency.exchange.rest.client.read.timeout:8000}")
	private Integer currencyExchangeRestclientReadTimeout;

}
