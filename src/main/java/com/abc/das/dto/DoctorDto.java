package com.abc.das.dto;

import javax.validation.constraints.NotNull;

import com.abc.das.entity.Doctor;

public class DoctorDto {
	
	@NotNull(message = "DoctorId is required")
	private int doctorId;
	@NotNull(message = "DoctorName is required")
	private String doctorName;
	@NotNull(message = "Phone No is required")
	private String doctorPhone;
	@NotNull(message = "Specialization is required")
	private String specialization;
	@NotNull(message = "Location is required")
	private String location;
	@NotNull(message = "Chargespervisit is required")
	private int chargespervisit;
	@NotNull(message = "Email  is required")
	private String email;
	@NotNull(message = "Password is required")
	private String password;


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

}
