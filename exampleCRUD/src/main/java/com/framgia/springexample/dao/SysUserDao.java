package com.framgia.springexample.dao;

import com.framgia.springexample.model.entity.SysUser;

public interface SysUserDao {
	public SysUser selectbyUsername(String username);
}
