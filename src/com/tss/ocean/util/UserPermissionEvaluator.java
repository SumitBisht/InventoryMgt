/*  1:   */ package com.tss.ocean.util;
/*  2:   */ 
/*  3:   */ import com.tss.ocean.idao.IEmployeesDAO;
/*  4:   */ import com.tss.ocean.idao.IUsersDAO;
/*  5:   */ import com.tss.ocean.pojo.Employees;
/*  6:   */ import com.tss.ocean.service.IACLEntiyService;
import com.tss.ocean.service.IUserservice;

/*  7:   */ import java.io.Serializable;
/*  8:   */ import java.util.logging.Level;
/*  9:   */ import java.util.logging.Logger;

/* 10:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 11:   */ import org.springframework.security.access.PermissionEvaluator;
/* 12:   */ import org.springframework.security.core.Authentication;
/* 13:   */ 
/* 14:   */ public class UserPermissionEvaluator
/* 15:   */   implements PermissionEvaluator
/* 16:   */ {
	
	
	
	
	
/* 17:27 */   private static final Logger logger = Logger.getLogger(UserPermissionEvaluator.class.getName());
/* 18:   */   @Autowired
/* 19:   */   IACLEntiyService aclEntityService;
/* 20:   */   @Autowired
/* 21:   */   IUsersDAO usersDAO;
/* 22:   */   @Autowired
/* 23:   */   IEmployeesDAO employeesDAO;
/* 24:   */   
/* 25:   */   public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission)
/* 26:   */   {
/* 27:40 */     if (permission == null) {
/* 28:41 */       return false;
/* 29:   */     }
/* 30:43 */     if (targetDomainObject == null) {
/* 31:44 */       return false;
/* 32:   */     }
/* 33:46 */     if ((authentication == null) || (authentication.getPrincipal() == null)) {
/* 34:47 */       return false;
/* 35:   */     }
/* 36:49 */     logger.log(Level.SEVERE, " Asking permission {0} {1} {2}", new Object[] { authentication.getPrincipal().toString(), targetDomainObject, permission });
/* 37:50 */     if (!authentication.isAuthenticated()) {
/* 38:51 */       return false;
/* 39:   */     }
/* 40:57 */     Employees employee = (Employees)this.employeesDAO.getRecordByKeyandValue("username", authentication.getPrincipal().toString());
/* 41:58 */     if (employee == null) {
/* 42:59 */       return false;
/* 43:   */     }
/* 44:61 */     Integer aclPermission = null;
/* 45:62 */     if (permission.toString().equalsIgnoreCase("VIEW")) {
/* 46:63 */       aclPermission = Integer.valueOf(1);
/* 47:65 */     } else if (permission.toString().equalsIgnoreCase("ADD")) {
/* 48:66 */       aclPermission = Integer.valueOf(2);
/* 49:68 */     } else if (permission.toString().equalsIgnoreCase("UPDATE")) {
/* 50:69 */       aclPermission = Integer.valueOf(3);
/* 51:71 */     } else if (permission.toString().equalsIgnoreCase("DELETE")) {
/* 52:72 */       aclPermission = Integer.valueOf(7);
/* 53:   */     }
/* 54:74 */     if (aclPermission == null) {
/* 55:75 */       return false;
/* 56:   */     }
/* 57:77 */     return this.aclEntityService.hasACL(employee.getEmployeeCategoryId().intValue(), 2, targetDomainObject.toString().toLowerCase(), aclPermission.intValue());
/* 58:   */   }
/* 59:   */   
/* 60:   */   public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission)
/* 61:   */   {
/* 62:81 */     logger.log(Level.SEVERE, " Asking permission {0} {1} {2} {3}", new Object[] { authentication.getPrincipal(), targetId, targetType, permission });
/* 63:82 */     return true;
/* 64:   */   }
/* 65:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.util.UserPermissionEvaluator
 * JD-Core Version:    0.7.1
 */