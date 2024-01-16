package com.abc.das.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.das.entity.Patient;
import com.abc.das.entity.PatientReport;

public interface IPatientReportRepository extends JpaRepository<PatientReport, Integer> {

	Optional<PatientReport> findBypatient(Patient patient);

}
