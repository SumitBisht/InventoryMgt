/*  1:   */ package com.techshark.hibernate.base;
/*  2:   */ 
/*  3:   */ import com.techshark.hibernate.ibase.DAOFactory;
/*  4:   */ import com.tss.ocean.dao.EmployeeCategoryDAO;
/*  5:   */ import com.tss.ocean.dao.EmployeesDAO;
/*  6:   */ import com.tss.ocean.idao.IEmployeeCategoryDAO;
/*  7:   */ import com.tss.ocean.idao.IEmployeesDAO;
/*  8:   */ import java.io.PrintStream;
/*  9:   */ 
/* 10:   */ public class HibernateDAOFactory
/* 11:   */   extends DAOFactory
/* 12:   */ {
/* 13:   */   private GenericDAOImpl instantiateDAO(Class daoClass)
/* 14:   */   {
/* 15:   */     try
/* 16:   */     {
/* 17:30 */       return (GenericDAOImpl)daoClass.newInstance();
/* 18:   */     }
/* 19:   */     catch (Exception ex)
/* 20:   */     {
/* 21:39 */       System.out.println(ex);
/* 22:40 */       ex.printStackTrace();
/* 23:41 */       throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
/* 24:   */     }
/* 25:   */   }
/* 26:   */   
/* 27:   */   public IEmployeesDAO getEmployeesDAO()
/* 28:   */   {
/* 29:56 */     return (IEmployeesDAO)instantiateDAO(EmployeesDAO.class);
/* 30:   */   }
/* 31:   */   
/* 32:   */   public IEmployeeCategoryDAO getEmployeeCategoryDAO()
/* 33:   */   {
/* 34:61 */     return (IEmployeeCategoryDAO)instantiateDAO(EmployeeCategoryDAO.class);
/* 35:   */   }
/* 36:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.techshark.hibernate.base.HibernateDAOFactory
 * JD-Core Version:    0.7.1
 */