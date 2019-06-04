package com.invictus.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.invictus.crm.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query(value = "SELECT * FROM role WHERE name=?1",  nativeQuery = true)
	Role getRoleByName(String roleName);
	
	@Query(value = "SELECT * FROM role",  nativeQuery = true)
	List<Role> getRoles();
}
