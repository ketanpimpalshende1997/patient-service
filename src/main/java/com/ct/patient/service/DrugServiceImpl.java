package com.ct.patient.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.patient.dto.DrugMasterDto;
import com.ct.patient.dto.DrugDto;
import com.ct.patient.entity.Drug;
import com.ct.patient.entity.MasterDrug;
import com.ct.patient.repo.DrugMasterRepository;
import com.ct.patient.repo.DrugRepository;

@Service
public class DrugServiceImpl implements DrugServiceI {

	@Autowired
	private DrugRepository repository;


	@Autowired
	private DrugMasterRepository drugMasterepository;
	
	@Override
	public boolean saveDrug(DrugDto medicines) {
		Drug drug = new Drug();
		drug.setAppointmentId(medicines.getAppointmentId());
		drug.setDrugName(medicines.getDrugName());
		drug.setDrugId(medicines.getDrugId());
		drug.setDrugGenericName(medicines.getDrugGenericName());
		drug.setDrugBrandName(medicines.getDrugBrandName());
		drug.setDrugForm(medicines.getDrugForm());
		
		drug.setCreatedAt(new Date());
		drug.setUpdatedAt(new Date());
		Drug medicin = repository.save(drug);
		return medicin != null;
	}

	@Override
	public List<Drug> findWithAppointmentId(Integer id) {

		return repository.findByAppointmentId(id);
	}

	@Override
	public boolean deleteMedication(Long id) {
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	public boolean saveDrugMaster(DrugMasterDto drugDto)
	{
		
		MasterDrug drugMaster=new MasterDrug();
		drugMaster.setDrugId(drugDto.getDrugId());
		drugMaster.setDrugName(drugDto.getDrugName());
		drugMaster.setDrugGenericName(drugDto.getDrugGenericName());
		drugMaster.setDrugBrandName(drugDto.getDrugBrandName());
		drugMaster.setDrugForm(drugDto.getDrugForm());
		drugMaster.setDrugStrength(drugDto.getDrugStrength());
		
		
		
		MasterDrug d=	drugMasterepository.save(drugMaster);
		return d!=null;
	}

}
