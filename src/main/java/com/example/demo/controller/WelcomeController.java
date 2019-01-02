package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController 
{
	
	//inject via application.properties
	//Value("${welcome.message:test}")
	private String message ="Hello World";
	
	@GetMapping("/hi")
	private String welcome(Map<String,Object> model)
	{
		model.put("message", this.message);
		
		return "welcome";
	}
	
}
