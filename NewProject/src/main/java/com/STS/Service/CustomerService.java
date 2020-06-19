package com.STS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.STS.domain.Login;
import com.STS.domain.Register;
import com.STS.repository.CustomerRepository;

@Service
public class CustomerService {

	
	@Autowired
	CustomerRepository cr;
	
	public int saveData(Register Register) {
		
		Register a= cr.save(Register);
		int test=0;
		System.out.println("redao service  "+a);
		if(a!=null) {
			test=1;
		}
		return test;
		
	}
	
	public Register findById(Login Login) {
		Register Register=cr.findByEmailandPassword(Login.getEmail(), Login.getPsw());
		System.out.println("register data=> "+Register);
		return Register;
		
	}
}
