package com.framgia.springexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.framgia.springexample.form.EmployeeForm;
import com.framgia.springexample.form.EmployeeListForm;
import com.framgia.springexample.service.EmployeeService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "/create-employee", method = RequestMethod.GET)
	public String create(Model model) {
		
		model.addAttribute("employeeForm", new EmployeeForm() );
		
		return "createNewEmployeePage";
	}
	
	@RequestMapping(value = "/create-employee", method = RequestMethod.POST)
	public String createAndSave(Model model, @ModelAttribute("employeeForm")EmployeeForm employeeForm) {
		
		employeeService.createOrUpdate(employeeForm);
		
		return "redirect:/employee/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, EmployeeListForm employeeListForm) {
		
		employeeListForm = employeeService.findAll(employeeListForm);
		
		model.addAttribute("employeeListForm", employeeListForm);
		
		return "listEmployeePage";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String list(Model model, @RequestParam("employeeId")String employeeId) {
		
		employeeService.deleteById(Integer.valueOf(employeeId));
		
		return "redirect:/employee/list";
	}
	
}
