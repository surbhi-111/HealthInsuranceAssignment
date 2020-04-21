package com.syneHealthInsurance.Services;

import java.util.List;
import java.util.Optional;

import com.syneHealthInsurance.Entity.HealthInsuranceCompany;

public interface HealthInsuranceCompanyService {

	
	public HealthInsuranceCompany saveHealthInsuranceCompany(HealthInsuranceCompany company);
	
	public List<HealthInsuranceCompany> getAllHealthInsuranceCompany();
	
	public HealthInsuranceCompany getHealthInsuranceCompanyById(long compId);
	
	public void deleteCompany(long compId);
	
    public HealthInsuranceCompany updateHealthInsuranceCompany(HealthInsuranceCompany entity);
	
	
}
