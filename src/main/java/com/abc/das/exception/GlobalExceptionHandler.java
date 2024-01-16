package com.abc.das.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DoctorNotFoundException.class)
	public ResponseEntity<String> handleDoctorNotFoundException(Exception e){
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
		
	}
	@ExceptionHandler(DoctorNameNotExistingException.class)public ResponseEntity<String> handleDoctorNameNotException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(DoctorAuthenticationFailureException.class)
	public ResponseEntity<String> handleDoctorAuthenticationFailureException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	
	 
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<String> handlePatientNotFoundException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(PatientEmailNotExitingException.class)
	public ResponseEntity<String> handlePatientEmailNotExitingException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	@ExceptionHandler(PatientAuthenticationFailureException.class)
	public ResponseEntity<String> handlePatientAuthenticationFailureException(Exception e) {
		ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	
	 @ExceptionHandler(AppointmentNotFoundException.class)
	    public ResponseEntity<String> handleAppointmentNotFoundException(Exception e){
	        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	        return responseEntity;
	 }
		
		 
		 @ExceptionHandler(AvailabilityNotFoundException.class)
		    public ResponseEntity<String> handleAvaialabilityNotFoundException(Exception e){
		        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		        return responseEntity;

		    }

		 @ExceptionHandler(FeedBackNotFoundException.class)
		    public ResponseEntity<String> handleFeedBackNotFoundException(Exception e){
		        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		        return responseEntity;

		    }
		 
		 
	

		 @ExceptionHandler(PatientReportNotFoundException.class)
		 public ResponseEntity<String> handlePatientReportNotFoundException(Exception e){
			 ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			 return responseEntity;
		 
		 }


}
