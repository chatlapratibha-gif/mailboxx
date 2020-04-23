package com.assignment.mailbox.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.assignment.mailbox.model.Admin;
import com.assignment.mailbox.model.User;
import com.assignment.mailbox.services.AdminService;
import com.assignment.mailbox.services.UserService;

@Controller
@RequestMapping(value ="/admin")
public class Admincontroller {
	
	@Autowired
	private AdminService adminServices;
	@Autowired
	private UserService userservices;
	
	
	@GetMapping("/")
	public String adminLogin(Model model)
	{
	  Admin admin = new Admin();
	  model.addAttribute("admin", admin);
	  return "admin";
	}

	
	@PostMapping("/adminlogin")
	public String VerifyAdminLogin(@Valid @ModelAttribute("admin") Admin admin, BindingResult result, Model model, HttpSession session)
	{
		
		if(result.hasErrors())
		{
			return "admin";
		}
		else 
		{
		
		if(adminServices.login(admin))
		{
			session.setAttribute("adminusername", admin.getUsername());
			
			return "adminhome";
		}
		
		model.addAttribute("message", "Invalid UserName or Password");
		
		return "failure";
		}
	}
	@GetMapping("/viewusers")
	public String getAllUsers(Model model,HttpSession session)
	{
		List<User> userList=userservices.userList();
		model.addAttribute("usersList", userList);
		return "adminhome";
	}
	@GetMapping("/acceptuserregisteration")
	public String showUsers(Model model)
	{
		List<User> userList=userservices.userList();
		
		model.addAttribute("userList", userList);
		return "adminhome";
	}
	@GetMapping("/deleteusers")
	public String delUsers(Model model)
	{
		List<User> userList=userservices.userList();
		
		model.addAttribute("userdelList", userList);
		return "adminhome";
	}
	@GetMapping("/adminLogout")
	public String adminLogOut(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/";
	}
	@GetMapping("activate")
	public String activate(@RequestParam("id")String username) {
		boolean b1=adminServices.activate(username);
		if(b1)
		{
			return "adminhome";
		}
		return "failure";
	}
	@GetMapping("deactivate")
	public String deactivate(@RequestParam("id")String username) {
		boolean b1=adminServices.deactivate(username);
		if(b1)
		{
			return "adminhome";
		}
		return "failure";
	}
	@GetMapping("delete")
		public String delete(@RequestParam("id")String username) {
		adminServices.delete(username);
		return "adminhome";
		
		
	}
}
