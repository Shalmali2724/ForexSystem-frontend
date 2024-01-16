package com.abc.das.exception;

public class PatientReportNotFoundException extends RuntimeException {
	public PatientReportNotFoundException(String msg)
	{
		super(msg);
	}

}
