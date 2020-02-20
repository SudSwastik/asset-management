package com.sudarshan.sud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudarshan.sud.entities.Asset;
import com.sudarshan.sud.exception.RecordNotFoundException;
import com.sudarshan.sud.service.AssetService;

@Controller
@RequestMapping("/")
public class AssetController 
{
    @Autowired
    AssetService service;
    
    @RequestMapping
    public String getLoginPage() 
    {
        
        return "redirect:/login";
    }
 
    
    @RequestMapping(path = "/viewassetlist")
    public String getAllEmployees(Model model) 
    {
        List<Asset> list = service.getAllEmployees();
 
        model.addAttribute("employees", list);
        model.addAttribute("title","View Asset List");
        return "list-asset";
    }
 
    
//    @RequestMapping(path = "/addasset")
//    public String getAllEmployees(Model model) 
//    {
//        List<Asset> list = service.getAllEmployees();
// 
//        model.addAttribute("employees", list);
//        return "add-edit-asset";
//    }
 
    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) 
                            throws RecordNotFoundException 
    {
        if (id.isPresent()) {
            Asset entity = service.getEmployeeById(id.get());
            model.addAttribute("employee", entity);
            model.addAttribute("title","Update Asset List");
        } else {
            model.addAttribute("employee", new Asset());
        }
        return "add-edit-asset.html";
    }
     
    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id) 
                            throws RecordNotFoundException 
    {
        service.deleteEmployeeById(id);
        return "redirect:/";
    }
 
    @RequestMapping(path = "/addasset", method = RequestMethod.POST)
    public String createOrUpdateEmployee(@Valid Asset employee, Errors errors, Model model) 
    {
    	if (errors.hasErrors()) {
			return "add-edit-asset";
			
		} else {
			service.createOrUpdateEmployee(employee);
			return "home";
//			prjRep.save(project); 
//			model.addAttribute("message", "Registration successfully...");
//			return "home";
		}
//        service.createOrUpdateEmployee(employee);
//        return "home";
    }
}