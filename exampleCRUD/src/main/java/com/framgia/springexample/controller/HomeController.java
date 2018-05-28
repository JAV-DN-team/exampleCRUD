package com.framgia.springexample.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	ApplicationContext applicationContext;
	
	@RequestMapping(value = { "/", "/homepage", "/login" }, method = RequestMethod.GET)
	public String home(Model model, Principal principal, 
			@RequestParam(name="error", required=false)String error) {

		if(principal != null) {
			return "redirect:/current-logging-in";
		}
		
		if (error != null && "true".equals(error)) {
			model.addAttribute("errorMsg", "Wrong username or password");
		}
		return "homepage";
	}
	
	@RequestMapping(value="/logging-out", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       if (auth.getPrincipal() != null) {
          new SecurityContextLogoutHandler().logout(request, response, auth);
       }
       return "redirect:/homepage";
    }
	
	@RequestMapping(value = { "/current-logging-in" }, method = RequestMethod.GET)
	public String currentLoggingIn(Model model, Principal principal) {
		
		if(principal == null) {
			return "redirect:/homepage";
		}
		return "currentLogginInPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
	public String test(Model model, Principal principal, 
			@RequestParam(name="error", required=false)String error) {
		return "test";
	}
	
}
