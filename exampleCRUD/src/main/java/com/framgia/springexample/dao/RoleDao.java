package com.framgia.springexample.dao;

import java.util.List;

import com.framgia.springexample.model.entity.Role;

public interface RoleDao {
	public List<Role> selectByUsername(String username);
}
