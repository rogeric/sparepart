package com.seagate.sparepart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@RequestMapping("/login")
	public String loginPage(Model model, @RequestParam(value = "error", required = false) String error){
		if(error != null){
			model.addAttribute("error", "Invalid username or password!");
		}		
		return "login";
	}
	
	@RequestMapping("/403")
	public String page403(){
		String path = "/error/";
		return path + "403";
	}
}
