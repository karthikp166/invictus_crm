package com.invictus.crm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.invictus.crm.dto.CreateRoleRequestDto;
import com.invictus.crm.dto.CreateUserRequestDto;
import com.invictus.crm.dto.GetUserDetailsResponseDto;
import com.invictus.crm.dto.UserRolesResponseDto;
import com.invictus.crm.entity.Role;
import com.invictus.crm.entity.User;
import com.invictus.crm.repository.RoleRepository;
import com.invictus.crm.repository.UserRepository;
import com.invictus.crm.service.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void createRole(CreateRoleRequestDto createRoleRequest) {	
		log.info("UserManagementController >> createRole() >> started");
		if(null!= getRoleByName(createRoleRequest.getRoleName()))
			throw new BadRequestException("Role already exists.");
		roleRepository.save(prepareCreateRoleRequest(createRoleRequest));
	}

	@Override
	public void createUser(CreateUserRequestDto createUserRequest) {
		log.info("UserManagementController >> createUser() >> started");
		if(null != userRepository.getUserDetails(createUserRequest.getUserName()))
			throw new BadRequestException("User already exists.");		
		userRepository.save(prepareCreateUserRequest(createUserRequest));
	}

	@Override
	public UserRolesResponseDto getUserRoles() {
		log.info("UserManagementController >> getUserRoles() >> started");
		List<Role> roles = roleRepository.getRoles();
		UserRolesResponseDto responseDto = new UserRolesResponseDto();
		if(!CollectionUtils.isEmpty(roles)) {
			responseDto.setRoles(roles.stream().map(role -> role.getName()).collect(Collectors.toList()));
		}
		return responseDto;
	}
	
	@Override
	public GetUserDetailsResponseDto getUserDetails(String userName) {
		log.info("UserManagementController >> getUserDetails() >> started");
		User userEntity = userRepository.getUserDetails(userName);
		if(null == userEntity)
			throw new NotFoundException("user doesnt exists.");
		return prepareUserDetailsResponse(userEntity);
	}
	
	private Role prepareCreateRoleRequest(CreateRoleRequestDto requestDto) {
		Role role = new Role();
		role.setName(requestDto.getRoleName());		
		return role;
	}
	
	private User prepareCreateUserRequest(CreateUserRequestDto requesDto) {
		User user = new User();
		user.setFirstName(requesDto.getFirstName());
		user.setLastName(requesDto.getLastName());
		user.setUserName(requesDto.getUserName());
		user.setPassword(requesDto.getPassword());
		user.setEmail(requesDto.getEmail());
		user.setCreatedTimestamp(new Date());
		user.setRole(getRoleByName(requesDto.getRole()));
		return user;
	}
	
	private Role getRoleByName(String roleName) {
		return roleRepository.getRoleByName(roleName);
	}
	
	private GetUserDetailsResponseDto prepareUserDetailsResponse(User userEntity) {
		GetUserDetailsResponseDto responseDto = new GetUserDetailsResponseDto();
		responseDto.setFirstName(userEntity.getFirstName());
		responseDto.setLastName(userEntity.getLastName());
		responseDto.setUserName(userEntity.getUserName());
		responseDto.setEmail(userEntity.getEmail());
		responseDto.setRole(userEntity.getRole().getName());
		return responseDto;
	}

}
