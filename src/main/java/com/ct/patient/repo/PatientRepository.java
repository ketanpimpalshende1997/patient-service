package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.request.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
