package com.ashokit.plan.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.plan.entity.PlanDetailsEntity;
import com.ashokit.plan.model.PlanDetails;
import com.ashokit.plan.repository.PlanDetailsEntityRepository;
import com.ashokit.plan.service.PlanDetailsService;

@Service
public class PlanDetailsServiceImpl implements PlanDetailsService {

	@Autowired
	PlanDetailsEntityRepository planRepo;

	@Override
	public List<PlanDetails> fetchPlans() {
		List<PlanDetailsEntity> listPlans = planRepo.findAll();
		List<PlanDetails> lstPlan = new ArrayList<>();
		listPlans.forEach(entity -> {
			PlanDetails plan = new PlanDetails();
			BeanUtils.copyProperties(entity, plan);
			lstPlan.add(plan);
		});
		return lstPlan;
	}

	@Override
	public PlanDetails fetchSpecificPlan(String planId) {
		Optional<PlanDetailsEntity> opt = planRepo.findById(planId);
		if (opt.isPresent()) {
			PlanDetailsEntity entity = opt.get();
			PlanDetails plan = new PlanDetails();
			BeanUtils.copyProperties(entity, plan);
			return plan;
		}
		return null;
	}

}
