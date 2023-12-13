package com.iva.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Helllo {
	@RequestMapping("home")
	//@ResponseBody
	public String hello() {
		return "index";
	}
}
