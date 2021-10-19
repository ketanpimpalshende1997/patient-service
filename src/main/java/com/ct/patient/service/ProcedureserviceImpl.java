package com.ct.patient.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.entity.Procedure;
import com.ct.patient.entity.Procedures;
import com.ct.patient.repo.ProcedureRepository;

@Service
public class ProcedureserviceImpl implements ProcedureService {

	@Autowired
	private ProcedureRepository repository;

	@Override
	public boolean save(List<Procedures> list, Integer appointmentId) {
		Procedure procedure = new Procedure(appointmentId, new Date(), new Date(), list);
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

}
