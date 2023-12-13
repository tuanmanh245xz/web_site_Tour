package com.iva.backend.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello_controller {
		@GetMapping("/demo")
		public String Hello() {
			return "index";
			
		}
}	
