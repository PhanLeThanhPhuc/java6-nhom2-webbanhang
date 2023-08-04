package thanhphuc.java6.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;


import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


	@GetMapping("/login")
	public String viewLogin(Model model) {
		return "layout/login";
	}

	
	@GetMapping("/home")
	public String viewHome() {
		return "layout/home";
	}
	

}
