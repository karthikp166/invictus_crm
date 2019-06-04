package com.invictus.crm.dto;

import javax.validation.constraints.NotEmpty;

public class CreateRoleRequestDto {

	@NotEmpty(message = "Role name is mandatory")
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
