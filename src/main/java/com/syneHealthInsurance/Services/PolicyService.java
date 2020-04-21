package com.syneHealthInsurance.Services;

import java.util.List;

import com.syneHealthInsurance.Entity.Policy;

public interface PolicyService {

	
	public List<Policy> getAllPolicy();
	
	public Policy getPolicyById(); 
	
	public Policy updatePolicy(long policyId);

	//
	public Policy addPolicy(long comId);
	
	public void deletePolicy(long policyId);
	
	
}
