package com.ct.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.entity.Procedure;
import com.ct.patient.entity.ProcedureMaster;
import com.ct.patient.repo.ProcedureMasterRepo;
import com.ct.patient.repo.ProcedureRepository;

@Service
public class ProcedureserviceImpl implements ProcedureService {

	@Autowired
	private ProcedureRepository repository;

	@Autowired
	private ProcedureMasterRepo procedureMasterRepo;

	@Override
	public boolean save(Procedure procedure) {
		Procedure p = repository.save(procedure);
		return p != null;
	}

	@Override
	public List<Procedure> findWithAppointmentId(Integer id) {
		return repository.findByAppointmentId(id);
	}

	@Override
	public boolean deleteProcedure(Long procedureId) {
		try {
			repository.deleteById(procedureId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean saveMaster(ProcedureMaster procedureMaster) {
		ProcedureMaster proc = procedureMasterRepo.save(procedureMaster);
		return proc != null;
	}

}
