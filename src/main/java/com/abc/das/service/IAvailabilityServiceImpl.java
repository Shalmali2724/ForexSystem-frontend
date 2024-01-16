package com.abc.das.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.dto.AvailabilityDto;
import com.abc.das.dto.DoctorDto;
import com.abc.das.entity.Appointment;
import com.abc.das.entity.Availability;
import com.abc.das.entity.Doctor;
import com.abc.das.exception.AppointmentNotFoundException;
import com.abc.das.exception.AvailabilityNotFoundException;
import com.abc.das.exception.DoctorNotFoundException;
import com.abc.das.repository.IAvailabilityRepository;
import com.abc.das.repository.IDoctorRepository;

@Service
public class IAvailabilityServiceImpl implements IAvailabilityService {
	@Autowired
	private IAvailabilityRepository availabilityRepository;

	@Autowired
	private IDoctorRepository iDoctorRepository;

	@Override

	public AvailabilityDto addAvailability(AvailabilityDto avlDto) {

		Optional<Doctor> optionalDoctor = iDoctorRepository.findById(avlDto.getDoctorId());
		if (optionalDoctor.isEmpty()) {
			throw new DoctorNotFoundException("doctor id not exists");
		}
		Doctor doctor = optionalDoctor.get();

		Availability avl = new Availability();
		avl.setAvailabilityId(avlDto.getAvailabilityId());
		avl.setFromDate(avlDto.getFromDate());
		avl.setToDate(avlDto.getToDate());
		avl.setStatus(avlDto.getStatus());
		avl.setDoctor(doctor);

		Availability newAvailability = availabilityRepository.save(avl);
//		AvailabilityDto availabilityDto = new AvailabilityDto();
		avlDto.setAvailabilityId(avl.getAvailabilityId());
//		availabilityDto.setDoctorId(newAvailability.getDoctor().getDoctorId());
//		availabilityDto.setFromDate(newAvailability.getFromDate());
//		availabilityDto.setToDate(newAvailability.getToDate());
//		availabilityDto.setStatus(newAvailability.getStatus());

		return avlDto;

	}

	@Override
	public Availability updateAvailability(Availability availability) {
		Optional<Availability> optionalAvailability = availabilityRepository.findById(availability.getAvailabilityId());
		if (optionalAvailability.isEmpty()) {
			throw new AvailabilityNotFoundException(
					"Availability not existing with id:" + availability.getAvailabilityId());
		}

		Availability updateAvailability = availabilityRepository.save(availability);

		return availability;

	}

	@Override
	public void removeAvailability(int availabilityId) throws AvailabilityNotFoundException {
		Optional<Availability> optionalAvailability = availabilityRepository.findById(availabilityId);
		if (optionalAvailability.isEmpty()) {
			throw new AvailabilityNotFoundException("Availability not existing with this id");
		}
		availabilityRepository.deleteById(availabilityId);

	}

	@Override
	public List<Availability> getAllAvailabilities() {
		return availabilityRepository.findAll();

	}

	@Override
	public List<Availability> getAvailabilityByDoctorId(int doctorId) {
		Optional<Doctor> optionalDoctor = iDoctorRepository.findById(doctorId);
		if (optionalDoctor.isEmpty()) {
			throw new DoctorNotFoundException("There is no doctor with given Id :" + doctorId);
		}

		Doctor doctor = optionalDoctor.get();
		List<Availability> list = availabilityRepository.findByDoctor(doctor);
		if (list.isEmpty()) {
			throw new AvailabilityNotFoundException("There are no availability for the doctor :" + doctorId);
		}
		return list;

	}

	@Override
	public Availability getAvailabilityById(int id) {
		Optional<Availability> optionalAvailability = availabilityRepository.findById(id);
		if (optionalAvailability.isEmpty()) {
			throw new AvailabilityNotFoundException("There is no doctor with given Id :" + id);
		}
		Availability availability = optionalAvailability.get();
		
		return availability;
	}

}
