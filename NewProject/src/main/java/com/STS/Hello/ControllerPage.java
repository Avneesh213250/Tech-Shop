package com.STS.Hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.STS.Service.CustomerService;
import com.STS.domain.Login;
import com.STS.domain.Register;

@Controller

public class ControllerPage {

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
	public String login(@ModelAttribute("login")Login Login, ModelMap map) {
		System.out.println("login_check");
		System.out.println(Login);

		Register r= cs.findById(Login);
		return "index";
		
	}
	@RequestMapping(value = {"/registerEmp", "/MyProject/registerEmp" }, method = RequestMethod.POST)
	public String Register(@ModelAttribute("register")Register Register, ModelMap map) {
		System.out.println("registerEmp=====> "+ Register);

		int i=cs.saveData(Register);
		System.out.println("in t "+i);
		if(i==1) {
			map.addAttribute("msg", "Registration completed successfully");
		}else {
			map.addAttribute("msg", "Sorry, Please try again");
		}
		return "index";
		
	}
	
}
