package com.tss.ocean.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tss.ocean.idao.IInvoiceDAO;
import com.tss.ocean.pojo.Invoice;

@Controller
public class CashierController

{
	@Autowired
	IInvoiceDAO invoiceDAO;
	
	@RequestMapping(value = { "/cashierHome.htm" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String cashier() {
		return "invoice";

	}

	@RequestMapping(value = { "/breakfast.html" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView breakfastVoucherEntry() throws Exception {
		return mealEntryViewProvider("breakfast");
	}
	@RequestMapping(value = { "/lunch.html" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView lunchVoucherEntry() throws Exception {
		return mealEntryViewProvider("lunch");
	}
	@RequestMapping(value = { "/dinner.html" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView dinnerVoucherEntry() throws Exception {
		return mealEntryViewProvider("dinner");
	}
	
	/*
	 * Handles the provided data from the meals entry page
	 */
	@RequestMapping(value = { "/addMealVoucher.html" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public ModelAndView saveInvoiceData(@ModelAttribute("invoice") @Valid Invoice invoice, BindingResult result, ModelMap model, Locale locale) throws Exception {
		String status="";
//		if(!result.hasErrors()){
			status = "received the invoice data ";
			int i = (Integer)this.invoiceDAO.insert(invoice).intValue();
			System.out.println("Data inserted successfully with value: "+i);
			if(invoice.getMealType()!=null)
				return mealEntryViewProvider(invoice.getMealType());
//		}else{
//			status = "Received errors on submitting the invoice form.";
//		}
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("obj>> " + invoice + " , status: "+status);
		return new ModelAndView("invoice_data_entry");
	}
	

	ModelAndView mealEntryViewProvider(String mealName){
		return mealEntryViewProvider(mealName, "Enter the details for "+mealName);
	}
	/*
	 * Provides a customized form for entry of meal related vouchers.
	 */
	ModelAndView mealEntryViewProvider(String mealName, String message){
		Invoice invoice = new Invoice();
		ModelAndView modelAndView = new ModelAndView("meal_entry");
		modelAndView.getModelMap().put("invoice", invoice);
		modelAndView.getModelMap().put("flash", message);
		modelAndView.getModelMap().put("meals", new String[]{"breakfast", "lunch", "dinner"});
		modelAndView.getModelMap().put("mealtype", mealName);
		return modelAndView;		
	}

}
