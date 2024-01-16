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
import com.abc.das.entity.Appointment;
import com.abc.das.entity.Availability;
import com.abc.das.entity.Doctor;
import com.abc.das.entity.Feedback;
import com.abc.das.service.IAvailabilityService;
@CrossOrigin(origins ="http://localhost:3000/")
@RestController
public class AvailabilityController {
	@Autowired
	private IAvailabilityService availabilityService;
	
	@PostMapping("/availability/add")
	public ResponseEntity<AvailabilityDto> addAvailability(@RequestBody AvailabilityDto avlDto){
		AvailabilityDto newAvl = availabilityService.addAvailability(avlDto);
		ResponseEntity<AvailabilityDto> responseEntity = new ResponseEntity<> (newAvl, HttpStatus.CREATED);
		return responseEntity;

	}
	@PutMapping("/availability/update")
	public ResponseEntity<Availability> modifyAvailability(@RequestBody Availability availability){
		Availability updatedAvailability = availabilityService.updateAvailability(availability);
		ResponseEntity<Availability> responseEntity = new ResponseEntity<>(updatedAvailability,HttpStatus.OK);
		return responseEntity;	
	}
	@DeleteMapping("/availability/delete/{id}")
	public ResponseEntity<String> removeAvailability(@PathVariable("id") int availabilityId){
		availabilityService.removeAvailability(availabilityId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Availability removed Successfully.",HttpStatus.OK);
		return responseEntity;
		
	}
	@GetMapping("/availability/all")
	public List<Availability> fetchAllAvailabilities(){
		List<Availability> list= availabilityService.getAllAvailabilities();
		return list;
	}
	@GetMapping("/availability/getByDoctorId/{doctorId}")
	public ResponseEntity<List<Availability>> fetchAvailabilityByDoctorId(@PathVariable("doctorId") int doctorId)
	{
		List<Availability> availability = availabilityService.getAvailabilityByDoctorId(doctorId);
		ResponseEntity<List<Availability>> responseEntity = new ResponseEntity<>(availability, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/availability/getById/{Id}")
	public ResponseEntity<Availability> getAvailabilityByAvailabilityId(@PathVariable("Id") int id)
	{
		Availability availability = availabilityService.getAvailabilityById(id);
		ResponseEntity<Availability> responseEntity = new ResponseEntity<>(availability, HttpStatus.OK);
		return responseEntity;
	}
	
	
}
