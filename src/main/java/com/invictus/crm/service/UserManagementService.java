package com.invictus.crm.service;

import com.invictus.crm.dto.CreateRoleRequestDto;
import com.invictus.crm.dto.CreateUserRequestDto;
import com.invictus.crm.dto.GetUserDetailsResponseDto;
import com.invictus.crm.dto.UserRolesResponseDto;

public interface UserManagementService {

	void createRole(CreateRoleRequestDto createRoleRequest);
	
	void createUser(CreateUserRequestDto createUserRequest);

	UserRolesResponseDto getUserRoles();

	GetUserDetailsResponseDto getUserDetails(String userName);
}
