package com.ashokit.plan.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PLAN_DETAILS")
public class PlanDetailsEntity {

	@Id
	private String planId;
	
	private String planDescription;
	
	private String planValidity;
}
