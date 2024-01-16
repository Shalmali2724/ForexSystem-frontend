package com.abc.das.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.das.dto.PatientDto;
import com.abc.das.entity.Patient;
import com.abc.das.service.IPatientService;

@CrossOrigin(origins="http://localhost:3003/")
@RestController
public class PatientController {
	@Autowired
	private IPatientService iPatientService;
	
	@GetMapping("/patient/all")
	public List<Patient> fetchAllpatient()
	{
		List<Patient> list= iPatientService.getAllPatient();
		return list;
	}
	
	@GetMapping("/patient/id/{id}")
	public ResponseEntity<Patient> fetchPatientDetails(@PathVariable("id") int patientId)
	{
		Patient patient = iPatientService.getPatientById(patientId);
		ResponseEntity<Patient> responseEntity =new ResponseEntity<>(patient,HttpStatus.OK);
		return responseEntity;
	}
		
	@PostMapping("/patient/save")
	public ResponseEntity<PatientDto> addPatient(@Valid @RequestBody PatientDto patientdto)
	{
		PatientDto newPatientDto = iPatientService.addPatient(patientdto);
		ResponseEntity<PatientDto> responseEntity =new ResponseEntity<>(newPatientDto,HttpStatus.CREATED);
		return responseEntity;
		}
	
	@DeleteMapping("/patient/delete/{id}")
	public ResponseEntity<String> removePatient(@PathVariable("id") int patientId)
	{
		String msg = iPatientService.deletePatientById(patientId);
		ResponseEntity<String> responseEntity =new ResponseEntity<>(msg,HttpStatus.OK);
		return responseEntity;
	}
	
	
}



