package com.abc.das.service;

import com.abc.das.entity.Doctor;

public interface DoctorAuthenticationService {
	public Doctor login(String email,String password );

}
