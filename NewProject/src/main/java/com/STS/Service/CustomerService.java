package com.STS.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.STS.domain.Login;
import com.STS.domain.Register;
import com.STS.repository.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	CustomerRepository cr;
	
	public Register saveData(Register Register) {
		
		Register a= cr.save(Register);

		return a;
		
	}
	
	public Register findById(Login Login) {
		Register Register=cr.findByEmailandPassword(Login.getEmail(), Login.getPsw());
		System.out.println("register data=> "+Register);
		return Register;
		
	}
	
	public Optional<Register> findByEmail(String email) {
		
		Optional<Register> register= cr.findById(email);
		System.out.println(register+"  tset56");
		return register;
	}
	public void deleteByEmail(String email) {
		cr.deleteById(email);
	}
	
	public Register updateByEmail(String email, Register register) {
		
		Optional<Register> r= cr.findById(email);
		System.out.println("test r  "+r);
		Register test=null;
		if(r.isPresent()) {
			register.setEmail(email);
			test=cr.save(register);
		}
		return test;
		
		
	}
}
