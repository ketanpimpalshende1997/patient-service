package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

	List<Medication> findByAppointmentId(Integer appointmentId);
}
