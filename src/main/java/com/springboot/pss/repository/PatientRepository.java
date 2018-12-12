package com.springboot.pss.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pss.entity.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer>{

}
