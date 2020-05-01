package com.syneHealthInsurance.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syneHealthInsurance.Entity.Policy;
import com.syneHealthInsurance.Exceptions.PolicyNotFoundException;
import com.syneHealthInsurance.Services.PolicyServiceImple;

import lombok.Setter;

@RestController
@RequestMapping("/api/healthinsurance")
@Setter
@CrossOrigin(origins = "*")
public class PolicyController {

	@Autowired
	PolicyServiceImple policyService;
	
	
	@GetMapping(path="/getPolicy")
	public List<Policy> getAllPolicy() {
        		
		if(this.policyService.getAllPolicy() == null)
		{
			throw new PolicyNotFoundException("No Entries In  Database");
		}
		else
		{
			return this.policyService.getAllPolicy();
		}
	}
	
	@GetMapping(path= "/getPolicy/{policyId}")
	public Policy getPolicyById(@PathVariable Long policyId)
	{
	
		return this.policyService.getPolicyById(policyId);
	}

	
	@PostMapping(path ="/getPolicy")
	public Policy addPolicy(@RequestBody Policy entity)
	{
		return this.policyService.addPolicy(entity);
	}
	
	
	@DeleteMapping(path= "/deletePolicy/{policyId}")
	public void deletePolicy(@PathVariable Long policyId)
	{
		policyService.deletePolicy(policyId);
	}
	
	@PutMapping(path= "/updatePolicy")
	public Policy updatePolicy(@RequestBody Policy entity)
	{
		//System.out.println(entity);
		return this.policyService.updatePolicy(entity);
	}

	@GetMapping(path="/getPolicy/{age}/{monthlyPremium}")
	public List<Policy> filterPolicyOnAgeAndMonthlyPremium(@PathVariable Integer age, @PathVariable Double monthlyPremium)
	{
				if((policyService.getPolicyByAgeAndMonthlyPremium(age, monthlyPremium)).size()>=1)
				{
					return policyService.getPolicyByAgeAndMonthlyPremium(age, monthlyPremium);
				}
				else
				{
					throw new PolicyNotFoundException("No Matching Policy found..!");
				}
	}
	
	
	@GetMapping(path ="/getPolicyByAgeAndType/{age}/{type}")
	public List<Policy> filterPolicyOnAgeAndType(@PathVariable Integer age, @PathVariable String type)
	{
		if((policyService.getPolicyByAgeAndType(age, type).size()>=1))
		{
			return policyService.getPolicyByAgeAndType(age, type);
		}
		else
		{
			throw new PolicyNotFoundException("No Matching Policy found..!");
		}
		
	}
	
}
