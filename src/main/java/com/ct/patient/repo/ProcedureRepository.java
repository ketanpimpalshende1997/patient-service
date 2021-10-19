package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.Procedure;

@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Long> {

	List<Procedure> findByAppointmentId(Integer appointmentId);
}
