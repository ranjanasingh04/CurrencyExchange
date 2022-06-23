package com.currency.exchange.calculator.currencyExchangeRate.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.currency.exchange.calculator.currencyExchangeRate.ApplicationProperties;
import com.currency.exchange.calculator.currencyExchangeRate.service.CurrencyCalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CurrencyCalculatorServiceImpl implements CurrencyCalculatorService{
	
	@Autowired
	ApplicationProperties appProps;
	
	@Autowired
    @Qualifier("currencyExchangeRestTemplate")
    private RestTemplate restTemplate;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public Double convertedValue( String source, String currency, Double value) throws IOException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", appProps.getApiKey());
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);			
		ResponseEntity<String> response = restTemplate.exchange(appProps.getExchangeRate() + source + "&currencies="+ currency, HttpMethod.GET, entity, String.class);
		
		String res = response.getBody();
		mapper = new ObjectMapper();
		
		Map<String, Object> resMap = mapper.readValue(res, Map.class);
		Map<String,Double> mapValue = (Map<String, Double>) resMap.get("quotes");
	
		return value * mapValue.get(mapValue.keySet().iterator().next());
	}

	@Override
	public String getCurrencyCode() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", appProps.getApiKey());
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		String currencyValue=null;
			currencyValue = new String(Files.readAllBytes(Paths.get("C:\\Users\\ranja\\workfolder\\CurrencyExchange\\CurrencyExchange\\src\\main\\java\\currencyExchangeValue.txt")));
		return currencyValue;
	}

}
