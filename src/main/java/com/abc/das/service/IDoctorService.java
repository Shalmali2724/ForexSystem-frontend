package com.abc.das.service;

import java.util.List;

import com.abc.das.dto.AvailabilityDto;
import com.abc.das.dto.DoctorDto;
import com.abc.das.dto.PatientReportDto;

import com.abc.das.entity.Doctor;
import com.abc.das.entity.Patient;

public interface IDoctorService {
	public DoctorDto saveDoctor(DoctorDto doctordto);

	public Doctor updateDoctor(Doctor doctor);

	public void deleteDoctor(int doctorId);

	public Doctor getDoctorById(int doctorId);

	public AvailabilityDto addAvailabilityByDoctorId(AvailabilityDto availabilityDto);

	public PatientReportDto addPatientReportByReportId(PatientReportDto patientReportDto);

	public List<Doctor> getAllDoctor();
	

}
