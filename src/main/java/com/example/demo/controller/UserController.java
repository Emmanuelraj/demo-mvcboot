package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.repository.UserJpaRepository;

@Controller
public class UserController {

	
	
	@Autowired
	UserJpaRepository userJpaRepository;
	
	
	
	
	
	
	@GetMapping("/signUp")
	public String showSignUpForm(@ModelAttribute ("user")User user, BindingResult bindingResult)
	{
		return "add-user";
	}
	
	
	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult bindingResult, Model model)
	{
	   System.out.println("user"+user.getEmail()+""+user.getName());
		
		 if(bindingResult.hasErrors())
			  
		 {
			 return "add-user";
		 }
		
		 
			 userJpaRepository.save(user);
			 
			 model.addAttribute("users",userJpaRepository.findAll());
			 return "index";
		
		 
	}
	
	
	
	@GetMapping("/viewAll")
	@ResponseBody
	public List<User> viewAllMethod()
	{
		  return  userJpaRepository.findAll();
	}
	
   
	
	
	@GetMapping("/edit/{id}")
	public String updateUser(@PathVariable("id") long id, Model model)
	{ 
		 System.out.println("updateUser method ById"+id);
		 
		 
		  User user  = userJpaRepository.findById(id)
				  .orElseThrow(() ->  new IllegalArgumentException("Invalid User"+id));
		
		   model.addAttribute("user", user);
		   
		   
		   return "update-user";
		   
	}
	

	
	
	@PostMapping("/update/{id}")
	public String updateById(@PathVariable("id") long id, @Valid User user, BindingResult bindingResult, Model model)
	{
		System.out.println("updateById"+id);
		
		if(bindingResult.hasErrors())
		{
			user.setId(id);
			return "update-user";
		}
		
		userJpaRepository.save(user);
		
		model.addAttribute("users", userJpaRepository.findAll());
		
		return "index";
		
	} 
	
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id")long id, Model model)
	{
		
		  System.out.println("deleteUserById"+id);
		
		  userJpaRepository.deleteById(id);
		  
		  model.addAttribute("users", userJpaRepository.findAll());
		
		  return "index";
		  
	}
	
	

}
