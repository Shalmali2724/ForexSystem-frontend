package com.abc.das.service;

import java.util.List;

import com.abc.das.dto.AvailabilityDto;
import com.abc.das.entity.Availability;
import com.abc.das.entity.Doctor;
import com.abc.das.exception.DoctorNotFoundException;

public interface IAvailabilityService {
	public AvailabilityDto addAvailability(AvailabilityDto avlDto);
	public Availability updateAvailability(Availability availability);
	public void removeAvailability(int availabilityId);
	public List<Availability> getAllAvailabilities();
	
	List<Availability> getAvailabilityByDoctorId(int doctorId);
	public Availability getAvailabilityById(int id);
	

}
