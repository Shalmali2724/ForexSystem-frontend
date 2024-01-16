package com.abc.das.service;

import java.time.LocalDate;
import java.util.List;

import com.abc.das.dto.AppointmentDto;
import com.abc.das.entity.Appointment;
import com.abc.das.entity.Doctor;
import com.abc.das.exception.AppointmentNotFoundException;


public interface IAppointmentService 
{
public List<Appointment> getAllAppointments();
public AppointmentDto saveAppointment(AppointmentDto apptDto);
public String deleteAppointmentById(int appointmentId);
public List<Appointment> getAppointmentsByDoctorId(int doctorId);

public List<Appointment> getAppointmentsByPatientId(int patientId);

public Appointment getAppointmentById(int appointmentId);



}




