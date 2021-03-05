package com.phase3.project.Controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.phase3.project.Entity.User;
import com.phase3.project.Service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String displayHome() {
	return "home";	
	}
	
	@GetMapping("/home")
	public String navigateHome() {
	return "home";	
	}
	
	@GetMapping("/login")
	public String userLogin(Model model)
	{
		User user=new User();
		model.addAttribute("user", user);
		return "login";
	}
	
	@PostMapping("/login")
	public String processUserLogin(@Valid @ModelAttribute User user, BindingResult result,HttpSession session, Model model)
	{
		User us=userService.getByUserPassword(user.getUsername(), user.getPassword());
        if(us!=null) {
        	session.setAttribute("user", us);
        	return "Welcome";
        }
        return "login-err";
	}
	
	@GetMapping("/logout")
	public String goBack(HttpSession session,Model model)
	{
		session.removeAttribute("user");
		return "home";
	}
	
	@GetMapping("/Register")
	public String userRegister(Model model)
	{
		User user=new User();
		model.addAttribute("user", user);
		return "Register";
	}
	
	@PostMapping("/Register")
	public String addNewCustomer(@Valid @ModelAttribute User user,BindingResult result,Model model)
	{
		if (result.hasErrors()) {
			return "Register";
		}
        userService.save(user);
		model.addAttribute("user", user);
		return "Registersuccess";
	}

}
