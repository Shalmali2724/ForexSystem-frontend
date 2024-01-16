package com.abc.das.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.dto.AvailabilityDto;
import com.abc.das.dto.DoctorDto;
import com.abc.das.dto.PatientReportDto;

import com.abc.das.entity.Doctor;
import com.abc.das.entity.Patient;
import com.abc.das.exception.DoctorNotFoundException;
import com.abc.das.repository.IDoctorRepository;

@Service
public class IDoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepository idoctorRepository;

	@Autowired
	private IAvailabilityService iAvaialabilityService;

	@Autowired
	private IPatientReportService iPatientReportService;
	
	

	@Override
	public DoctorDto saveDoctor(DoctorDto doctordto) {
		Doctor doctor = new Doctor();
		doctor.setDoctorName(doctordto.getDoctorName());
		doctor.setDoctorPhone(doctordto.getDoctorPhone());
		doctor.setEmail(doctordto.getEmail());
		doctor.setLocation(doctordto.getLocation());
		doctor.setPassword(doctordto.getPassword());
		doctor.setSpecialization(doctordto.getSpecialization());
		doctor.setChargespervisit(doctordto.getChargespervisit());

		Doctor newDoctor = idoctorRepository.save(doctor);
		DoctorDto newDto = new DoctorDto();
		newDto.setDoctorId(newDoctor.getDoctorId());
		newDto.setDoctorName(newDoctor.getDoctorName());
		newDto.setDoctorPhone(newDoctor.getDoctorPhone());
		newDto.setEmail(newDoctor.getEmail());
		newDto.setLocation(newDoctor.getLocation());
		newDto.setPassword(newDoctor.getPassword());
		newDto.setSpecialization(newDoctor.getSpecialization());
		newDto.setChargespervisit(newDoctor.getChargespervisit());
		return newDto;

	}
	@Override
	public List<Doctor> getAllDoctor()
	{
		List<Doctor> doctor = idoctorRepository.findAll();
		return doctor;
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) throws DoctorNotFoundException {
		Optional<Doctor> optionalDoctor = idoctorRepository.findById(doctor.getDoctorId());
		if (optionalDoctor.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not existing with id:" + doctor.getDoctorId());
		}
		Doctor updatedDoctor = idoctorRepository.save(doctor);
		return updatedDoctor;
	}

	@Override
	public void deleteDoctor(int doctorId) throws DoctorNotFoundException {
		Optional<Doctor> optionalDoctor = idoctorRepository.findById(doctorId);
		if (optionalDoctor.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not existing with id:" + doctorId);
		}
		idoctorRepository.deleteById(doctorId);

	}

	@Override
	public Doctor getDoctorById(int doctorId) throws DoctorNotFoundException {
		Optional<Doctor> optionalDoctor = idoctorRepository.findById(doctorId);
		if (optionalDoctor.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not existing with id:" + doctorId);
		}
		Doctor doctor = optionalDoctor.get();

		return doctor;
	}

	@Override
	public AvailabilityDto addAvailabilityByDoctorId(AvailabilityDto availabilityDto) {

		return iAvaialabilityService.addAvailability(availabilityDto);
	}

	@Override
	public PatientReportDto addPatientReportByReportId(PatientReportDto patientReportDto) {

		return iPatientReportService.addPatientReportDto(patientReportDto);
	}

	

}
