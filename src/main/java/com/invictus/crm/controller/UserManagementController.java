package com.invictus.crm.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.invictus.crm.dto.CreateRoleRequestDto;
import com.invictus.crm.dto.CreateUserRequestDto;
import com.invictus.crm.dto.GetUserDetailsResponseDto;
import com.invictus.crm.dto.UserRolesResponseDto;
import com.invictus.crm.service.UserManagementService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/v1/user")
public class UserManagementController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserManagementService userManagementService;
	
	@RequestMapping( method = RequestMethod.POST	, consumes = "application/json")
	@ApiOperation(value = "Create User", protocols = "http", notes = "Creating new User.")
	public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserRequestDto createUserRequest){
		log.info("UserManagementController >> createUser() >> started");
		userManagementService.createUser(createUserRequest);
		return new ResponseEntity<String>("User created successfully", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity<?> getUserDetails(String userName){
		GetUserDetailsResponseDto userResponse = userManagementService.getUserDetails(userName);
		return new ResponseEntity<GetUserDetailsResponseDto>(userResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/role", method = RequestMethod.POST	, consumes = "application/json")
	@ApiOperation(value = "Create Role", protocols = "http", notes = "Creating new Role.")
	public ResponseEntity<?> createRole(@Valid @RequestBody CreateRoleRequestDto createRoleRequest){
		log.info("UserManagementController >> createRole() >> started");
		userManagementService.createRole(createRoleRequest);
		return new ResponseEntity<String>("Role created successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity<?> getUserRoles(){		
		UserRolesResponseDto rolesResponse = userManagementService.getUserRoles();		
		return new ResponseEntity<UserRolesResponseDto>(rolesResponse, HttpStatus.OK);
	}
	
	public ResponseEntity<?> getUserQueues(){

		return null;
	}
	
}
