package com.abc.das.exception;

public class DoctorNameNotExistingException extends RuntimeException {
	public DoctorNameNotExistingException(String msg)
	{
		super(msg);
	}

}
