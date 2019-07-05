package com.STS.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.STS.domain.Emp;
import com.STS.domain.login;
import com.STS.domain.register;
import com.Service.testService;

@Service
public class EmpService implements testService {
	@Value("${myName}")
	String myName;
	
	List<Emp> list= Arrays.asList(
			
			new Emp("608741", "Avneesh Shrivastav", "Hi, HOw are u doing"),
			new Emp("608742", "Paramita Banik", "Hi, HOw are u doing"),
			new Emp("608743", "Dinesh Reddy", "Hi, HOw are u doing")
			);
public List<Emp> getAll(){
	return Arrays.asList(
			new Emp("608741", "Avneesh Shrivastav", "Hi, HOw are u doing"),
			new Emp("608742", "Paramita Banik", "Hi, HOw are u doing"),
			new Emp("608743", "Dinesh Reddy", "Hi, HOw are u doing")
			);	
}
public Emp getEmp(String id) {
	System.out.println("id  ==> "+id);
	return new Emp("608741", "Avneesh Shrivastav", "Hi, HOw are u doing");
}
public String loginValidate(login log) {
	System.out.println(log);
		 System.out.println("property check  = > "+myName); 
	/*Session openSession = sessionFactory.openSession();
	Transaction tx = openSession.beginTransaction(); 
	Criteria ct=openSession.createCriteria(employee.class);
	Criterion id=Restrictions.eq("id", log.getId());
	Criterion pass=Restrictions.eq("password", log.getPassword());*/
	
	return "hello";
}
public String registerEmp(register register) {
	System.out.println(register);
	return "okay done";
}
}
