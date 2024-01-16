package com.abc.das.exception;

public class PaymentNotFoundException extends RuntimeException {
	
	public PaymentNotFoundException(String msg)
	{
		super(msg);
	}

}
