package com.ashokit.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.plan.entity.PlanDetailsEntity;

@Repository
public interface PlanDetailsEntityRepository extends JpaRepository<PlanDetailsEntity, String> {

	
}
