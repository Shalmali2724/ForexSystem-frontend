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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.das.dto.AvailabilityDto;
import com.abc.das.dto.DoctorDto;
import com.abc.das.dto.PatientReportDto;
import com.abc.das.entity.Doctor;
import com.abc.das.entity.Patient;
import com.abc.das.service.IDoctorService;
import com.abc.das.service.IPatientReportService;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
public class DoctorController {

	@Autowired
	private IDoctorService idoctorService;
	
	@Autowired
	private IPatientReportService iPatientReportService;
	@GetMapping("/doctor/all")
	public List<Doctor> fetchAllDoctors() {
		List<Doctor> list = idoctorService.getAllDoctor();
		return list;
	}


	@PostMapping("/doctor/save")
	public ResponseEntity<DoctorDto> addDoctor(@Valid @RequestBody DoctorDto doctorDto) {
		DoctorDto newDoctor = idoctorService.saveDoctor(doctorDto);
		ResponseEntity<DoctorDto> responseEntity = new ResponseEntity<>(newDoctor, HttpStatus.CREATED);
		return responseEntity;
	}

	@PutMapping("/doctor/update")
	public ResponseEntity<Doctor> modifyDoctor(@RequestBody Doctor doctor) {
		Doctor updatedDoctor = idoctorService.updateDoctor(doctor);
		ResponseEntity<Doctor> responseEntity = new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
		return responseEntity;

	}

	@DeleteMapping("/doctor/{id}")
	public ResponseEntity<String> removeDoctor(@PathVariable("id") int doctorId) {

		idoctorService.deleteDoctor(doctorId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Doctor deleted successfully.", HttpStatus.OK);
		return responseEntity;

	}

	@GetMapping("/doctor/{id}")
	public ResponseEntity<Doctor> fetchDoctorDetails(@PathVariable("id") int doctorId) {
		Doctor doctor = idoctorService.getDoctorById(doctorId);
		ResponseEntity<Doctor> responseEntity = new ResponseEntity<>(doctor, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/doctor/availability/save")

	public ResponseEntity<AvailabilityDto> addAvailability(@RequestBody AvailabilityDto availabilityDto) {
		AvailabilityDto newAvailability = idoctorService.addAvailabilityByDoctorId(availabilityDto);
		ResponseEntity<AvailabilityDto> responseEntity = new ResponseEntity<>(newAvailability, HttpStatus.CREATED);
		return responseEntity;

	}
	@PostMapping("doctor/ipatientreport/save")
	public ResponseEntity<PatientReportDto> allFeedback(@RequestBody PatientReportDto patientReportDto) {
		PatientReportDto newpatientReportDto = iPatientReportService.addPatientReportDto(patientReportDto);
		ResponseEntity<PatientReportDto> responseEntity = new ResponseEntity<>(newpatientReportDto, HttpStatus.CREATED);
		return responseEntity;
	}
}
