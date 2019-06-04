package com.invictus.crm.dto;

import javax.validation.constraints.NotEmpty;

public class CreateUserRequestDto {

	@NotEmpty(message = "userName is mandatory")
	private String userName;
	
	@NotEmpty(message = "password is mandatory")
	private String password;
	
	@NotEmpty(message = "firstName is mandatory")
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@NotEmpty(message = "Role is mandatory")
	private String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
		
}
