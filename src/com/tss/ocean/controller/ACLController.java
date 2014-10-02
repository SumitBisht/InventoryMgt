/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.tss.ocean.dto.EntityWiseACLDetailDTO;
/*   4:    */ import com.tss.ocean.idao.IACLDAO;
/*   5:    */ import com.tss.ocean.idao.IACLEntityDAO;
/*   6:    */ import com.tss.ocean.idao.IEmployeeCategoryDAO;
/*   7:    */ import com.tss.ocean.pojo.ACLEntity;
/*   8:    */ import com.tss.ocean.pojo.EmployeeCategory;
/*   9:    */ import java.util.ArrayList;
/*  10:    */ import java.util.Enumeration;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.Locale;
/*  13:    */ import javax.servlet.http.HttpServletRequest;
/*  14:    */ import org.slf4j.Logger;
/*  15:    */ import org.slf4j.LoggerFactory;
/*  16:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.ui.ModelMap;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  21:    */ import org.springframework.web.servlet.ModelAndView;
/*  22:    */ 
/*  23:    */ @Controller
/*  24:    */ public class ACLController
/*  25:    */ {
/*  26: 36 */   private static final Logger logger = LoggerFactory.getLogger(ACLController.class);
/*  27:    */   @Autowired
/*  28:    */   IEmployeeCategoryDAO employeeCategoryDAO;
/*  29:    */   @Autowired
/*  30:    */   IACLEntityDAO aclEntityDAO;
/*  31:    */   @Autowired
/*  32:    */   IACLDAO aclDAO;
/*  33:    */   
/*  34:    */   @RequestMapping(value={"/updateACL.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  35:    */   public ModelAndView updateControlParent(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, @RequestParam(value="categoryId", required=false) Integer categoryId, Locale locale, HttpServletRequest req)
/*  36:    */     throws Exception
/*  37:    */   {
/*  38: 51 */     logger.info("Updating ACL.");
/*  39: 52 */     ModelAndView mav = new ModelAndView("redirect:/access_control.html");
/*  40: 53 */     updateACL(req);
/*  41:    */     
/*  42: 55 */     return mav;
/*  43:    */   }
/*  44:    */   
/*  45:    */   @RequestMapping(value={"/access_control.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.GET})
/*  46:    */   public ModelAndView accessControlParent(@RequestParam(value="success", required=false) String success, @RequestParam(value="error", required=false) String error, @RequestParam(value="categoryId", required=false) Integer categoryId, Locale locale)
/*  47:    */     throws Exception
/*  48:    */   {
/*  49: 63 */     logger.info("access_control called.");
/*  50: 64 */     ModelAndView mav = new ModelAndView("access_control");
/*  51: 65 */     List<EmployeeCategory> employeeCategoryList = this.employeeCategoryDAO.getList();
/*  52: 66 */     logger.info("access_control called." + employeeCategoryList);
/*  53: 67 */     mav.getModelMap().put("employeeCategoryList", employeeCategoryList);
/*  54: 69 */     if (categoryId != null)
/*  55:    */     {
/*  56: 70 */       logger.info("Processing for category " + categoryId);
/*  57: 71 */       List<Object[]> listByHQLQuery = this.aclEntityDAO.getListByHQLQuery("select aclEntity.Id,acl.aclModule,aclEntity.aclId,aclEntity.permissionLevel from ACL acl, ACLEntity aclEntity where acl.aclId = aclEntity.aclId and aclEntity.entityType = 2 and aclEntity.entityId = " + categoryId);
/*  58: 72 */       List<EntityWiseACLDetailDTO> entityWiseACLDetails = new ArrayList();
/*  59: 73 */       if (listByHQLQuery != null) {
/*  60: 74 */         for (Object[] values : listByHQLQuery)
/*  61:    */         {
/*  62: 75 */           EntityWiseACLDetailDTO aCLDetailDTO = new EntityWiseACLDetailDTO();
/*  63: 76 */           aCLDetailDTO.setAclEntityId(((Number)values[0]).intValue());
/*  64: 77 */           aCLDetailDTO.setAclModule((String)values[1]);
/*  65: 78 */           aCLDetailDTO.setAclId((String)values[2]);
/*  66: 79 */           aCLDetailDTO.setPermissionLevel((Integer)values[3]);
/*  67: 80 */           entityWiseACLDetails.add(aCLDetailDTO);
/*  68:    */         }
/*  69:    */       }
/*  70: 84 */       logger.info("access_control called." + entityWiseACLDetails);
/*  71: 85 */       mav.getModelMap().put("entityWiseACLDetails", entityWiseACLDetails);
/*  72:    */       
/*  73: 87 */       mav.getModelMap().put("categoryId", categoryId);
/*  74:    */     }
/*  75:    */     else
/*  76:    */     {
/*  77: 89 */       mav.getModelMap().put("categoryId", Integer.valueOf(-1));
/*  78:    */     }
/*  79: 91 */     if (success != null) {
/*  80: 92 */       mav.getModelMap().put("success", success);
/*  81:    */     }
/*  82: 94 */     if (error != null) {
/*  83: 95 */       mav.getModelMap().put("error", error);
/*  84:    */     }
/*  85: 97 */     return mav;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void updateACL(HttpServletRequest req)
/*  89:    */   {
/*  90:101 */     Enumeration<String> parameterNames = req.getParameterNames();
/*  91:102 */     while (parameterNames.hasMoreElements())
/*  92:    */     {
/*  93:103 */       String paramName = (String)parameterNames.nextElement();
/*  94:104 */       ACLEntity aCLEntity = (ACLEntity)this.aclEntityDAO.getRecordByPrimaryKey(Integer.valueOf(paramName));
/*  95:105 */       String[] paramValues = req.getParameterValues(paramName);
/*  96:106 */       for (int i = 0; i < paramValues.length; i++)
/*  97:    */       {
/*  98:107 */         String paramValue = paramValues[i];
/*  99:108 */         aCLEntity.setPermissionLevel(Integer.valueOf(paramValue));
/* 100:    */       }
/* 101:110 */       this.aclEntityDAO.update(aCLEntity);
/* 102:    */     }
/* 103:    */   }
/* 104:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.ACLController
 * JD-Core Version:    0.7.1
 */