package com.tss.ocean.controller;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tss.ocean.idao.IAccountsDAO;
import com.tss.ocean.idao.IEmployeeCategoryDAO;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.idao.IInvoiceDAO;
import com.tss.ocean.idao.IItemDAO;
import com.tss.ocean.idao.IPurchaseApproverDAO;
import com.tss.ocean.idao.IPurrequisitionDAO;
import com.tss.ocean.idao.IPurrequisitiondtDAO;
import com.tss.ocean.pojo.Accounts;
import com.tss.ocean.pojo.Employees;
import com.tss.ocean.pojo.Invoice;
import com.tss.ocean.pojo.Purrequisition;

/**
 * Presents the control flow of the actions present inside the invoicing
 * operations
 * 
 * @author sumit bisht
 */
@Controller
public class financeMenuControllers {

	private static final Logger logger = LoggerFactory.getLogger(financeMenuControllers.class);
	
	@Autowired
	IInvoiceDAO invoiceDAO;
	
	

	/*  47:    */   @Autowired
	/*  48:    */   private IPurchaseApproverDAO purchaseApproversDAO;
	/*  49:    */   @Autowired
	/*  50:    */   private IPurrequisitionDAO purrequisitionDAO;


	/*  51:    */   @Autowired
	/*  52:    */   private IPurrequisitiondtDAO purrequisitiondtDAO;
	/*  53:    */   @Autowired
	/*  54:    */   private IAccountsDAO accountsDAO;
	/*  55:    */   @Autowired
	/*  56:    */   private MessageSource messageSource;
	/*  57:    */   @Autowired
	/*  58:    */   private IItemDAO itemDAO;
	/*  59:    */   @Autowired
	/*  60:    */   private IEmployeesDAO employeesDAO;
	/*  61:    */   @Autowired
	/*  62:    */   IEmployeeCategoryDAO employeeCategoryDAO;
	
	/*
	 * Maps to the invoice filling form
	 */
	/*
	 * Maps to the incoming data from the invoice form
	 */
	
	/*
	 * Provides the report of the cash/box collections of the different reports
	 */
	
	/*
	 * Provides the report of the bank collections of the different reports
	 */
	
	/*
	 * Provides the report of the cash/box collections within finance section
	 */
	@RequestMapping(value = { "/incomming.html" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView listCashCollectionsOnFinanceMenu(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale) throws Exception {
		logger.info("Starting the save of data.");
		List<Invoice> invoices = this.invoiceDAO.getList();
		logger.info("returned with "+invoices.size()+" cash invoices");
		float total = 0;
		for(Invoice i:invoices)
		{
			total=total+(i.getGrossAmount().floatValue());
		}
		
		ModelAndView mav = new ModelAndView("incomming_outgoing_list");
		mav.getModelMap().put("useFinanceMenus", "true");
		mav.getModelMap().put("invoices", invoices);
		mav.getModelMap().put("title_text", "Cash based invoice");
		mav.getModelMap().put("total", total);
		return mav;
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value={"/outgoing.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	/* 222:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
	/* 223:    */   public ModelAndView approvedOrders(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale, Principal principal)
	/* 224:    */     throws Exception
	/* 225:    */   {
	/* 226:244 */     logger.debug("purchase_request called.");
	/* 227:245 */     ModelAndView mav = new ModelAndView("outgoing_finance-list");
	/* 228:246 */     List<Accounts> accountsList = this.accountsDAO.getList();
	/* 229:    */     
	/* 230:248 */     String loggedinusername = principal.getName();
	/* 231:249 */     Employees employees = (Employees)this.employeesDAO.getRecordByKeyandValue("username", loggedinusername);
	/* 232:250 */     int userid = 0;
	/* 233:251 */     if (employees != null) {
	/* 234:252 */       userid = employees.getId().intValue();
	/* 235:    */     }
	/* 236:255 */     HashMap<Integer, String> accountMap = new HashMap(accountsList.size());
	/* 237:256 */     for (Accounts account : accountsList) {
	/* 238:257 */       accountMap.put(account.getId(), account.getName());
	/* 239:    */     }
	/* 240:262 */     mav.getModelMap().put("purrequisitionList", this.purrequisitionDAO.getListByCondition("t where t.approvalStatus=1"));
	/* 241:    */     float total = 0;
	for(Purrequisition i: this.purrequisitionDAO.getListByCondition("t where t.approvalStatus=1"))
	{
		total=total+(i.getPrice().floatValue());
	}
	/* 242:    */ 
	/* 243:    */ 
	/* 244:266 */     mav.getModelMap().put("accountMap", accountMap);
	mav.getModelMap().put("totalval", total);
	/* 245:267 */     /*mav.getModelMap().put("statusList", getStatusList(locale));*/
	/* 246:268 */     if (success != null) {
	/* 247:269 */       mav.getModelMap().put("success", success);
	/* 248:    */     }
	/* 249:271 */     if (error != null) {
	/* 250:272 */       mav.getModelMap().put("error", error);
	/* 251:    */     }
	/* 252:274 */     return mav;
	/* 253:    */   }

	
	
	
	
	/*
	 * Provides the report of the bank collections within finance section
	 */
	/*@RequestMapping(value = { "/bank_vouchers.html" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView listBankCollectionsOnFinanceMenu(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale) throws Exception {
		logger.info("Starting the save of data.");
		List<Invoice> invoices = this.invoiceDAO.getCollectionByType(true);
		logger.info("returned with "+invoices.size()+" cash invoices");
		ModelAndView mav = new ModelAndView("invoice_list");
		mav.getModelMap().put("useFinanceMenus", "true");
		mav.getModelMap().put("invoices", invoices);
		mav.getModelMap().put("title_text", "Bank based invoice");
		return mav;
	}*/
	/*
	 * Makes the invoice editable
	 */
	
	
	/*
	 * Updates the invoice data and informs the user of the process
	 */
	
}
