package com.STS.Hello;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.STS.Service.EmpService;
import com.STS.domain.Emp;

@RestController
public class EmpController {
	@Autowired
	private EmpService empService;
	
@RequestMapping("/getData")
public List<Emp> getData(){
	return empService.getAll();
			
			
}

@RequestMapping("/getSingleData/{id}")
public Emp getSingleData(@PathVariable String id){
	
	return empService.getEmp(id);
			
}
}
