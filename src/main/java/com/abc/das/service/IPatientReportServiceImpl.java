package com.abc.das.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.dto.FeedbackDto;
import com.abc.das.dto.PatientDto;
import com.abc.das.dto.PatientReportDto;
import com.abc.das.entity.Appointment;
import com.abc.das.entity.Feedback;
import com.abc.das.entity.Patient;
import com.abc.das.entity.PatientReport;

import com.abc.das.exception.PatientNotFoundException;
import com.abc.das.exception.PatientReportNotFoundException;
import com.abc.das.repository.IPatientReportRepository;
import com.abc.das.repository.IPatientRepository;

@Service
public class IPatientReportServiceImpl implements IPatientReportService {
	@Autowired
	private IPatientReportRepository iPatientreportrepository;

	@Autowired
	private IPatientRepository iPatientRepository;
	
	@Autowired
	private IPatientReportRepository iPatientReportRepository;

	@Override
	public PatientReportDto addPatientReportDto(PatientReportDto patientReportDto) throws PatientNotFoundException {
		PatientReport patientReport = new PatientReport();

		Optional<Patient> optionalPatient = iPatientRepository
				.findById(patientReportDto.getPatientId());
		if (optionalPatient.isEmpty()) {
			throw new PatientNotFoundException(
					"Patient is not existing with this Patient Id:" + patientReportDto.getPatientId());

		}

		patientReport.setReportId(patientReportDto.getReportId());
		patientReport.setReportDate(patientReportDto.getReportDate());
		patientReport.setAge(patientReportDto.getAge());
		patientReport.setBloodGroup(patientReportDto.getPatientIssue());
		patientReport.setPrescription(patientReportDto.getPrescription());
		patientReport.setBloodGroup(patientReportDto.getBloodGroup());
		patientReport.setWeight(patientReportDto.getWeight());
		patientReport.setDoctorId(patientReportDto.getDoctorId());
		patientReport.setPatientIssue(patientReportDto.getPatientIssue());
		
/*
		Patient patient = new Patient();
		patient.setAge(patientReportDto.getPatientDto().getAge());
		patient.setAddress(patientReportDto.getPatientDto().getAddress());
		patient.setBloodGroup(patientReportDto.getPatientDto().getBloodGroup());
		patient.setEmail(patientReportDto.getPatientDto().getEmail());
		patient.setGender(patientReportDto.getPatientDto().getGender());
		patient.setPassword(patientReportDto.getPatientDto().getPassword());
		patient.setPatientName(patientReportDto.getPatientDto().getPatientName());
		patient.setPatientPhone(patientReportDto.getPatientDto().getPatientPhone());
		patient.setPatientIssue(patientReportDto.getPatientDto().getPatientIssue());
		patient.setWeight(patientReportDto.getPatientDto().getWeight());
		patientReport.setPatient(patient);

		PatientReport newPatientReport = iPatientreportrepository.save(patientReport);

		PatientReportDto newPatientReportDto = new PatientReportDto();
		newPatientReportDto.setReportId(newPatientReportDto.getReportId());
		newPatientReportDto.setReportDate(newPatientReportDto.getReportDate());

		PatientDto newPatientDto = new PatientDto();
		newPatientDto.setPatientId(newPatientReport.getPatient().getPatientId());
		newPatientDto.setAge(newPatientReport.getPatient().getAge());
		newPatientDto.setAddress(newPatientReport.getPatient().getAddress());
		newPatientDto.setBloodGroup(newPatientReport.getPatient().getBloodGroup());
		newPatientDto.setEmail(newPatientReport.getPatient().getEmail());
		newPatientDto.setGender(newPatientReport.getPatient().getGender());
		newPatientDto.setPassword(newPatientReport.getPatient().getPassword());
		newPatientDto.setPatientName(newPatientReport.getPatient().getPatientName());
		newPatientDto.setPatientPhone(newPatientReport.getPatient().getPatientPhone());
		newPatientDto.setPatientIssue(newPatientReport.getPatient().getPatientIssue());
		newPatientDto.setWeight(newPatientReport.getPatient().getWeight());
*/
		Patient patient = optionalPatient.get();
		patientReport.setPatient(patient);
		PatientReport newPatientReport = iPatientReportRepository.save(patientReport);

		PatientReportDto newPatientReportDto = new PatientReportDto();
		
		return newPatientReportDto;
	}

	@Override
	public PatientReport getPatientReportById(int patientId) throws PatientReportNotFoundException {

		Optional<Patient> optionalPatient = iPatientRepository.findById(patientId);

		if (optionalPatient.isEmpty()) {

			throw new PatientReportNotFoundException("Report is not existing for this patient id:" + patientId);

		}
		Patient patient = optionalPatient.get();
		Optional<PatientReport> optionalPatientReport = iPatientReportRepository.findBypatient(patient);
		PatientReport patientReport = optionalPatientReport.get();
		return patientReport;
	}

}
