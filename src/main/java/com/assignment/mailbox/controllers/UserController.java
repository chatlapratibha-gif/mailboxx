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

import com.assignment.mailbox.model.User;
import com.assignment.mailbox.model.UserLogin;
import com.assignment.mailbox.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userServices;
	String message;
	@GetMapping("/")
	public String userHome(Model model)
	{
		
		model.addAttribute("user", new UserLogin());
		return "user";
	}
	
	@PostMapping("/userlogin")
	public String studentLogin(@ModelAttribute("user") UserLogin userLogin,BindingResult result, Model model,HttpSession session)
	{
	
		if(result.hasErrors())
		{
			return "user";
		}
		else {
		int status = userServices.login(userLogin);
		
		if(status==1)
		{
			message="you are not registered";
			model.addAttribute("message",message);
			return "failure";
	    }
		
		else if(status==2)
		{
			message="You are Not yet activated Please wait for admin confirmation";	
			model.addAttribute("message", message);
			return "failure";}
		
		else if(status==3)
		{
			session.setAttribute("username",userLogin.getUsername());
			return "userhome";
		}
		else
		{
			model.addAttribute("message","Invalid Username OR password");
			return "user";
		}
		
		}
	}
	
	
	@GetMapping("/register")
	public String userRegisterForm(Model model)
	{
		User user = new User();
		model.addAttribute("userreg", user);
		
		return "userregistration";
	}

	
	@PostMapping("/userregistration")
	public String registerStudent(@Valid @ModelAttribute("userreg") User user,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "userregistration";
		}
		
		else {
			UserLogin userlogin = new UserLogin();
			user.setStatus("no");
			model.addAttribute("user",userlogin);
		
		int res = userServices.createUser(user);
		if(res==0)
		{
			model.addAttribute("message", user.getFirstname().concat(user.getLastname()).toUpperCase()+" You are already registered");
		
		
		}
		else if(res==1)
		{
			model.addAttribute("message", user.getFirstname().concat(user.getLastname()).toUpperCase()+"Congrats your registration is successfull");
		
		
		}
		else
		{
			model.addAttribute("message", "Some thing went wrong");
		
		}
		return "user";
		}
	
	}
	@GetMapping("/userLogout")
	public String adminLogOut(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/";
	}
	@GetMapping("/searchusers")
	public String getAllStudents(Model model,HttpSession session)
	{
		List<User> userList=userServices.userList();
		model.addAttribute("usersList", userList);
		return "userhome";
	}
}