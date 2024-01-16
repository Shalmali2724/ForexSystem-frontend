package com.abc.das.dto;

public class FeedbackDto {
	private int feedbackId; // pk
	private String comments;
	private int rating;
	private int doctorId;
	private int patientId;
	private int appointmentId;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	//private PatientDto patientDto;
	//private AppointmentDto appointmentDto;
	/*
	public AppointmentDto getAppointmentDto() {
		return appointmentDto;
	}
	public void setAppointmentDto(AppointmentDto appointmentDto) {
		this.appointmentDto = appointmentDto;
	}
	*/
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	/*
	public PatientDto getPatientDto() {
		return patientDto;
	}
	public void setPatientDto(PatientDto patientDto) {
		this.patientDto = patientDto;
	}
	*/
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	
	

}
