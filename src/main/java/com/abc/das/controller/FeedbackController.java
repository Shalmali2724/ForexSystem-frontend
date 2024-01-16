package com.abc.das.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.das.dto.FeedbackDto;

import com.abc.das.entity.Feedback;
import com.abc.das.service.IFeedbackService;
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class FeedbackController {
	@Autowired
	private IFeedbackService ifeedbackservice;

	@PostMapping("/feedback/save")
	public ResponseEntity<FeedbackDto> allFeedback(@Valid @RequestBody FeedbackDto feedbackDto) {
		FeedbackDto newFeedbackDto = ifeedbackservice.addFeedback(feedbackDto);
		ResponseEntity<FeedbackDto> responseEntity = new ResponseEntity<>(newFeedbackDto, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/feedback/all")

	public ResponseEntity<List<Feedback>> fetchAllfeedback() {
		List<Feedback> feedback = ifeedbackservice.getAllFeedbacks();
		ResponseEntity<List<Feedback>> list = new ResponseEntity<>(feedback, HttpStatus.OK);

		return list;
	}

	@GetMapping("/feedback/{doctorId}")
	public ResponseEntity<List<Feedback>> fetchFeedbackDoctorById(@PathVariable("doctorId") int doctorId) {

		List<Feedback> feedback = ifeedbackservice.getFeedbackById(doctorId);
		ResponseEntity<List<Feedback>> responseEntity = new ResponseEntity<>(feedback, HttpStatus.OK);
		return responseEntity;
	}

}
