package com.syneHealthInsurance.Services;

import java.util.List;

import com.syneHealthInsurance.Entity.Policy;

public interface PolicyService {

	
	public List<Policy> getAllPolicy();
	
	public Policy getPolicyById(long policyId); 
	
	public Policy updatePolicy(Policy policy);

	public Policy addPolicy(Policy policy);
	
	public void deletePolicy(long policyId);
	
    public List<Policy> getPolicyByAgeAndMonthlyPremium(int age, double monthlyPremium);
    
    public List<Policy> getPolicyByAgeAndType(int age, String type);
    
}
