package com.ct.patient.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ct.patient.entity.MasterProcedure;

@Repository
public interface ProcedureMasterRepo extends JpaRepository<MasterProcedure, String> {

	public MasterProcedure findByprocedureCode(String procedureCode);

	@Query("FROM MasterProcedure pm WHERE pm.isDepricated = false  order by procedureCode")
	List<MasterProcedure> findAllActiveProcedures();

	@Query("FROM MasterProcedure order by procedureCode")
	List<MasterProcedure> findAll();

}
