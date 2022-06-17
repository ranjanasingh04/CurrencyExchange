package com.currency.exchange.calculator.currencyExchangeRate.controller;


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
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currency.exchange.calculator.currencyExchangeRate.ApplicationProperties;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@RestController
@RequestMapping("/cal")
public class CurrencyCalculatorController {
	public final String ERRORMSG = "something went wrong. Please check stacktrace";  
	
	@Autowired
	ApplicationProperties appProps;
	
	@Autowired
    @Qualifier("currencyExchangeRestTemplate")
    private RestTemplate restTemplate;
	
	@GetMapping("/getPrice")
	public long getPrice() {
		
		return 1l;
	}
	
	@GetMapping("/getCurrencyCode")
	public String getCurrencyCode() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", appProps.getApiKey());
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		String currencyValue=null;
			currencyValue = new String(Files.readAllBytes(Paths.get("C:\\Users\\ranja\\workfolder\\CurrencyExchange\\CurrencyExchange\\src\\main\\java\\currencyExchangeValue.txt")));
		
		//ResponseEntity<String> response = restTemplate.exchange(appProps.getApiUrl(), HttpMethod.GET, entity, String.class);
		return currencyValue;
		
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getExchangeRate/{source}/{currency}")
	public Double getExchangeRate(@PathVariable String source, @PathVariable String currency) throws JsonMappingException, JacksonException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", appProps.getApiKey());
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);			
		ResponseEntity<String> response = restTemplate.exchange(appProps.getExchangeRate() + source + "&currencies="+ currency, HttpMethod.GET, entity, String.class);
		
		String res = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		
		Map<String, Object> resMap = mapper.readValue(res, Map.class);
		Map<String,Double> mapValue = (Map<String, Double>) resMap.get("quotes");
	
		return mapValue.get(mapValue.keySet().iterator().next());
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public String currencyExchangeExceptionHandler() {
		return ERRORMSG;
		
	}
	

}
