package com.abc.das.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.das.dto.AvailabilityDto;
import com.abc.das.entity.Availability;
import com.abc.das.entity.Doctor;


@Repository
public interface IAvailabilityRepository extends JpaRepository<Availability,Integer>{



	AvailabilityDto save(AvailabilityDto avlDto);

	List<Availability> findByDoctor(Doctor doctor);



	

	



	
}
	


