package com.abc.das.service;

import java.util.List;

import com.abc.das.dto.PatientDto;
import com.abc.das.entity.Patient;

public interface IPatientService {
	
	public PatientDto addPatient(PatientDto patientdto);
	public List<Patient> getAllPatient();
	public String deletePatientById(int patientId);
	public Patient getPatientById(int patientId);
	
}
