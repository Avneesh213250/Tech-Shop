package com.STS.Hello;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.STS.Service.CustomerService;
import com.STS.domain.Login;
import com.STS.domain.Register;

//@RestController
public class MyRestController {
	@Autowired
	CustomerService cs;

	@RequestMapping(value = {"/login", "/MyProject/login" }, method = RequestMethod.GET)
	public ModelAndView loginPage() {
	
        
		System.out.println("loginpage");
		return new ModelAndView("login", "login", new Login());
		
	}
	@RequestMapping(value = {"/register", "/MyProject/register" }, method = RequestMethod.GET)
	public ModelAndView registerPage() {
		System.out.println("registerpage");
		return new ModelAndView("register", "register", new Register());
		
		}
		@RequestMapping(value = {"/index", "/MyProject/index" }, method = RequestMethod.GET)
	public String indexPage() {
		System.out.println("indexpage");
		return "index";
		
	}
	@RequestMapping(value = {"/login_check", "/MyProject/login_check" }, method = RequestMethod.POST)
	public ResponseEntity<Register> Login(@RequestBody Login Login, ModelMap map) {
		System.out.println("login_check");
		System.out.println(Login);

		Optional<Register> r= Optional.of(cs.findById(Login));
		return ResponseEntity.of(r);
		
	}
	@RequestMapping(value = {"/registerEmp", "/MyProject/registerEmp" }, method = RequestMethod.POST)
	public ResponseEntity Register(@RequestBody Register Register, ModelMap map) {
		return ResponseEntity.ok(cs.saveData(Register));
		
	}
	@PostMapping("/{email}")
	public ResponseEntity deleteByEmail(@PathVariable String email) {
		
		if(!cs.findByEmail(email).isPresent()) {
			ResponseEntity.badRequest().build();
		}
		cs.deleteByEmail(email);
		return ResponseEntity.ok().build();
	}
	@PostMapping("/update/{email}")
	public ResponseEntity<Register> update(@RequestBody Register register, @PathVariable String email){
		System.out.println(email);
		Register register2=cs.updateByEmail(email, register);
		
		return ResponseEntity.ok(register2);
	}
}
