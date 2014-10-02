/*  1:   */ package com.techshark.hibernate.ibase;
/*  2:   */ 
/*  3:   */ import com.techshark.hibernate.base.HibernateDAOFactory;
/*  4:   */ import com.tss.ocean.idao.IEmployeeCategoryDAO;
/*  5:   */ import com.tss.ocean.idao.IEmployeesDAO;
/*  6:   */ 
/*  7:   */ public abstract class DAOFactory
/*  8:   */ {
/*  9:20 */   public static final Class HIBERNATE = HibernateDAOFactory.class;
/* 10:21 */   public static final DAOFactory instance = new HibernateDAOFactory();
/* 11:   */   
/* 12:   */   public static DAOFactory instance(Class factory)
/* 13:   */   {
/* 14:   */     try
/* 15:   */     {
/* 16:28 */       return instance;
/* 17:   */     }
/* 18:   */     catch (Exception ex)
/* 19:   */     {
/* 20:30 */       throw new RuntimeException("Couldn't create DAOFactory: " + factory + ":" + ex);
/* 21:   */     }
/* 22:   */   }
/* 23:   */   
/* 24:   */   public abstract IEmployeesDAO getEmployeesDAO();
/* 25:   */   
/* 26:   */   public abstract IEmployeeCategoryDAO getEmployeeCategoryDAO();
/* 27:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.techshark.hibernate.ibase.DAOFactory
 * JD-Core Version:    0.7.1
 */