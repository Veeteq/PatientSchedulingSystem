package com.springboot.pss.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "phonenumber")
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="phonenumber_seq")
	@SequenceGenerator(name="phonenumber_seq", sequenceName="phonenumber_seq")
	private long id;
	private String type;
	private String number;

	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}
