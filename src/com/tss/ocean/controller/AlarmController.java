package com.tss.ocean.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tss.ocean.dao.EmployeesDAO;
import com.tss.ocean.pojo.Employees;
import com.tss.ocean.pojo.Item;
import com.tss.ocean.service.IAlarmService;
import com.tss.ocean.service.IUserservice;

@Controller


public class AlarmController {

	

	@Autowired
	IUserservice userService;
	@Autowired
	IAlarmService alarmService ;
	@Autowired
	EmployeesDAO empDao;

	 @RequestMapping(value={"/alarm.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public ModelAndView itemAlarm( ArrayList<Item> list,HttpServletRequest request)
	     throws Exception
	   {
	     list= (ArrayList<Item>) alarmService.getAlarm();
		 
	     ModelAndView model = new ModelAndView("itemAlarm");
			model.addObject("list", list);
	    System.out.println("hhhhhhhhhhh"+list.size());
	     return model;
	   }
	
	
	 @RequestMapping(value={"/alarmEmployee.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	  public ModelAndView mployeeAlarm( ArrayList<Employees> list,HttpServletRequest request)
	     throws Exception
	   {
	     list= (ArrayList<Employees>) empDao.getAlarm();
		 
	     ModelAndView model = new ModelAndView("EmployeeAlarm");
			model.addObject("list", list);
	    System.out.println("hhhhhhhhhhh"+list.size());
	     return model;
	   }
	 
	
}
