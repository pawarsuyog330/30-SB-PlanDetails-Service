package com.ashokit.plan.service;

import java.util.List;

import com.ashokit.plan.model.PlanDetails;

public interface PlanDetailsService {

	List<PlanDetails> fetchPlans();

	PlanDetails fetchSpecificPlan(String planId);
}
