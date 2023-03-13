package com.ashokit.plan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.plan.model.PlanDetails;
import com.ashokit.plan.service.PlanDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/plans/")
@Slf4j
public class PlanDetailsAPI {

	@Autowired
	PlanDetailsService planService;
	
	@GetMapping("/viewplans")
	public ResponseEntity<?> viewAllPlans(@RequestHeader ("myapp-tracing-id") String tracingId)
	{	log.info("myapp-tracing-id is found in Plans-Service : {}", tracingId);
		return new ResponseEntity<List<PlanDetails>>(planService.fetchPlans(), HttpStatus.OK);
	}
	
	@GetMapping("/viewplans/{planId}")
	public ResponseEntity<?> viewSpecificPlan(@PathVariable String planId, @RequestHeader("myapp-tracing-id") String traceId)
	{	
		log.info("myapp-tracing-id is found in Plans-Service :{}", traceId);
		log.info("viewSpecificPlan method execution started");
		PlanDetails plan=planService.fetchSpecificPlan(planId);
		log.info("viewSpecificPlan method execution completed");
		if(plan!=null)
		{
			return new ResponseEntity<PlanDetails>(plan, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Plan with id " + planId + " does not exist ", HttpStatus.BAD_REQUEST);
		}
	}
}
