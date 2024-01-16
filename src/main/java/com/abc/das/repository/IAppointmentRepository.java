package com.abc.das.repository;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.das.entity.Appointment;
import com.abc.das.entity.Doctor;
import com.abc.das.entity.Patient;



public interface IAppointmentRepository extends JpaRepository<Appointment,Integer>
{

	public List<Appointment> findBydoctor(Doctor doctor);
	public List<Appointment> findBypatient(Patient patient);
	//public List<Appointment> findByappointementStatus();
}
