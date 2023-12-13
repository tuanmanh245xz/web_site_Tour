package com.iva.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
	//@RequestMapping("/")
	@GetMapping("/")
	public String Home() {
	
		return "index";
	}
	@GetMapping("/user")
	public String User(HttpServletRequest request) {
		String name = request.getParameter("name");
		System.out.println(name);
		request.setAttribute("Name", name);
		return "demo";
	}
	
}
