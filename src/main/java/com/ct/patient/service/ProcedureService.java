package com.ct.patient.service;

import java.util.List;

import com.ct.patient.entity.Procedure;
import com.ct.patient.entity.Procedures;

public interface ProcedureService {

	boolean save(List<Procedures> procedures, Integer appointmentId);

	List<Procedure> findWithAppointmentId(Integer id);

	boolean deleteProcedure(Long procedureId);
}
