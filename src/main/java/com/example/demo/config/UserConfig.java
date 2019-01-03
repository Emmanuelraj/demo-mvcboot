package com.example.demo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.model.User;
import com.example.demo.repository.UserJpaRepository;
/**
 * 
 * @author user
 *  commandLineRunner basically used to populate before get and set method 
 *  Bean equivalent to xml configuration
 *  
 *  lambda expressions  in java 8 
 *  
 *  fun(args1, args2 ) ->              {S.op(args1+""+args2)}
 *     func            Arrow              Body of lambda expression
 *                      token  
 */                    
@EnableJpaRepositories(basePackageClasses= UserJpaRepository.class)
@Configuration

public class UserConfig  
{		
	
	@Bean
	CommandLineRunner commandLineRunner(UserJpaRepository  jpaRepository) 
	{
			// TODO Auto-generated method stub
		  return strings->
		  {
			jpaRepository.save(new User("Immanuel", "immanuel.raj18@gmail.com"));
			jpaRepository.save(new User("johndoe", "johndoe18@gmail.com"));
			jpaRepository.save(new User("mary", "mary18@gmail.com"));
		  };
		
	}
	
		

}
