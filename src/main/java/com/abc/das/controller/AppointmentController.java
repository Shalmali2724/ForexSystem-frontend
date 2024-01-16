package com.abc.das.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.abc.das.dto.AppointmentDto;
import com.abc.das.entity.Appointment;
import com.abc.das.service.IAppointmentService;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class AppointmentController {
	@Autowired
	private IAppointmentService apptService;

	@GetMapping("/appointement/getall")
	public List<Appointment> fetchAllAppointment() 
	{
		List<Appointment> appointment = apptService.getAllAppointments();

		return appointment;
	}

	@PostMapping("/Bookappointment/save")//done
	public ResponseEntity<AppointmentDto> saveAppointment(@RequestBody AppointmentDto appointmentDto) {
		AppointmentDto newAppointmentDto = apptService.saveAppointment(appointmentDto);
		ResponseEntity<AppointmentDto> responseEntity = new ResponseEntity<>(newAppointmentDto, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/appointment/getByPatientid/{PatientId}")
	public ResponseEntity<List<Appointment>> fetchAppointmentById(@PathVariable("PatientId") int patientId) {

		List<Appointment> appointment = apptService.getAppointmentsByPatientId(patientId);
		ResponseEntity<List<Appointment>> responseEntity = new ResponseEntity<>(appointment, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/appointment/getByDoctorId/{doctorId}")
	public ResponseEntity<List<Appointment>> fetchAppointmentByDoctorId(@PathVariable("doctorId") int doctorId)
	{
		List<Appointment> appointment = apptService.getAppointmentsByDoctorId(doctorId);
		ResponseEntity<List<Appointment>> responseEntity = new ResponseEntity<>(appointment, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/appointement/deleteByAppointmentId/{id}")
	public ResponseEntity<String> CancelAppointment(@PathVariable("id") int appointmentId) {

		String response=apptService.deleteAppointmentById(appointmentId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(response,HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/appointment/getByAppointment/{id}")
	public ResponseEntity<Appointment>getAppointmentByAppointmentId(@PathVariable("id") int appointmentId)
	{
		Appointment appointment = apptService.getAppointmentById(appointmentId);
		ResponseEntity<Appointment> responseEntity = new ResponseEntity<>(appointment, HttpStatus.OK);
		return responseEntity;
	}


	

}
