package com.abc.das.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.entity.Doctor;

import com.abc.das.exception.DoctorAuthenticationFailureException;
import com.abc.das.exception.DoctorNameNotExistingException;
import com.abc.das.repository.IDoctorRepository;
@Service
public class DoctorAuthenticationServiceImpl implements DoctorAuthenticationService {
	@Autowired
	private IDoctorRepository iDoctorRepository;
	@Override
	public Doctor login(String email, String password) {
		// TODO Auto-generated method stub
		Optional<Doctor> optionalDoctor =iDoctorRepository.findByemail(email);
		
		if(optionalDoctor.isEmpty())
		{
			throw new DoctorNameNotExistingException("Doctor not registered");
		}
		Doctor doctor = optionalDoctor.get();
		if(!password.equals(doctor.getPassword()))
		{
			throw new DoctorAuthenticationFailureException("Login Failed");
		}
		return doctor;
	}

}
