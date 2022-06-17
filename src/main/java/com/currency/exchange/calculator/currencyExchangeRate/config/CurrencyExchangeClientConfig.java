package com.currency.exchange.calculator.currencyExchangeRate.config;

import java.nio.charset.Charset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.currency.exchange.calculator.currencyExchangeRate.ApplicationProperties;

@Configuration
public class CurrencyExchangeClientConfig {
	
	@Autowired
	ApplicationProperties appProps;
	
	
	@Bean(name = "currencyExchangeRestTemplate")
    public RestTemplate restTemplate() {
        RestTemplateConfiguration restTemplateConfiguration = new RestTemplateConfiguration();
	        RestTemplate restTemplate = restTemplateConfiguration.getRestTemplate(appProps.getCurrencyExchangeRestclientConnectTimeout(),
	                appProps.getCurrencyExchangeRestclientReadTimeout());

	        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
	        return restTemplate;
	    }

}
