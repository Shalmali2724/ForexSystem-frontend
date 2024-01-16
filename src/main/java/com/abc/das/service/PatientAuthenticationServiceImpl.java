package com.abc.das.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.entity.Patient;
import com.abc.das.exception.PatientEmailNotExitingException;
import com.abc.das.exception.PatientAuthenticationFailureException;
import com.abc.das.repository.IPatientRepository;
@Service
public class PatientAuthenticationServiceImpl implements PatientAuthenticationService {
	
	@Autowired
	private IPatientRepository iPatientRepository;
	
	@Override
	public Patient login(String email, String password) {
		
		Optional<Patient> optionalPatient = iPatientRepository.findByemail(email);
		
		if(optionalPatient.isEmpty())
		{
			throw new PatientEmailNotExitingException("Patient not registered.");
		}
		Patient patient= optionalPatient.get();
		if(!password.equals(patient.getPassword()))
		{
			throw new PatientAuthenticationFailureException("Login in failed");
		}
		return patient;
	}

}
