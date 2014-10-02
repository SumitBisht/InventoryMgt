/*  1:   */ package com.tss.ocean.dao;
/*  2:   */ 
/*  3:   */ import com.techshark.hibernate.base.GenericDAOImpl;
/*  4:   */ import com.techshark.hibernate.util.HibernateUtil;
/*  5:   */ import com.tss.ocean.idao.IEmployeeAttendancesDAO;
/*  6:   */ import com.tss.ocean.pojo.EmployeeAttendances;
/*  7:   */ import java.util.Date;
/*  8:   */ import java.util.HashMap;
/*  9:   */ import java.util.List;
/* 10:   */ import java.util.Map;
/* 11:   */ import java.util.Map.Entry;
/* 12:   */ import org.hibernate.Query;
/* 13:   */ import org.hibernate.Session;
/* 14:   */ import org.springframework.stereotype.Repository;
/* 15:   */ 
/* 16:   */ @Repository("employeeAttendancesDAO")
/* 17:   */ public class EmployeeAttendancesDAO
/* 18:   */   extends GenericDAOImpl<EmployeeAttendances, Integer>
/* 19:   */   implements IEmployeeAttendancesDAO
/* 20:   */ {
/* 21:   */   public List<EmployeeAttendances> getEmployeeAttendanceBetweenDates(Date fromdate, Date todate)
/* 22:   */   {
/* 23:27 */     Map<String, Object> parameterNameAndValues = new HashMap();
/* 24:   */     
/* 25:   */ 
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:33 */     parameterNameAndValues.put("startDate", fromdate);
/* 30:34 */     parameterNameAndValues.put("endDate", todate);
/* 31:   */     
/* 32:36 */     String hqlQuery = "FROM EmployeeAttendances e WHERE e.attendanceDate  BETWEEN :startDate AND :endDate";
/* 33:   */     
/* 34:38 */     Query query = HibernateUtil.getCurrentSession().createQuery(hqlQuery);
/* 35:40 */     for (Map.Entry<String, Object> e : parameterNameAndValues.entrySet()) {
/* 36:41 */       query.setParameter((String)e.getKey(), e.getValue());
/* 37:   */     }
/* 38:44 */     return query.list();
/* 39:   */   }
/* 40:   */ }


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.EmployeeAttendancesDAO
 * JD-Core Version:    0.7.1
 */