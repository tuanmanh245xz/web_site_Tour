package com.iva.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller

public class MyController {
	//http://localhost:8888/hello
	@RequestMapping("hello")
	public String hello_word() {	
		return "hello";
	}
	@RequestMapping("say-hi")
	public String home() {		
		return "hello";
	}
	@RequestMapping("/form")
	public String show_form() {		
		return "login_from";
	}
//	@PostMapping("/result")
//	public String login(HttpServletRequest req, ModelMap model) {	
//		Double NumberA = Double.parseDouble(req.getParameter("numberA"));
//		Double NumberB = Double.parseDouble(req.getParameter("numberB"));
//		System.out.println("result :"+" " +(NumberA + NumberB));
//		int kq = (int) (NumberA + NumberB);
//		model.addAttribute("A","Number A:"+NumberA);
//		model.addAttribute("B","Number B :"+NumberB);
//		model.addAttribute("DIEM","Diem tong :"+kq);
//		return "result";
//	}
	@GetMapping(value = "/result", params = "add")
	public String add(HttpServletRequest req, ModelMap model) {	
		Double NumberA = Double.parseDouble(req.getParameter("numberA"));
		Double NumberB = Double.parseDouble(req.getParameter("numberB"));
		System.out.println("result :"+" " +(NumberA + NumberB));
		int kq = (int) (NumberA + NumberB);
		System.out.println("result :"+" " +kq);
		model.addAttribute("A","Number A:"+NumberA);
		model.addAttribute("B","Number B :"+NumberB);
		model.addAttribute("DIEM","Diem tong :"+kq);
		return "result";
	}
	@GetMapping(value = "/result", params = "sub")
	public String sub(HttpServletRequest req, ModelMap model) {	
		Double NumberA = Double.parseDouble(req.getParameter("numberA"));
		Double NumberB = Double.parseDouble(req.getParameter("numberB"));
		System.out.println("result :"+" " +(NumberA + NumberB));
		int kq = (int) (NumberA - NumberB);
		System.out.println("result :"+" " +kq);
		model.addAttribute("A","Number A:"+NumberA);
		model.addAttribute("B","Number B :"+NumberB);
		model.addAttribute("DIEM","Diem tong :"+kq);
		return "result";
	}
	
}
