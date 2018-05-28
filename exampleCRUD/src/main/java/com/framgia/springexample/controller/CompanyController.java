package com.framgia.springexample.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_USER')")
public class CompanyController {
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2(Model model) {
		
		return "test2";
	}
	
}
