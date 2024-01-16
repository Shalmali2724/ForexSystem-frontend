package com.abc.das.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.dto.PatientDto;
import com.abc.das.entity.Patient;
import com.abc.das.exception.PatientNotFoundException;
import com.abc.das.repository.IPatientRepository;

@Service
public class IPatientServiceImpl implements IPatientService {
	
	@Autowired
	private IPatientRepository iPatientRepository;
	@Override
	public PatientDto addPatient(PatientDto patientdto) {
		
		Patient patient=new Patient();
		patient.setPatientName(patientdto.getPatientName());
		patient.setPatientPhone(patientdto.getPatientPhone());
		patient.setEmail(patientdto.getEmail());
		patient.setPassword(patientdto.getPassword());
		patient.setAge(patientdto.getAge());
		patient.setWeight(patientdto.getWeight());
		patient.setBloodGroup(patientdto.getBloodGroup());
		patient.setGender(patientdto.getGender());
		patient.setAddress(patientdto.getAddress());
		patient.setPatientIssue(patientdto.getPatientIssue());
		
		Patient newPatient = iPatientRepository.save(patient);
		PatientDto newDto = new PatientDto();
		newDto.setPatientId(newPatient.getPatientId());
		newDto.setPatientName(newPatient.getPatientName());
		newDto.setPatientPhone(newPatient.getPatientPhone());
		newDto.setEmail(newPatient.getEmail());
		newDto.setPassword(newPatient.getPassword());
		newDto.setAge(newPatient.getAge());
		newDto.setWeight(newPatient.getWeight());
		newDto.setBloodGroup(newPatient.getBloodGroup());
		newDto.setGender(newPatient.getGender());
		newDto.setAddress(newPatient.getAddress());
		newDto.setPatientIssue(newPatient.getPatientIssue());
		return newDto;
	}
	
	@Override
	public List<Patient> getAllPatient()
	{
		List<Patient> patient = iPatientRepository.findAll();
		return patient;
	}
	
	@Override
	public String deletePatientById(int PatientId) throws PatientNotFoundException{
		
		Optional<Patient> optionalPatient =iPatientRepository.findById(PatientId);
		if(optionalPatient.isEmpty())
		{
			throw new PatientNotFoundException("Patient Not Found with id:"+PatientId);
			
		}
		Patient patient = optionalPatient.get();
		iPatientRepository.delete(patient);
		return "Patient information deleted ";		
	}


	@Override
	public Patient getPatientById(int patientId) throws PatientNotFoundException
	{
		Optional<Patient> optionalPatient =iPatientRepository.findById(patientId);
		if(optionalPatient.isEmpty())
		{
			throw new PatientNotFoundException("Patient Not Found with id:"+patientId);
		}
		
		Patient patient= optionalPatient.get();
		return patient;
	}

	


	
	

}
