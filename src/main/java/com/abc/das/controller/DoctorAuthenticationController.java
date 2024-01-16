package com.abc.das.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.das.dto.DoctorLoginReq;
import com.abc.das.entity.Doctor;
import com.abc.das.service.DoctorAuthenticationService;
@CrossOrigin(origins ="http://localhost:3000/")
@RestController
@RequestMapping("/auth")
public class DoctorAuthenticationController {
	@Autowired
	private DoctorAuthenticationService doctorauthenticationservice;
	
	@PostMapping("/login")
	public ResponseEntity<Doctor> doLogin(@RequestBody DoctorLoginReq loginReq){
		Doctor doctor = doctorauthenticationservice.login(loginReq.getEmail(),loginReq.getPassword());
		ResponseEntity<Doctor> responseEntity = new ResponseEntity<>(doctor,HttpStatus.OK);
		return responseEntity;

	}
}
