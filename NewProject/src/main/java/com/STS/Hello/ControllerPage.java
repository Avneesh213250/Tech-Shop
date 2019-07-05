package com.STS.Hello;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;

import com.STS.Service.EmpService;
import com.STS.domain.*;

import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Data
public class ControllerPage {
	@Autowired
	private EmpService empService;
	Logger log =LoggerFactory.getLogger(ControllerPage.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		log.info("Hello Avneesh Shrivastav");
        
		System.out.println("loginpage");
		return new ModelAndView("login", "login", new login());
		
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPage() {
		System.out.println("registerpage");
		return new ModelAndView("register", "register", new register());
		
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexPage() {
		System.out.println("indexpage");
		return "index";
		
	}
	@RequestMapping(value = "/login_check", method = RequestMethod.POST)
	public String login(@ModelAttribute("login")login login, ModelMap map) {
		System.out.println("login_check");
		String check=empService.loginValidate(login);
		
		return "index";
		
	}
	@RequestMapping(value = "/registerEmp", method = RequestMethod.POST)
	public String register(@ModelAttribute("register")register register, ModelMap map) {
		System.out.println("registerEmp");
		String regis=empService.registerEmp(register);
		
		return "index";
		
	}
}
