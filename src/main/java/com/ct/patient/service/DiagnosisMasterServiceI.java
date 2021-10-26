package com.ct.patient.service;

import java.util.List;

import com.ct.patient.dto.DiagnosisMasterDto;
import com.ct.patient.entity.DiagnosisMaster;

public interface DiagnosisMasterServiceI 
{
	public List<DiagnosisMasterDto> getAllDiagnosis();

	public DiagnosisMaster getWithDiagnosisCode(String code);
	
	public boolean saveDiagnosisMasterData(DiagnosisMaster diagnosis);

	public List<DiagnosisMasterDto> getAllActiveDiagnosis();
		
}
