package com.currency.exchange.calculator.currencyExchangeRate.exception;

public class ServiceException  extends RuntimeException {
	ServiceException() {super();}
	public ServiceException(String message) {
		super(message);
	}
	public ServiceException(Throwable cause) {
		super(cause);
	}
	public ServiceException(String message, Throwable cause) {
		super(message,cause);
	}
	

}
