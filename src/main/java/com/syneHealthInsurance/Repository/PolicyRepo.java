package com.syneHealthInsurance.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.syneHealthInsurance.Entity.Policy;

@Repository
public interface PolicyRepo extends JpaRepository<Policy, Long> {

	@Query(value= "SELECT pc FROM Policy pc WHERE pc.age = :age AND pc.monthPrimium = :monthlyPremium")
	public List<Policy> getPolicyFilterByAgeAndMonthlyPremium(@Param("age") int age, @Param("monthlyPremium") double monthlyPremium);
	
	@Query(value = "SELECT pc FROM Policy pc WHERE pc.age = :age AND pc.planType = :planType")
	public List<Policy> getPolicyFilterByAgeAndType(@Param("age") int age, @Param("planType") String  planType);
	
}
