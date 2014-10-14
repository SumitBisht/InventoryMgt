package com.tss.ocean.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	 public ModelAndView report()
	 
	 {
		 
		 ModelAndView model = new ModelAndView("report");
			
		 List l=itemTypeDAO.getList();
		
		 
		 model.addObject("itemTypeList",l );
		 return model;
	 }
	 
	 
	 
	 
	 @RequestMapping(value={"/searchitembyname.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})

	 public ModelAndView reportByName( @RequestParam String query)
	 
	 {
		 

		 System.out.println("Hello Search By Name ");
		 ModelAndView model = new ModelAndView("report");
		
		 List l=itemDAO.getListByHQLQuery("from Item i where  i.name like '%"+query+"%'");
 List l2=itemTypeDAO.getList();
		
		 
		 model.addObject("itemTypeList",l2 );
		 
		 model.addObject("itemList",l );
		 
		 return model;
	 }
	 
	 
	 
	 @RequestMapping(value={"/searchitembyCategory.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})

	 public ModelAndView itemByCatagory(@RequestParam("category")String catagory)
	 {
		 logger.log(Level.INFO, "Item for category="+catagory);
		 ModelAndView model = new ModelAndView("report");
		 
		 
		 List l= itemDAO.getListByHQLQuery("from Item i where  i.categoryid.name like '%"+catagory+"%'");
		
		 System.out.println("KKKKKKKKKKKKKKKKKKKK"+l.size());
 List l2=itemTypeDAO.getList();
		
		 
		 model.addObject("itemTypeList",l2 );
		 model.addObject("itemList",l );
		 return model;
		 
	 }
	 
	 
	 @RequestMapping(value={"/searchitembyStock.htm"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})

	 public ModelAndView itemByStock(@RequestParam("stock")int stock,@RequestParam("sign") int sign )
	 {
		 ModelAndView model = new ModelAndView("report");
		 String q = null;
		 switch(sign)
		 {
		 case 1:  q="i.currstock="+stock;
		 break;
		 case 2:  q="i.currstock < "+stock;
		 break;
		 case 3:  q="i.currstock > "+stock;
		 break;
		 
			 
		 
		 }
		 
		 
		 
		 
		 List l= itemDAO.getListByHQLQuery("from Item i where  "+q);
		
		 System.out.println("KKKKKKKKKKKKKKKKKKKK"+l.size());
 List l2=itemTypeDAO.getList();
		
		 
		 model.addObject("itemTypeList",l2 );
		 model.addObject("itemList",l );
		 return model;
		 
	 }
	 
	 
	 
	
	
	
	
	
}
