package com.abc.das.service;


import com.abc.das.dto.PatientReportDto;
import com.abc.das.entity.PatientReport;

public interface IPatientReportService 
{
	

	PatientReport getPatientReportById(int Id);

	PatientReportDto addPatientReportDto(PatientReportDto patientReportDto);
	
}
