package com.abc.das.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class AvailabilityDto {
	private int doctorId;
	private int availabilityId;
	private LocalDate fromDate;
    private LocalDate toDate;
    
    private String status;
    
    
//    private DoctorDto doctorDto;
    
    
	
//	public DoctorDto getDoctorDto() {
//		return doctorDto;
//	}
//	public void setDoctorDto(DoctorDto doctorDto) {
//		this.doctorDto = doctorDto;
//	}
	public int getAvailabilityId() {
		return availabilityId;
	}
	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
    

}
