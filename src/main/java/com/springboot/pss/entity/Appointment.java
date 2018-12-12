package com.springboot.pss.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="appointment_seq")
	@SequenceGenerator(name="appointment_seq", sequenceName="appointment_seq")
	private int id;
	
	@Column(name="appointmenttime")
	private Timestamp appointmentTime;
	
	@Column(name="started")
	private boolean isStarted;
	
	@Column(name="ended")
	private boolean isEnded;
	
	private String reason;

	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Doctor doctor;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Timestamp appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public boolean isStarted() {
		return isStarted;
	}

	public void setStarted(boolean isStarted) {
		this.isStarted = isStarted;
	}

	public boolean isEnded() {
		return isEnded;
	}

	public void setEnded(boolean isEnded) {
		this.isEnded = isEnded;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointmentTime=" + appointmentTime + ", isStarted=" + isStarted
				+ ", isEnded=" + isEnded + ", reason=" + reason + "]";
	}
}
