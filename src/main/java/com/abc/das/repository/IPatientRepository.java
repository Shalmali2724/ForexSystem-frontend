package com.abc.das.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.das.dto.DoctorDto;
import com.abc.das.dto.PatientDto;
import com.abc.das.entity.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer>{

	Object save(PatientDto patient);
	@Query("select p from Patient p where p.email= :pemail and p.password= :pwd")
	Optional<Patient> login(@Param("pemail") String email, @Param("pwd") String password);
	Optional<Patient> findByemail(String email);
	
	
}
