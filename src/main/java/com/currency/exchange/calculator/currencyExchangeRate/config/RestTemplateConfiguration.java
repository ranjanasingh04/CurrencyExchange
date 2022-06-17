package com.currency.exchange.calculator.currencyExchangeRate.config;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConfiguration {
	
	  public RestTemplate getRestTemplate(Integer connectTimeout, Integer readTimeout) {
	        RestTemplate restTemplate = new RestTemplate();
	        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
	        factory.setConnectTimeout(connectTimeout);
	        factory.setReadTimeout(readTimeout);
	        restTemplate.setRequestFactory(factory);
	        return restTemplate;
	    }

}
