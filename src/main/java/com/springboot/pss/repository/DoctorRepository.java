package com.springboot.pss.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pss.entity.Doctor;

@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Integer>{

}
