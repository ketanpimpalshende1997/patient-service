package com.ct.patient.service;

import java.util.List;

import com.ct.patient.dto.DiagnosisMasterDto;
import com.ct.patient.entity.MasterDiagnosis;

public interface DiagnosisMasterServiceI 
{
	public List<DiagnosisMasterDto> getAllDiagnosis();

	public MasterDiagnosis getWithDiagnosisCode(String code);
	
	public boolean saveDiagnosisMasterData(MasterDiagnosis diagnosis);

	public List<DiagnosisMasterDto> getAllActiveDiagnosis();
		
}
