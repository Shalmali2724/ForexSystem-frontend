package com.abc.das.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.dto.AppointmentDto;
import com.abc.das.dto.DoctorDto;
import com.abc.das.dto.FeedbackDto;
import com.abc.das.dto.PatientDto;

import com.abc.das.entity.Appointment;
import com.abc.das.entity.Doctor;

import com.abc.das.entity.Patient;

import com.abc.das.exception.AppointmentNotFoundException;
import com.abc.das.exception.DoctorNotFoundException;
import com.abc.das.exception.FeedBackNotFoundException;
import com.abc.das.exception.PatientNotFoundException;

import com.abc.das.repository.IAppointmentRepository;
import com.abc.das.repository.IDoctorRepository;
import com.abc.das.repository.IPatientRepository;


@Service
public class IAppointmentServiceImpl implements IAppointmentService {

	@Autowired
	IAppointmentRepository apptRepository;

	@Autowired
	IPatientRepository iPatientRepository;

	@Autowired
	IDoctorRepository iDoctorRepository;


	@Override
	public List<Appointment> getAllAppointments() throws AppointmentNotFoundException 
	{
		List<Appointment> appointment = apptRepository.findAll();
		if (appointment.isEmpty()) {

			throw new AppointmentNotFoundException("Appointement Not Exists ");

		}
		return appointment;

	}

	@Override
	public String deleteAppointmentById(int appointmentId) {
		Optional<Appointment> optional = apptRepository.findById(appointmentId);

		if (optional.isEmpty()) {
			throw new AppointmentNotFoundException("Id Not Exists :" + appointmentId);
		}

		Appointment appointment = optional.get();
		apptRepository.delete(appointment);
		return "Appointment deleted ";

	}

	@Override
	public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
		Optional<Doctor> optionalDoctor = iDoctorRepository.findById(doctorId);
		if (optionalDoctor.isEmpty()) {
			throw new DoctorNotFoundException("There is no doctor with given Id :" + doctorId);
		}

		Doctor doctor = optionalDoctor.get();
		List<Appointment> list = apptRepository.findBydoctor(doctor);
		
		
		if (list.isEmpty() ) {
			throw new AppointmentNotFoundException("There are no appointment for the doctor :" + doctorId);
		}
		return list;

	}

	@Override
	public List<Appointment> getAppointmentsByPatientId(int patientId) {
		Optional<Patient> optionalPatient = iPatientRepository.findById(patientId);
		if (optionalPatient.isEmpty()) {
			throw new PatientNotFoundException("There are no appointment with this Id :" + patientId);
		}
		Patient patient = optionalPatient.get();
		List<Appointment> list = apptRepository.findBypatient(patient);
		if (list.isEmpty()) {
			throw new AppointmentNotFoundException("There are no appointment for the the Id :" + patientId);
		}

		return list;
	}

	@Override
	public AppointmentDto saveAppointment(AppointmentDto apptDto) {
		Appointment appointment = new Appointment();

		appointment.setDate(apptDto.getDate());
		appointment.setRemark(apptDto.getRemark());
		 //appointment.setAppointementStatus(apptDto.getAppointementStatus());

		Optional<Doctor> optionalDoctor = iDoctorRepository.findById(apptDto.getDoctorId());
		if (optionalDoctor.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not existing with id:" + apptDto.getDoctorId());
		}
		Doctor doctor = optionalDoctor.get();

		List<Appointment> doctorAppointments = doctor.getAppointments();
		doctorAppointments.add(appointment);
		appointment.setDoctor(doctor);

		Optional<Patient> optionalPatient = iPatientRepository.findById(apptDto.getPatientId());

		if (optionalPatient.isEmpty()) {
			throw new PatientNotFoundException("Patient not existing with id:" + apptDto.getPatientId());
		}
		
		
		
		Patient patient = optionalPatient.get();
		List<Appointment> patientAppointments = patient.getAppointments();
		patientAppointments.add(appointment);
		appointment.setPatient(patient);
		
	
		LocalDate toDate=doctor.getAvailability().getToDate();
		LocalDate fromDate=doctor.getAvailability().getFromDate();
		LocalDate date =apptDto.getDate();
		 if( !((date.compareTo(fromDate) >= 0) && (date.compareTo(toDate)<= 0)))
		 {
			
				throw new AppointmentNotFoundException("Doctor not avilable on this date");
          }
		
		
		 appointment.setAppointementStatus("Booked");
		
		
		Appointment newAppointement = apptRepository.save(appointment);
	//	AppointmentDto newAppointementDto = new AppointmentDto();
		apptDto.setAppointmentId(newAppointement.getAppointmentId());
		apptDto.setAppointementStatus(newAppointement.getAppointementStatus());

		return apptDto;

	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		Optional<Appointment> optionalAppointment = apptRepository.findById(appointmentId);
		if (optionalAppointment.isEmpty()) {
			throw new AppointmentNotFoundException("There is No Appointment With this Id");
		}

	Appointment appointment = optionalAppointment.get();
		
		
		return appointment;
	}

}
