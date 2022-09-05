package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.model.book;
import com.springboot.service.bookserviceimpl;

@Controller
public class bookcontroller {
	

		
		@Autowired
		private bookserviceimpl employeeService;
		
		
		@GetMapping("/")
		public String viewhomePage(Model model)
		{
			model.addAttribute("listEmployees", employeeService.getAllEmployees());
			return "index";
		}
		
		@GetMapping("/showNewEmployeeForm")
		public String showNewEmployeeForm(Model model)
		{
			book employee = new book();
			model.addAttribute("employee",employee);
			return "new_employee";
		}
		
		@PostMapping("/saveEmployee")
		public String saveEmployee(@ModelAttribute("employee") book employee) {
		     // save employee to database
		     employeeService.saveEmployee(employee);
		     return "redirect:/";
		 }
		
		@GetMapping("/showFormForUpdate/{id}")
		public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		 
		 // get employee from the service
		book employee = employeeService.getEmployeeById(id);
		 
		 // set employee as a model attribute to pre-populate the form
		 model.addAttribute("employee", employee);
		 return "update_employee";
		}
		
		 @GetMapping("/deleteEmployee/{id}")
		    public String deleteEmployee(@PathVariable(value = "id") long id) {

		        // call delete employee method 
		        this.employeeService.deleteEmployeeById(id);
		        return "redirect:/";
		    }

	}

