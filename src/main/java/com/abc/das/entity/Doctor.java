package com.abc.das.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int doctorId;

	private String doctorName;

	private String doctorPhone;

	private String specialization;

	private String location;

	private int chargespervisit;

	private String email;

	private String password;
	@OneToMany(mappedBy = "doctor")
	private List<Appointment> appointments;
	@OneToOne(mappedBy = "doctor")
	private Availability availability;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getChargespervisit() {
		return chargespervisit;
	}

	public void setChargespervisit(int chargespervisit) {
		this.chargespervisit = chargespervisit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@JsonIgnore
	public List<Appointment> getAppointments() {
		return appointments;
	}
	@JsonIgnore
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	@JsonIgnore
	public Availability getAvailability() {
		return availability;
	}
	@JsonIgnore
	public void setAvailability(Availability availability) {
		this.availability = availability;
	}

}
