package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author R.Emmanuel Raj
 *
 * POJOS
 */
@Entity
public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank(message="Name is mandatory")
	private String name;
	
	
	@NotBlank(message="email is Mandatory")
	private String email;
	


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	public User(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


	





	
	
	
	
	
	
	
	
	
	

}
