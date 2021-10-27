package com.ct.patient.service;

import java.util.List;

import com.ct.patient.entity.Procedure;
import com.ct.patient.entity.MasterProcedure;

public interface ProcedureService {

	boolean save(Procedure procedure);

	List<Procedure> findWithAppointmentId(Integer id);

	boolean deleteProcedure(Long procedureId);

	boolean saveMaster(MasterProcedure procedureMaster);
}
