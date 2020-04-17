package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.CompanyNotFoundException;
import com.example.demo.entity.InsuranceCompany;
import com.example.demo.entity.Policy;
import com.example.demo.repo.InsuranceCompanyRepo;
import com.example.demo.repo.PolicyRepository;

@RestController
@RequestMapping("/api.his.com")
public class InsuranceCompanyController {

	@Autowired
	private InsuranceCompanyRepo comRepo;
	
	@Autowired
	private PolicyRepository policyRepo;
	
	@GetMapping(path="/getAllCompany")
	public List<InsuranceCompany> getAllInsuranceCompany()
	{
	   return comRepo.findAll();
	}

	@GetMapping(path="/getAllCompany/{comId}")
	public Optional<InsuranceCompany> getAllInsuranceCompany(@PathVariable Long comId)
	{
		if(!comRepo.existsById(comId))
		{
			throw new CompanyNotFoundException();	
		}
		else
		{

			return comRepo.findById(comId);
		}
	}

	
	@PostMapping(path="/getAllCompany")
	public InsuranceCompany addCompany(@RequestBody InsuranceCompany ComEntity)
	{
		return this.comRepo.save(ComEntity);
	}
	
	@GetMapping(path= "/getAllPolicy")
	public List<Policy> getAllPolicy()
	{
		return this.policyRepo.findAll();
	}
	

	
    //DELETE COMPANY
    @DeleteMapping("/deleteCompany/{comid}")	
   	public ResponseEntity<Object> deleteCompany(@PathVariable Long comid)
   	{
       	if(!comRepo.existsById(comid))
       	{
       		System.out.println("ID NOT EXIST FOR DELETE OPERATION");
       		throw new CompanyNotFoundException();
       	
       	}else {
       	System.out.println("inside the delete method");
       	System.out.println("id - "+ comid);
       	comRepo.deleteById(comid);
       	return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
       	}
   	}
   	
    //UPDATE POLICY 
    @PutMapping("/updatePolicy")
    public Policy updatePolicy(@RequestBody Policy entity)
    {
    	return policyRepo.save(entity);
    }
	
    //UPDATE InsuranceCompany
    @PutMapping("/updateCompany")
    public InsuranceCompany updatePolicy(@RequestBody InsuranceCompany ComEntity)
    {
    	return comRepo.save(ComEntity);
    }
	
}
