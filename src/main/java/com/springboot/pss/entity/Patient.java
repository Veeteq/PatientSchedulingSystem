package com.springboot.pss.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="patient_seq")
	@SequenceGenerator(name="patient_seq", sequenceName="patient_seq")
	private int id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@OneToMany(mappedBy="patient", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<PhoneNumber> phoneNumbers;

	@Embedded
	private Insurance insurance;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="patients_doctors", 
               joinColumns=@JoinColumn(name="patient_id", referencedColumnName="id"), 
               inverseJoinColumns=@JoinColumn(name="doctor_id", referencedColumnName="id"))
	private List<Doctor> doctors;
	
	@OneToMany
	private List<Appointment> appointments;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void addPhoneNumber(PhoneNumber phoneNumber) {
		if(phoneNumber != null){
			if(phoneNumbers == null) {
				phoneNumbers = new HashSet<PhoneNumber>();
			}
			phoneNumber.setPatient(this);
			phoneNumbers.add(phoneNumber);
		}
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumbers="
				+ phoneNumbers + ", insurance=" + insurance + "]";
	}
}
