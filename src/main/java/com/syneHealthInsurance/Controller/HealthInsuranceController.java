package com.syneHealthInsurance.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.syneHealthInsurance.Entity.HealthInsuranceCompany;
import com.syneHealthInsurance.Exceptions.CompanyNotFoundException;
import com.syneHealthInsurance.Services.HealthInsuranceCompanyService;


import lombok.Setter;

@RestController
@Setter
@CrossOrigin(origins = "*")
public class HealthInsuranceController {

	@Autowired
	HealthInsuranceCompanyService comService;
	
	
	@GetMapping(path="/api/healthinsurance/getCompany")
	public List<HealthInsuranceCompany> getAllCompany() {
        		
		if(this.comService.getAllHealthInsuranceCompany() == null)
		{
			throw new CompanyNotFoundException("No Entries In  Database");
		}
		else
		{
			return this.comService.getAllHealthInsuranceCompany();
		}
	}
	
	@GetMapping(path= "/api/healthinsurance/getCompany/{compId}")
	public HealthInsuranceCompany getHealthInsuranceCompanyById(@PathVariable Long compId)
	{
	
		return this.comService.getHealthInsuranceCompanyById(compId);
	}

	
	@PostMapping(path ="/api/healthinsurance/getCompany")
	public HealthInsuranceCompany addCompany(@RequestBody HealthInsuranceCompany entity)
	{
		return this.comService.saveHealthInsuranceCompany(entity);
	}
	
	
	@DeleteMapping(path= "/api/healthinsurance/deleteCompany/{compId}")
	public void deleteInsuranceCompany(@PathVariable Long compId)
	{
		comService.deleteCompany(compId);
	}
	
	@PutMapping(path= "/api/healthinsurance/updateCompany")
	public HealthInsuranceCompany updateInsuaranceCompany(@RequestBody HealthInsuranceCompany companyEntity)
	{
		return this.comService.updateHealthInsuranceCompany(companyEntity);
	}
}
