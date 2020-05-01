package com.syneHealthInsurance.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syneHealthInsurance.Entity.Policy;
import com.syneHealthInsurance.Exceptions.PolicyNotFoundException;
import com.syneHealthInsurance.Repository.PolicyRepo;


@Service
public class PolicyServiceImple implements PolicyService{

	@Autowired
	private PolicyRepo policyRepo;
	
	public List<Policy> getAllPolicy() {
	
		return	policyRepo.findAll();
		
	}

	
	public Policy getPolicyById(long id) {
		Policy policy=null;
		if(policyRepo.findById(id).isPresent())
		{
		 policy =  policyRepo.findById(id).get();
		 return policy;
		}
		else
		{
			throw new PolicyNotFoundException("No Policy found with the required id in system");
		}
		
	}

	
	public Policy updatePolicy(Policy policy) {

		return policyRepo.save(policy);
	}

	
	public Policy addPolicy(Policy entity) {
	
		return policyRepo.save(entity);
	}

	
	public void deletePolicy(long policyId) {
	
	 policyRepo.deleteById(policyId);
	}

	public List<Policy> getPolicyByAgeAndMonthlyPremium(int age,double monthlyPremium)
	{
      return  policyRepo.getPolicyFilterByAgeAndMonthlyPremium(age,monthlyPremium);
	}

	public List<Policy> getPolicyByAgeAndType(int age,String type)
	{
		return policyRepo.getPolicyFilterByAgeAndType(age, type);
	}
	

}
