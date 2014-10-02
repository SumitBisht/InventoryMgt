package com.tss.ocean.controller;

import java.util.Date;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.tss.ocean.pojo.Users;
import com.tss.ocean.service.IUserservice;

@Controller


public class RegistrationController {

	

	@Autowired
	IUserservice userService;
	
	

	 @RequestMapping(value={"/register/register.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public String registration(@ModelAttribute("user") Users user, HttpServletRequest request)
	     throws Exception
	   {
	    
	     return "register";
	   }
	
	
	 
	 @RequestMapping(value={"/register/registerAction.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	  public String register(@ModelAttribute("user") Users user, HttpServletRequest request)
	     throws Exception
	   {
	    
		 System.out.println(user.getName()+"...............................................");
		 user.setCreatedat(new Date());
		 userService.insert(user);
	     return "redirect:/login.html";
	   }
	 
	
}
