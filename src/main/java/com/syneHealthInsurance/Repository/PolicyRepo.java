package com.syneHealthInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syneHealthInsurance.Entity.Policy;

public interface PolicyRepo extends JpaRepository<Policy, Long> {

}
