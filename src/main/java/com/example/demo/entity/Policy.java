package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table
@Data
@Entity
public class Policy {

	
 @Id
 private long policyNumber;
 private String policyName;
 private long lifeCover;
 private float numberOfYear;
 private double monthPrimium;
 private double yearPrimium;
}
