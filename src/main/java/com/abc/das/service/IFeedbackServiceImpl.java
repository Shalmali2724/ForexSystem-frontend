package com.abc.das.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.das.dto.FeedbackDto;
import com.abc.das.dto.PatientDto;
import com.abc.das.entity.Appointment;
import com.abc.das.entity.Doctor;
import com.abc.das.entity.Feedback;
import com.abc.das.entity.Patient;
import com.abc.das.exception.AppointmentNotFoundException;
import com.abc.das.exception.DoctorNotFoundException;
import com.abc.das.exception.FeedBackNotFoundException;
import com.abc.das.exception.PatientNotFoundException;
import com.abc.das.repository.IAppointmentRepository;
import com.abc.das.repository.IDoctorRepository;
import com.abc.das.repository.IFeedbackRepository;
import com.abc.das.repository.IPatientRepository;

@Service
public class IFeedbackServiceImpl implements IFeedbackService {

	@Autowired
	private IFeedbackRepository iFeedbackRepository;

	@Autowired
	private IDoctorRepository iDoctorRepository;
	
	@Autowired
	private IPatientRepository iPatientRepository;
	
	@Autowired
	private IAppointmentRepository iAppointmentRepository;

	@Override
	public FeedbackDto addFeedback(FeedbackDto feedbackDto)throws DoctorNotFoundException {
		Feedback feedback = new Feedback();

		Optional<Doctor> optionalDoctor = iDoctorRepository.findById(feedbackDto.getDoctorId());
		if (optionalDoctor.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not existing with id:" + feedbackDto.getDoctorId());

		}

		feedback.setDoctorId(feedbackDto.getDoctorId());
		feedback.setRating(feedbackDto.getRating());
		feedback.setComments(feedbackDto.getComments());
		
		Optional<Patient> optionalPatient = iPatientRepository.findById(feedbackDto.getPatientId());
        
		if (optionalPatient.isEmpty()) {
			throw new PatientNotFoundException("Patient not existing with id:" +feedbackDto.getPatientId());
		}
		
		
		
		Patient patient = optionalPatient.get();
		List<Feedback>patientFeedbacks = patient.getFeedbacks();
		patientFeedbacks.add(feedback);
		feedback.setPatient(patient);
		
		
		Optional<Appointment> optionalAppointment = iAppointmentRepository.findById(feedbackDto.getAppointmentId());
		if(optionalAppointment.isEmpty())
		{
			throw new AppointmentNotFoundException("Appoint Not Existing with id:"+feedbackDto.getAppointmentId());
		}
		Appointment appointment = optionalAppointment.get();
		feedback.setAppointment(appointment);
		
		
		
       /*
		Patient patient = new Patient();
		patient.setAge(feedbackDto.getPatientDto().getAge());
		patient.setAddress(feedbackDto.getPatientDto().getAddress());
		patient.setBloodGroup(feedbackDto.getPatientDto().getBloodGroup());
		patient.setEmail(feedbackDto.getPatientDto().getEmail());
		patient.setGender(feedbackDto.getPatientDto().getGender());
		patient.setPassword(feedbackDto.getPatientDto().getPassword());
		patient.setPatientName(feedbackDto.getPatientDto().getPatientName());
		patient.setPatientPhone(feedbackDto.getPatientDto().getPatientPhone());
		patient.setPatientIssue(feedbackDto.getPatientDto().getPatientIssue());
		patient.setWeight(feedbackDto.getPatientDto().getWeight());
		feedback.setPatient(patient);

		Feedback newFeedback = iFeedbackRepository.save(feedback);

		FeedbackDto newFeedbackDto = new FeedbackDto();
		newFeedbackDto.setFeedbackId(newFeedback.getFeedbackId());
		newFeedbackDto.setDoctorId(newFeedback.getDoctorId());
		newFeedbackDto.setComments(newFeedback.getComments());
		newFeedbackDto.setRating(newFeedback.getRating());

		PatientDto newPatientDto = new PatientDto();
		//newPatientDto.setPatientId(newFeedback.getPatient().getPatientId());
		newPatientDto.setAge(newFeedback.getPatient().getAge());
		newPatientDto.setAddress(newFeedback.getPatient().getAddress());
		newPatientDto.setBloodGroup(newFeedback.getPatient().getBloodGroup());
		newPatientDto.setEmail(newFeedback.getPatient().getEmail());
		newPatientDto.setGender(newFeedback.getPatient().getGender());
		newPatientDto.setPassword(newFeedback.getPatient().getPassword());
		newPatientDto.setPatientName(newFeedback.getPatient().getPatientName());
		newPatientDto.setPatientPhone(newFeedback.getPatient().getPatientPhone());
		newPatientDto.setPatientIssue(newFeedback.getPatient().getPatientIssue());
		newPatientDto.setWeight(newFeedback.getPatient().getWeight());

		return newFeedbackDto;
     */
		Feedback newFeedback = iFeedbackRepository.save(feedback);

		FeedbackDto newFeedbackDto = new FeedbackDto();
		return newFeedbackDto;
	}

	@Override
	public List<Feedback> getAllFeedbacks() throws FeedBackNotFoundException{
		List<Feedback> feedback = iFeedbackRepository.findAll();
		if (feedback.isEmpty()) {

			throw new FeedBackNotFoundException("Feedback not existing ");

		}
		return feedback;

	}

	@Override
	public List<Feedback> getFeedbackById(int doctorId)throws DoctorNotFoundException {
		Optional<Doctor> optionalDoctor = iDoctorRepository.findById(doctorId);
		if (optionalDoctor.isEmpty()) {
			throw new DoctorNotFoundException("Doctor not existing with id :" + doctorId);

		}
        Doctor doctor = optionalDoctor.get();
		List<Feedback> optionalFeedback = iFeedbackRepository.findByDoctorId(doctor.getDoctorId());
		/*
		if (optionalFeedback.isEmpty()) {

			throw new FeedBackNotFoundException("Feedback not existing with id :" + feedbackId);

		}
		// if (optionalFeedback.isPresent()) {

		// }
		 
		 */
		if(optionalFeedback.isEmpty())
		{
			throw new DoctorNotFoundException("There are No Feedback for this Doctor:" + doctorId);
		}
		return optionalFeedback;

	}

}
