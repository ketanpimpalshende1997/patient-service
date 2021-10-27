package com.ct.patient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.dto.DiagnosisMasterDto;
import com.ct.patient.entity.MasterDiagnosis;
import com.ct.patient.repo.DiagnosisMasterRepository;

@Service
public class DiagnosisMasterService implements DiagnosisMasterServiceI {

	@Autowired
	private DiagnosisMasterRepository repo;

	@Override
	public List<DiagnosisMasterDto> getAllDiagnosis() {
		List<MasterDiagnosis> diagnoMaster = repo.findAll();

		List<DiagnosisMasterDto> listDto = new ArrayList<>();

		for (MasterDiagnosis diagnoMasterData : diagnoMaster) {
			DiagnosisMasterDto d = new DiagnosisMasterDto();
			d.setDiagnosisCode(diagnoMasterData.getDiagnosisCode());
			d.setDescription(diagnoMasterData.getDescription());

			if (diagnoMasterData.isDepricated() == Boolean.TRUE)
				d.setIsDepricated("yes");
			else
				d.setIsDepricated("no");

			listDto.add(d);

		}

		return listDto;
	}

	@Override
	public MasterDiagnosis getWithDiagnosisCode(String code) {
		return repo.findBydiagnosisCode(code);
	}

	@Override
	public boolean saveDiagnosisMasterData(MasterDiagnosis diagnosis) {
		MasterDiagnosis d = repo.save(diagnosis);
		return d != null;
	}

	@Override
	public List<DiagnosisMasterDto> getAllActiveDiagnosis() {

		List<MasterDiagnosis> list = repo.findAllActiveDiagnosis();

		List<DiagnosisMasterDto> dtoList = new ArrayList<>();
		for (MasterDiagnosis dm : list) {
			DiagnosisMasterDto diagnoMasterDto = new DiagnosisMasterDto();
			diagnoMasterDto.setDiagnosisCode(dm.getDiagnosisCode());
			diagnoMasterDto.setDescription(dm.getDescription());
			diagnoMasterDto.setIsDepricated("no");
			dtoList.add(diagnoMasterDto);
		}

		return dtoList;

	}

}
