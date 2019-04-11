package com.harishgowda84.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(){
		return "welcome";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/manager")
	public String manager(){
		return "manager";
	}
	
	@RequestMapping("/dummy")
	public String dummy(){
		return "dummy";
	}
	
	@RequestMapping("/logout")
	public String logout(){
		return "login";
	}

}
