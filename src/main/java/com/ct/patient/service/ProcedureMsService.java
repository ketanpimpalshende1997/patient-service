package com.ct.patient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.dto.ProcedureMasterDto;
import com.ct.patient.entity.MasterProcedure;
import com.ct.patient.repo.ProcedureMasterRepo;

@Service
public class ProcedureMsService {

	@Autowired
	private ProcedureMasterRepo repo;

	public List<ProcedureMasterDto> getAll() {

		List<MasterProcedure> procMaster = repo.findAll();

		List<ProcedureMasterDto> listDto = new ArrayList<>();

		for (MasterProcedure procMasterData : procMaster) {
			ProcedureMasterDto d = new ProcedureMasterDto();
			d.setProcedureCode(procMasterData.getProcedureCode());
			d.setDescription(procMasterData.getDescription());

			if (Boolean.TRUE == procMasterData.isDepricated())
				d.setIsDepricated("yes");
			else
				d.setIsDepricated("no");

			listDto.add(d);

		}

		return listDto;

	}

	public MasterProcedure getByProcedureCode(String code) {
		return repo.findByprocedureCode(code);
	}

	public List<ProcedureMasterDto> getAllActiveProcedures() {
		List<MasterProcedure> list = repo.findAllActiveProcedures();
		List<ProcedureMasterDto> dtoList = new ArrayList<>();
		for (MasterProcedure pm : list) {
			ProcedureMasterDto procMasterDto = new ProcedureMasterDto();
			procMasterDto.setProcedureCode(pm.getProcedureCode());
			procMasterDto.setDescription(pm.getDescription());
			procMasterDto.setIsDepricated("no");
			dtoList.add(procMasterDto);
		}

		return dtoList;
	}

	public void deleteProcedure(String procedureCode) {
		 repo.deleteById(procedureCode);;
	}

}
