package com.ct.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.ProcedureMaster;

@Repository
public interface ProcedureMasterRepo extends JpaRepository<ProcedureMaster, String> {

	public ProcedureMaster findByprocedureCode(String procedureCode);

	public ProcedureMaster findByprocedureDiscription(String procedureName);
}
