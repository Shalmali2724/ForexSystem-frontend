package com.abc.das.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.das.dto.PatientReportDto;
import com.abc.das.entity.PatientReport;
import com.abc.das.service.IPatientReportService;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class PatientReportController {
	@Autowired
	private IPatientReportService ipatientreportservice;

	@GetMapping("/ipatientreport/{id}")
	public ResponseEntity<PatientReport> fetchPatientReportById(@PathVariable("id") int PatientId) {
		// ResponseEntity<Trainee> responseEntity = null;
		PatientReport patientreport = ipatientreportservice.getPatientReportById(PatientId);
		ResponseEntity<PatientReport> responseEntity = new ResponseEntity<>(patientreport, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/ipatientreport/save")
	public ResponseEntity<PatientReportDto> allFeedback(@RequestBody PatientReportDto patientReportDto) {
		PatientReportDto newpatientReportDto = ipatientreportservice.addPatientReportDto(patientReportDto);
		ResponseEntity<PatientReportDto> responseEntity = new ResponseEntity<>(newpatientReportDto, HttpStatus.CREATED);
		return responseEntity;
	}

}
