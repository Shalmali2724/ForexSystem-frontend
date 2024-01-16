package com.abc.das.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class AppointmentDto
{
	private int appointmentId;
	//@NotNull(message = "appointment Status is required")
private String appointementStatus;
	private LocalDate date;
	private String remark;
	
	private int doctorId;
	private int patientId;

	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
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
   public String getAppointementStatus() {
	return appointementStatus;
     }
	public void setAppointementStatus(String appointementStatus) 
	{		this.appointementStatus = appointementStatus;
}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
