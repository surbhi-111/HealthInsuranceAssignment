package com.syneHealthInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syneHealthInsurance.Entity.HealthInsuranceCompany;

public interface HealthInsuranceCompanyRepo extends JpaRepository<HealthInsuranceCompany, Long> {

}
