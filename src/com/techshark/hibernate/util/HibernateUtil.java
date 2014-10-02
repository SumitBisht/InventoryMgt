/*   1:    */ package com.techshark.hibernate.util;
/*   2:    */ 
/*   3:    */ import java.util.ArrayList;
/*   4:    */ import java.util.Iterator;
/*   5:    */ import java.util.List;
/*   6:    */ import org.hibernate.Query;
/*   7:    */ import org.hibernate.Session;
/*   8:    */ import org.hibernate.SessionFactory;
/*   9:    */ import org.hibernate.cfg.Configuration;
/*  10:    */ import org.hibernate.type.Type;
/*  11:    */ import org.slf4j.Logger;
/*  12:    */ import org.slf4j.LoggerFactory;
/*  13:    */ 
/*  14:    */ public class HibernateUtil
/*  15:    */ {
/*  16: 24 */   static final Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);
/*  17:    */   private static SessionFactory sessionFactory;
/*  18:    */   private static final String MODULE = "[HibernateUtil]";
/*  19:    */   
/*  20:    */   public static synchronized SessionFactory createSessionFactory()
/*  21:    */   {
/*  22: 39 */     if (sessionFactory == null)
/*  23:    */     {
/*  24: 40 */       LOG.debug("[HibernateUtil]in createSessionFactory");
/*  25: 41 */       sessionFactory = new Configuration().configure().buildSessionFactory();
/*  26:    */       
/*  27:    */ 
/*  28: 44 */       LOG.debug("[HibernateUtil]sessionFactory created");
/*  29:    */     }
/*  30: 47 */     return sessionFactory;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public static SessionFactory getInstance()
/*  34:    */   {
/*  35: 51 */     return createSessionFactory();
/*  36:    */   }
/*  37:    */   
/*  38:    */   public static Session openSession()
/*  39:    */   {
/*  40: 56 */     if (sessionFactory == null) {
/*  41: 57 */       createSessionFactory();
/*  42:    */     }
/*  43: 72 */     return sessionFactory.openSession();
/*  44:    */   }
/*  45:    */   
/*  46:    */   public static Session getCurrentSession()
/*  47:    */   {
/*  48: 97 */     return openSession();
/*  49:    */   }
/*  50:    */   
/*  51:    */   public static void close()
/*  52:    */   {
/*  53:105 */     if (sessionFactory != null) {
/*  54:106 */       sessionFactory.close();
/*  55:    */     }
/*  56:108 */     LOG.debug("[HibernateUtil]SessionFactory Close");
/*  57:109 */     sessionFactory = null;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public List find(String hqlQuery)
/*  61:    */     throws Exception
/*  62:    */   {
/*  63:114 */     List results = new ArrayList();
/*  64:    */     
/*  65:    */ 
/*  66:    */ 
/*  67:118 */     Query query = getCurrentSession().createQuery(hqlQuery);
/*  68:    */     
/*  69:    */ 
/*  70:    */ 
/*  71:122 */     Type beanType = query.getReturnTypes()[0];
/*  72:123 */     Class beanClass = beanType.getReturnedClass();
/*  73:    */     
/*  74:    */ 
/*  75:    */ 
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79:    */ 
/*  80:    */ 
/*  81:    */ 
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88:    */ 
/*  89:140 */     Iterator iter = query.iterate();
/*  90:141 */     while (iter.hasNext())
/*  91:    */     {
/*  92:142 */       Object[] row = (Object[])iter.next();
/*  93:143 */       Object bean = beanClass.newInstance();
/*  94:144 */       for (int j = 0; j < row.length; j++) {
/*  95:145 */         if (row[j] == null) {}
/*  96:    */       }
/*  97:150 */       results.add(bean);
/*  98:    */     }
/*  99:152 */     return results;
/* 100:    */   }
/* 101:    */   
/* 102:    */   private static void initialisePath(Object bean, String fieldName)
/* 103:    */     throws Exception
/* 104:    */   {
/* 105:158 */     int dot = fieldName.indexOf('.');
/* 106:159 */     while (dot >= 0)
/* 107:    */     {
/* 108:160 */       String attributeName = fieldName.substring(0, dot);
/* 109:    */       
/* 110:    */ 
/* 111:    */ 
/* 112:    */ 
/* 113:165 */       dot = fieldName.indexOf('.', dot + 1);
/* 114:    */     }
/* 115:    */   }
/* 116:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.techshark.hibernate.util.HibernateUtil
 * JD-Core Version:    0.7.1
 */