/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.tss.ocean.idao.IBankDAO;
/*   4:    */ import com.tss.ocean.idao.ICountryDAO;
/*   5:    */ import com.tss.ocean.pojo.Bank;
/*   6:    */ import com.tss.ocean.pojo.Country;
/*   7:    */ import com.tss.ocean.util.Utilities;
/*   8:    */ import java.io.PrintStream;
/*   9:    */ import java.util.HashMap;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.Locale;
/*  12:    */ import java.util.Map;
/*  13:    */ import java.util.logging.Level;
/*  14:    */ import java.util.logging.Logger;
/*  15:    */ import javax.servlet.http.HttpServletRequest;
/*  16:    */ import javax.validation.Valid;
/*  17:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  18:    */ import org.springframework.context.MessageSource;
/*  19:    */ import org.springframework.stereotype.Controller;
/*  20:    */ import org.springframework.ui.ModelMap;
/*  21:    */ import org.springframework.validation.BindingResult;
/*  22:    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*  23:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  24:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  25:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  26:    */ import org.springframework.web.servlet.ModelAndView;
/*  27:    */ 
/*  28:    */ @Controller
/*  29:    */ public class BankController
/*  30:    */ {
/*  31: 40 */   private static final Logger logger = Logger.getLogger(ViewController.class.getName());
/*  32:    */   @Autowired
/*  33:    */   private IBankDAO bankDAO;
/*  34:    */   @Autowired
/*  35:    */   private ICountryDAO countryDAO;
/*  36:    */   @Autowired
/*  37:    */   private MessageSource messageSource;
/*  38:    */   
/*  39:    */   @RequestMapping(value={"/add-bank.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  40:    */   public ModelAndView add_bank_get(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/*  41:    */     throws Exception
/*  42:    */   {
/*  43: 55 */     logger.log(Level.FINE, "add-bank called.");
/*  44: 56 */     ModelAndView mav = new ModelAndView("add_bank");
/*  45: 57 */     Bank bank = new Bank();
/*  46: 58 */     if (success != null) {
/*  47: 59 */       mav.getModelMap().put("success", success);
/*  48:    */     }
/*  49: 61 */     if (error != null) {
/*  50: 62 */       mav.getModelMap().put("error", error);
/*  51:    */     }
/*  52: 64 */     mav.getModelMap().put("countryList", this.countryDAO.getList());
/*  53: 65 */     System.out.println("co" + this.countryDAO.getList());
/*  54: 66 */     mav.getModelMap().put("bank", bank);
/*  55: 67 */     return mav;
/*  56:    */   }
/*  57:    */   
/*  58:    */   @RequestMapping(value={"/add-bank.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  59:    */   public ModelAndView add_bank_post(@ModelAttribute("purorder") @Valid Bank bank, BindingResult result, ModelMap model, Locale locale)
/*  60:    */     throws Exception
/*  61:    */   {
/*  62: 75 */     logger.log(Level.FINE, "add-bank-post called.");
/*  63: 76 */     if (!result.hasErrors())
/*  64:    */     {
/*  65: 77 */       int insertResult = ((Integer)this.bankDAO.insert(bank)).intValue();
/*  66: 78 */       if (insertResult > 0)
/*  67:    */       {
/*  68: 79 */         System.out.println("Bank Added");
/*  69: 80 */         logger.log(Level.INFO, "Bank Added Successfully with id={0}", Integer.valueOf(insertResult));
/*  70: 81 */         return new ModelAndView("redirect:add-bank.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "bank.add.success", locale));
/*  71:    */       }
/*  72: 84 */       logger.log(Level.WARNING, "Error occurred inserting bank:{0}", bank.toString());
/*  73: 85 */       model.put("countryList", this.countryDAO.getList());
/*  74: 86 */       return new ModelAndView("purchase_order", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "bank.add.error", locale));
/*  75:    */     }
/*  76: 90 */     logger.log(Level.WARNING, "Bank values are not valid:", bank.toString());
/*  77: 91 */     model.put("countryList", this.countryDAO.getList());
/*  78: 92 */     return new ModelAndView("purchase_order", model);
/*  79:    */   }
/*  80:    */   
/*  81:    */   @RequestMapping(value={"/bank.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  82:    */   public ModelAndView getBanks(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, Locale locale)
/*  83:    */     throws Exception
/*  84:    */   {
/*  85:100 */     logger.info("fetch Banks called.");
/*  86:101 */     ModelAndView mav = new ModelAndView("banks-list");
/*  87:102 */     List<Bank> bankList = this.bankDAO.getList();
/*  88:103 */     System.out.println(bankList.size());
/*  89:104 */     mav.getModelMap().put("bankList", bankList);
/*  90:    */     
/*  91:106 */     List<Country> countryList = this.countryDAO.getList();
/*  92:107 */     Map<Integer, String> countryMap = new HashMap(countryList.size());
/*  93:108 */     for (Country c : countryList) {
/*  94:109 */       countryMap.put(c.getId(), c.getName());
/*  95:    */     }
/*  96:111 */     mav.getModelMap().put("countryMap", countryMap);
/*  97:    */     
/*  98:113 */     return mav;
/*  99:    */   }
/* 100:    */   
/* 101:    */   @RequestMapping(value={"/edit-bank.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 102:    */   public ModelAndView edit_bank_get(@RequestParam("id") int id, Locale locale, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 103:    */     throws Exception
/* 104:    */   {
/* 105:121 */     logger.log(Level.FINE, "edit-bank called.");
/* 106:    */     
/* 107:123 */     Bank bank = (Bank)this.bankDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 108:    */     ModelAndView mav;
/* 109:124 */     if (bank != null)
/* 110:    */     {
/* 111:125 */        mav = new ModelAndView("add_bank");
/* 112:126 */       mav.getModelMap().put("bank", bank);
/* 113:127 */       mav.getModelMap().put("countryList", this.countryDAO.getList());
/* 114:    */     }
/* 115:    */     else
/* 116:    */     {
/* 117:129 */       mav = new ModelAndView("redirect:add-bank.html");
/* 118:    */     }
/* 119:131 */     if (success != null) {
/* 120:132 */       mav.getModelMap().put("success", success);
/* 121:    */     }
/* 122:134 */     if (error != null) {
/* 123:135 */       mav.getModelMap().put("error", error);
/* 124:    */     }
/* 125:137 */     return mav;
/* 126:    */   }
/* 127:    */   
/* 128:    */   @RequestMapping(value={"/edit-bank.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 129:    */   public ModelAndView edit_bank_post(@ModelAttribute("bank") @Valid Bank bank, BindingResult result, ModelMap model, Locale locale, HttpServletRequest request)
/* 130:    */     throws Exception
/* 131:    */   {
/* 132:145 */     logger.log(Level.FINE, "edit-bank-post called.");
/* 133:146 */     if (!result.hasErrors())
/* 134:    */     {
/* 135:147 */       int updateResult = this.bankDAO.update(bank);
/* 136:148 */       if (updateResult > 0)
/* 137:    */       {
/* 138:149 */         logger.log(Level.INFO, "bank updated Successfully with id={0}", Integer.valueOf(updateResult));
/* 139:150 */         return new ModelAndView("redirect:bank.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "purorder.update.success", locale));
/* 140:    */       }
/* 141:153 */       logger.log(Level.WARNING, "Error occurred updating purchase_order:{0}", bank.toString());
/* 142:154 */       model.put("countryList", this.countryDAO.getList());
/* 143:155 */       return new ModelAndView("add_bank", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "purorder.update.error", locale));
/* 144:    */     }
/* 145:159 */     logger.log(Level.WARNING, "Purchase_order values are not valid:", bank.toString());
/* 146:160 */     model.put("countryList", this.countryDAO.getList());
/* 147:161 */     return new ModelAndView("purchase_order", model);
/* 148:    */   }
/* 149:    */   
/* 150:    */   @RequestMapping({"/delete-bank.html"})
/* 151:    */   @ResponseBody
/* 152:    */   public boolean delete_bank(@RequestParam("id") int id)
/* 153:    */     throws Exception
/* 154:    */   {
/* 155:168 */     logger.log(Level.FINE, "delete-bank called.");
/* 156:169 */     Bank bank = (Bank)this.bankDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 157:170 */     if (bank != null)
/* 158:    */     {
/* 159:171 */       int updateResult = this.bankDAO.delete(bank);
/* 160:172 */       if (updateResult > 0)
/* 161:    */       {
/* 162:173 */         logger.log(Level.INFO, "Bank with id {0} deleted successfully", bank.getId());
/* 163:174 */         return true;
/* 164:    */       }
/* 165:176 */       logger.log(Level.WARNING, "Error occurred while deleting bank with id {0}", bank.getId());
/* 166:177 */       return false;
/* 167:    */     }
/* 168:180 */     logger.log(Level.INFO, "Bank with id {0} is already deleted", Integer.valueOf(id));
/* 169:181 */     return true;
/* 170:    */   }
/* 171:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.BankController
 * JD-Core Version:    0.7.1
 */