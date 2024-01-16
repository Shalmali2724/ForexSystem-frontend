package com.abc.das.service;

import com.abc.das.entity.Patient;

public interface PatientAuthenticationService {
	
	public Patient login(String email,String password);

}
