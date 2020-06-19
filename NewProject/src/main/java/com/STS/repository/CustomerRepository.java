package com.STS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.STS.domain.Register;

public interface CustomerRepository extends JpaRepository<Register, Long> {
	
	@Query("select r from Register r where r.email=:email and r.password=:password")
   Register findByEmailandPassword(String email, String password) ;
}
