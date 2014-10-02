/*  1:   */ package com.tss.ocean.dao;
/*  2:   */ 
/*  3:   */ import com.techshark.hibernate.base.GenericDAOImpl;
/*  4:   */ import com.tss.ocean.idao.IPurorderDAO;
/*  5:   */ import com.tss.ocean.pojo.Purorder;
/*  6:   */ import java.io.PrintStream;
/*  7:   */ import java.util.Date;
/*  8:   */ import java.util.List;
/*  9:   */ import org.hibernate.HibernateException;
/* 10:   */ import org.hibernate.Query;
/* 11:   */ import org.hibernate.Session;
/* 12:   */ import org.slf4j.Logger;
/* 13:   */ import org.slf4j.LoggerFactory;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository("purorderDAO")
/* 17:   */ public class PurorderDAO
/* 18:   */   extends GenericDAOImpl<Purorder, Integer>
/* 19:   */   implements IPurorderDAO
/* 20:   */ {
/* 21:17 */   static final Logger LOG = LoggerFactory.getLogger(GenericDAOImpl.class);
/* 22:   */   
/* 23:   */   public List<Purorder> getPurOrderList_dateRange(Date fromDate, Date toDate)
/* 24:   */   {
/* 25:21 */     Session session = getSession();
/* 26:22 */     List<Purorder> lst = null;
/* 27:   */     try
/* 28:   */     {
/* 29:24 */       lst = session.createQuery("from Purorder p where p.createdat >= :fromDate and p.createdat < :toDate").setParameter("fromDate", fromDate).setParameter("toDate", toDate).list();
/* 30:25 */       System.out.println("List Size ********************** " + lst.size());
/* 31:   */     }
/* 32:   */     catch (HibernateException e)
/* 33:   */     {
/* 34:27 */       lst = null;
/* 35:28 */       LOG.error(" [PurorderDAO] Exception in getPurOrderList_dateRange Method:" + e, e);
/* 36:   */     }
/* 37:   */     finally
/* 38:   */     {
/* 39:30 */       if (session.isOpen()) {
/* 40:31 */         session.close();
/* 41:   */       }
/* 42:   */     }
/* 43:34 */     return lst;
/* 44:   */   }
/* 45:   */ }


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.PurorderDAO
 * JD-Core Version:    0.7.1
 */