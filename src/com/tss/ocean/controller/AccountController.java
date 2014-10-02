/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.tss.ocean.idao.IAccountsDAO;
/*   4:    */ import com.tss.ocean.pojo.Accounts;
/*   5:    */ import com.tss.ocean.util.Utilities;
/*   6:    */ import java.util.List;
/*   7:    */ import java.util.Locale;
/*   8:    */ import java.util.logging.Level;
/*   9:    */ import java.util.logging.Logger;
/*  10:    */ import javax.validation.Valid;
/*  11:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  12:    */ import org.springframework.context.MessageSource;
/*  13:    */ import org.springframework.security.access.prepost.PreAuthorize;
/*  14:    */ import org.springframework.stereotype.Controller;
/*  15:    */ import org.springframework.ui.ModelMap;
/*  16:    */ import org.springframework.validation.BindingResult;
/*  17:    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*  18:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  19:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  20:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  21:    */ import org.springframework.web.multipart.MultipartFile;
/*  22:    */ import org.springframework.web.servlet.ModelAndView;
/*  23:    */ 
/*  24:    */ @Controller
/*  25:    */ public class AccountController
/*  26:    */ {
/*  27: 28 */   private static final Logger logger = Logger.getLogger(ViewController.class.getName());
/*  28:    */   @Autowired
/*  29:    */   IAccountsDAO accountsDAO;
/*  30:    */   @Autowired
/*  31:    */   private MessageSource messageSource;
/*  32:    */   
/*  33:    */   @RequestMapping(value={"/add-account.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  34:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','add')")
/*  35:    */   public ModelAndView add_account_get(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/*  36:    */     throws Exception
/*  37:    */   {
/*  38: 40 */     logger.log(Level.FINE, "add-account called.");
/*  39:    */     
/*  40: 42 */     ModelAndView mav = new ModelAndView("account");
/*  41: 43 */     Accounts account = new Accounts();
/*  42: 44 */     if (success != null) {
/*  43: 45 */       mav.getModelMap().put("success", success);
/*  44:    */     }
/*  45: 47 */     if (error != null) {
/*  46: 48 */       mav.getModelMap().put("error", error);
/*  47:    */     }
/*  48: 50 */     mav.getModelMap().put("account", account);
/*  49: 51 */     return mav;
/*  50:    */   }
/*  51:    */   
/*  52:    */   @RequestMapping(value={"/add-account.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  53:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','add')")
/*  54:    */   public ModelAndView add_account_post(@ModelAttribute("account") @Valid Accounts account, BindingResult result, ModelMap model, @RequestParam(value="imageUpload", required=false) MultipartFile upload, Locale locale)
/*  55:    */     throws Exception
/*  56:    */   {
/*  57: 61 */     logger.log(Level.FINE, "add-account-post called.");
/*  58: 62 */     if (!result.hasErrors())
/*  59:    */     {
/*  60: 63 */       if (upload != null) {
/*  61: 64 */         account.setImage(upload.getBytes());
/*  62:    */       }
/*  63: 66 */       account.setVisible(Boolean.valueOf(true));
/*  64: 67 */       int insertResult = ((Integer)this.accountsDAO.insert(account)).intValue();
/*  65: 68 */       if (insertResult > 0)
/*  66:    */       {
/*  67: 69 */         logger.log(Level.INFO, "Account Added Successfully with id={0}", Integer.valueOf(insertResult));
/*  68: 70 */         return new ModelAndView("redirect:add-account.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "account.add.success", locale));
/*  69:    */       }
/*  70: 74 */       logger.log(Level.WARNING, "Error occurred inserting account:{0}", account.toString());
/*  71: 75 */       return new ModelAndView("account", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "account.add.error", locale));
/*  72:    */     }
/*  73: 80 */     logger.log(Level.WARNING, "Account values are not valid:", account.toString());
/*  74: 81 */     return new ModelAndView("account", model);
/*  75:    */   }
/*  76:    */   
/*  77:    */   @RequestMapping(value={"/edit-account.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  78:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','update')")
/*  79:    */   public ModelAndView edit_account_get(@RequestParam("id") int id, @RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/*  80:    */     throws Exception
/*  81:    */   {
/*  82: 90 */     logger.log(Level.FINE, "edit-account called.");
/*  83:    */     
/*  84: 92 */     Accounts account = (Accounts)this.accountsDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/*  85:    */     ModelAndView mav;
/*  86: 93 */     if (account != null)
/*  87:    */     {
/*  88: 94 */        mav = new ModelAndView("account");
/*  89: 95 */       mav.getModelMap().put("account", account);
/*  90:    */     }
/*  91:    */     else
/*  92:    */     {
/*  93: 98 */       mav = new ModelAndView("redirect:account");
/*  94:    */     }
/*  95:100 */     if (success != null) {
/*  96:101 */       mav.getModelMap().put("success", success);
/*  97:    */     }
/*  98:103 */     if (error != null) {
/*  99:104 */       mav.getModelMap().put("error", error);
/* 100:    */     }
/* 101:106 */     return mav;
/* 102:    */   }
/* 103:    */   
/* 104:    */   @RequestMapping(value={"/edit-account.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 105:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','update')")
/* 106:    */   public ModelAndView edit_account_post(@ModelAttribute("account") @Valid Accounts account, BindingResult result, ModelMap model, @RequestParam(value="imageUpload", required=false) MultipartFile upload, Locale locale)
/* 107:    */     throws Exception
/* 108:    */   {
/* 109:116 */     logger.log(Level.FINE, "edit-account-post called.");
/* 110:117 */     if (!result.hasErrors())
/* 111:    */     {
/* 112:118 */       if (upload != null)
/* 113:    */       {
/* 114:119 */         account.setImage(upload.getBytes());
/* 115:    */       }
/* 116:    */       else
/* 117:    */       {
/* 118:122 */         Accounts oldAccount = (Accounts)this.accountsDAO.getRecordByPrimaryKey(account.getId());
/* 119:123 */         account.setImage(oldAccount.getImage());
/* 120:    */       }
/* 121:125 */       int updateResult = this.accountsDAO.update(account);
/* 122:126 */       if (updateResult > 0)
/* 123:    */       {
/* 124:127 */         logger.log(Level.INFO, "Account updated Successfully with id={0}", Integer.valueOf(updateResult));
/* 125:128 */         return new ModelAndView("redirect:account.html").addObject("success", Utilities.getSpringMessage(this.messageSource, "account.update.success", locale));
/* 126:    */       }
/* 127:132 */       logger.log(Level.WARNING, "Error occurred updating account:{0}", account.toString());
/* 128:133 */       return new ModelAndView("account", model).addObject("error", Utilities.getSpringMessage(this.messageSource, "account.update.error", locale));
/* 129:    */     }
/* 130:138 */     logger.log(Level.WARNING, "Account values are not valid:", account.toString());
/* 131:139 */     return new ModelAndView("account", model);
/* 132:    */   }
/* 133:    */   
/* 134:    */   @RequestMapping(value={"/account.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 135:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','view')")
/* 136:    */   public ModelAndView account(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error)
/* 137:    */     throws Exception
/* 138:    */   {
/* 139:147 */     logger.log(Level.FINE, "add-account called.");
/* 140:148 */     ModelAndView mav = new ModelAndView("account-list");
/* 141:149 */     List<Accounts> accountsList = this.accountsDAO.getListByFromClause(" FROM Accounts a WHERE a.visible=true");
/* 142:150 */     if (success != null) {
/* 143:151 */       mav.getModelMap().put("success", success);
/* 144:    */     }
/* 145:153 */     if (error != null) {
/* 146:154 */       mav.getModelMap().put("error", error);
/* 147:    */     }
/* 148:156 */     mav.getModelMap().put("accountList", accountsList);
/* 149:157 */     return mav;
/* 150:    */   }
/* 151:    */   
/* 152:    */   @RequestMapping({"/delete-account.html"})
/* 153:    */   @ResponseBody
/* 154:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('account','delete')")
/* 155:    */   public boolean delete_account(@RequestParam("id") int id)
/* 156:    */     throws Exception
/* 157:    */   {
/* 158:164 */     logger.log(Level.FINE, "delete-account called.");
/* 159:165 */     Accounts account = (Accounts)this.accountsDAO.getRecordByPrimaryKey(Integer.valueOf(id));
/* 160:166 */     if (account != null)
/* 161:    */     {
/* 162:167 */       account.setVisible(Boolean.valueOf(false));
/* 163:168 */       int updateResult = this.accountsDAO.update(account);
/* 164:169 */       if (updateResult > 0)
/* 165:    */       {
/* 166:170 */         logger.log(Level.INFO, "Account with id {0} deleted successfully", account.getId());
/* 167:171 */         return true;
/* 168:    */       }
/* 169:174 */       logger.log(Level.WARNING, "Error occurred while deleting account with id {0}", account.getId());
/* 170:175 */       return false;
/* 171:    */     }
/* 172:178 */     logger.log(Level.INFO, "Account with id {0} is already deleted", Integer.valueOf(id));
/* 173:179 */     return true;
/* 174:    */   }
/* 175:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.AccountController
 * JD-Core Version:    0.7.1
 */