package com.syneHealthInsurance.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syneHealthInsurance.Entity.HealthInsuranceCompany;
import com.syneHealthInsurance.Exceptions.CompanyNotFoundException;
import com.syneHealthInsurance.Repository.HealthInsuranceCompanyRepo;

@Service
public class HealthInsuranceCompanyServiceImple implements HealthInsuranceCompanyService {

	@Autowired
	HealthInsuranceCompanyRepo comRepo;
	
	
	
	public HealthInsuranceCompany saveHealthInsuranceCompany(HealthInsuranceCompany company) {
		
      return comRepo.save(company);
	}

	
	public List<HealthInsuranceCompany> getAllHealthInsuranceCompany() {
	
	    return comRepo.findAll();
		
	}

	
	public HealthInsuranceCompany getHealthInsuranceCompanyById(long compId) {
		
		HealthInsuranceCompany company = null;
		if(comRepo.existsById(compId))
		{
			Optional<HealthInsuranceCompany> result =  comRepo.findById(compId);
			if(result.isPresent())
			{
				company=result.get(); 
			}
			return company;
		}
		else
		{
		  throw new CompanyNotFoundException("Company with CompanyId - "+compId+" does not exist !");
		}
	}

	
	public void deleteCompany(long compId) {
	 
		if(comRepo.existsById(compId))
		{
			comRepo.deleteById(compId);	
		}
		else
		{
			throw new CompanyNotFoundException("Company you want to delete with CompanyId - "+compId+" does not exist !");
			
		}

	}

	
	public HealthInsuranceCompany updateHealthInsuranceCompany(HealthInsuranceCompany comEntity) {
		
		
		  return comRepo.save(comEntity);
	}

}
