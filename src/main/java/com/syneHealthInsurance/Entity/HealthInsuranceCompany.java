package com.syneHealthInsurance.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class HealthInsuranceCompany {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long companyId;
	
	private String companyName;
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Policy> policy;	
	
	
	
}
