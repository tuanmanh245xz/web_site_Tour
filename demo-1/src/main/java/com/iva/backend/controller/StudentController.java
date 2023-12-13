package com.iva.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentController {
	
	
		@RequestMapping("/student/form")
		public String showform() {
			
			return "student-form";
		}
		@RequestMapping("/student/save")
		public String saveData(HttpServletRequest req, ModelMap model) {
			String name = req.getParameter("name");
			String diem = req.getParameter("mark");
			String major = req.getParameter("major");
			model.addAttribute("NAME","Ho va ten:"+name);
			model.addAttribute("DIEM","Diem tong :"+diem);
			model.addAttribute("MAJOR","chuyen nganh:"+major);
			return "student_info";
		}
}
