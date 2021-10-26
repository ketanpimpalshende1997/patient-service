package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.ProcedureMaster;

@Repository
public interface ProcedureMasterRepo extends JpaRepository<ProcedureMaster, String> {

	public ProcedureMaster findByprocedureCode(String procedureCode);

	@Query("FROM ProcedureMaster pm WHERE pm.isDepricated = false")
	List<ProcedureMaster> findAllActiveProcedures();

}
