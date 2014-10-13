package com.tss.ocean.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Presents the control flow of the actions present inside the invoicing
 * operations
 * 
 * @author sumit bisht
 */
@Controller
public class InvoiceController {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

	/*
	 * Maps to the invoice filling form
	 */
	@RequestMapping(value = { "/invoice_entry.html" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView invoiceEntryDisplay() throws Exception {
		logger.info("Initializing the invoice entry view.");
		ModelAndView modelAndView = new ModelAndView("invoice_data_entry");
		return modelAndView;
	}
}
