package com.tss.ocean.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tss.ocean.idao.IItemDAO;
import com.tss.ocean.idao.IItemtypeDAO;
import com.tss.ocean.idao.IItemunitDAO;


@Controller
public class InventoryReport 
{

	
	
	 @Autowired
	 /*  29:    */   IItemtypeDAO itemTypeDAO;
	 /*  30:    */   @Autowired
	 /*  31:    */   IItemunitDAO itemunitDAO;
	 /*  32:    */   @Autowired
	 /*  33:    */   IItemDAO itemDAO;
	 /*  30: 42 */   private static final Logger logger = Logger.getLogger(InventoryReport.class.getName());

	 @RequestMapping(value={"/report.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})

	 public String report()
	 
	 {
		 return "report";
	 }
	 
	 public String itemByCatagory(@RequestParam("category")String catagory)
	 {
		 logger.log(Level.INFO, "Item for category="+catagory);
		 
		 itemDAO.getListByHQLQuery("from Item i where  i.category.name="+catagory);
		 
		return "categoryRep";
		 
	 }
	 
	 
	
	
	
	
}
