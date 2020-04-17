package com.example.demo.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table
@Entity
@Data
public class InsuranceCompany {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long companyId;
	private String companyName;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
	//@JoinColumn(name ="comID_refe")  ;   //just a name
	// @OneToMany(fetch = FetchType.LAZY,mappedBy = "InsuranceCompany",cascade = CascadeType.ALL)
	    private List<Policy> policy;
	
}
