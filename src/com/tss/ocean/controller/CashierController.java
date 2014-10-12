package com.tss.ocean.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CashierController

{
	 @RequestMapping(value={"/cashierHome.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
public String cashier()
{
	return "invoice";
		 
}

}
