package com.sudarshan.sud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sudarshan.sud.dao.ProjectRepository;
import com.sudarshan.sud.entities.Employee;

@Controller
@RequestMapping("/")
public class EmployeeController {

	@Autowired
	ProjectRepository prjRep;
	
	@RequestMapping("/addemployee")
	public String displayProjectForm(Model model) {
		Employee aproject = new Employee();
		model.addAttribute("employee",aproject);
		return "new-employee";
	}
	
	@RequestMapping("/save")
	public String createProject( @Valid Employee project, Errors errors, Model model) {
		
		if (errors.hasErrors()) {
			return "new-employee";
		} else {
			prjRep.save(project); 
			model.addAttribute("message", "Registration successfully...");
			return "home";
		}
		
	}
	
}
