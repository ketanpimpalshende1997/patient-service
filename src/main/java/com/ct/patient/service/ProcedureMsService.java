package com.ct.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.entity.ProcedureMaster;
import com.ct.patient.repo.ProcedureMasterRepo;

@Service
public class ProcedureMsService {

	@Autowired
	private ProcedureMasterRepo repo;

	public List<ProcedureMaster> getAll() {
		return repo.findAll();
	}

	public ProcedureMaster getByProcedureCode(String code) {
		return repo.findByprocedureCode(code);
	}

	public ProcedureMaster getByProcedureName(String name) {
		return repo.findByprocedureDiscription(name);
	}
}
