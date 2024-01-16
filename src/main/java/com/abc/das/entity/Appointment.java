package com.abc.das.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

//m-1 relation to patient
//m-1 relation todoctor
//1-1 relation to payemt
@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int appointmentId;
	 @Column(columnDefinition = "varchar(255) default 'Available'")
	private String appointementStatus;
	private LocalDate date;
	private String remark;
	
	@ManyToOne()
	@JoinColumn(name = "patient_id")
	//@JsonIgnore
	private Patient patient;
	
	@ManyToOne()
	@JoinColumn(name = "doctor_id")
	//@JsonIgnore
	private Doctor doctor;
	
	

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointementStatus() {
		return appointementStatus;
	}

	public void setAppointementStatus(String appointementStatus) {
		this.appointementStatus = appointementStatus;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	
	
	
	
}
