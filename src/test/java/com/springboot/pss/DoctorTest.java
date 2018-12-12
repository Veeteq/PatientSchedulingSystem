package com.springboot.pss;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.pss.entity.Appointment;
import com.springboot.pss.entity.Doctor;
import com.springboot.pss.entity.Insurance;
import com.springboot.pss.entity.Patient;
import com.springboot.pss.entity.PhoneNumber;
import com.springboot.pss.repository.AppointmentRepository;
import com.springboot.pss.repository.DoctorRepository;
import com.springboot.pss.repository.PatientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorTest {

	@Autowired
	DoctorRepository doctorRepository;
	
	@Autowired
	PatientRepository patientRepository;

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Test
	public void testCreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Gregory");
		doctor.setLastName("House");
		doctor.setSpecialisation("Pediatrics");
		
		doctorRepository.save(doctor);
	}
	
	@Test
	public void testCreatePatient() {
		Patient patient = new Patient();
		patient.setFirstName("Hanna");
		patient.setLastName("Śleszyńska");
		
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setType("Mobile");
		phoneNumber.setNumber("48607060606");		
		patient.addPhoneNumber(phoneNumber);
		
		Insurance insurance = new Insurance();
		insurance.setProviderName("Blue Cross");
		insurance.setCoPayment(29.99);
		patient.setInsurance(insurance);
		
		Doctor doctor = doctorRepository.findById(1).get();
		List<Doctor> doctors = Arrays.asList(doctor);
		patient.setDoctors(doctors);
		
		patientRepository.save(patient);
	}
	
	@Test
	@Transactional()
	@Rollback(value=false)
	public void testAddPhoneNumber() {
		Patient patient = patientRepository.findById(-44).get();
		
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setType("Work");
		phoneNumber.setNumber("48555444333");		
		
		patient.addPhoneNumber(phoneNumber);
		patientRepository.save(patient);
		
	}
	
	@Test
	public void testCreateAppointment() {
		Appointment appointment = new Appointment();
		appointment.setAppointmentTime(new Timestamp(new Date().getTime()));
		appointment.setReason("Emergency");
		appointment.setStarted(true);
		appointment.setEnded(false);
		
		Patient patient = patientRepository.findById(-44).get();
		appointment.setPatient(patient);
		
		Doctor doctor = doctorRepository.findById(1).get();
		appointment.setDoctor(doctor);
		
		appointmentRepository.save(appointment);
	}
}
