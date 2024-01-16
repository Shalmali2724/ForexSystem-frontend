package com.abc.das.exception;

public class AppointmentNotFoundException extends RuntimeException
{
	public  AppointmentNotFoundException(String msg)
	{
		super(msg);
	}
}
