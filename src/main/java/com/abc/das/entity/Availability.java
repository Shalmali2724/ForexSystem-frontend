package com.abc.das.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.abc.das.dto.DoctorDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Availability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int availabilityId;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String status;

//    private int doctorId;
//	public int getDoctorId() {
//		return doctorId;
//	}
//	public void setDoctorId(int doctorId) {
//		this.doctorId = doctorId;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToOne
//	@JsonIgnore
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctorId) {
		this.doctor = doctorId;
	}

	public int getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
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

}
