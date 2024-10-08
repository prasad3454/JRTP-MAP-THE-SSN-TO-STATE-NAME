package com.ssn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssn.entity.SsnEntity;

public interface SsnEntityRepository extends JpaRepository<SsnEntity, Long> {
	
}
