package com.abc.das.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.das.dto.DoctorDto;
import com.abc.das.entity.Doctor;
//import com.abc.das.entity.Patient;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor,Integer>{

	Object save(DoctorDto doctor);
	@Query("select d from Doctor d where d.email= :mail and d.password= :pwd")
	Optional<Doctor>login(@Param("mail") String email,@Param("pwd") String password);
    Optional<Doctor> findByemail(String email);

}

