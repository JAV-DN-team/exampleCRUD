package com.framgia.springexample.service.baseservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.framgia.springexample.dao.RoleDao;
import com.framgia.springexample.dao.SysUserDao;
import com.framgia.springexample.model.entity.Role;
import com.framgia.springexample.model.entity.SysUser;

@Service("userDetailsService")
public class CustomUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	SysUserDao sysUserDao;
	
	@Autowired
	RoleDao roleDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser sysUser = sysUserDao.selectbyUsername(username);
		
		if (sysUser == null) {
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		
		sysUser.setRoles(roleDao.selectByUsername(username));
		return (UserDetails)new User(sysUser.getUsername(), sysUser.getPassword(), getGrantedAuthorities(sysUser));
	}

	private List<GrantedAuthority> getGrantedAuthorities(SysUser sysUser) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : sysUser.getRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		}
		return authorities;
	}
}
