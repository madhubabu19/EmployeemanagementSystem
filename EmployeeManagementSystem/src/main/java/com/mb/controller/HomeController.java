package com.mb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mb.entity.Employee;
import com.mb.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private EmpService empService;
	
	
	@GetMapping("/")
	public String  index(Model m){
		List<Employee> list=empService.getAllEmp();
		m.addAttribute("empList",list);
		
		return "index";
	}
	@GetMapping("/loadEmpSave")
	public String  loadEmpSave() {
		return "emp_save";
	}
	@GetMapping("/EditEmpSave/{id}")
	public String  editEmpSave(@PathVariable int id ,Model m) {
		//System.out.println(id);
		Employee emp=empService.getEmpById(id);
		m.addAttribute("emp",emp);
		return "edit_emp";
	}
	@PostMapping("/saveEmp")
	public String saveEmpSave(@ModelAttribute Employee emp,HttpSession session) {
		System.out.println (emp);
		Employee newEmp=empService.saveEmp(emp);
		if(newEmp!= null)
		{
			session.setAttribute("msg","successfully registered");
		}
		else {
			session.setAttribute("msg", "som ething wrong on server ");
		}
		return "redirect:/loadEmpSave";
	}
	
	@PostMapping("/updateEmpDtls")
	public String updateEmp(@ModelAttribute Employee emp,HttpSession session) {
		//System.out.println (emp);
		Employee updateEmp=empService.saveEmp(emp);
		if(updateEmp!= null)
		{
			session.setAttribute("msg"," updated successfully  ");
		}
		else {
			session.setAttribute("msg", "som ething wrong on server ");
		}
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmp/{id}")
	public String delete(@PathVariable int id,HttpSession session)
	{
		boolean f=empService.deleteEmplyee(id);
		if(f) {
			session.setAttribute("msg","delete Successfully");
		}
		else {
			session.setAttribute("msg","something wrong on server ");
		}
		return "redirect:/";
		
	}
	
	

}
