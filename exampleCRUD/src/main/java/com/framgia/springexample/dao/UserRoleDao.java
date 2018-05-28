package com.framgia.springexample.dao;

import java.util.List;

import com.framgia.springexample.model.entity.UserRole;

public interface UserRoleDao {
	public List<UserRole> selectByUsername(String username); 
	
}
