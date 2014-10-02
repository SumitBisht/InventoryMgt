/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ import java.util.List;
/*  6:   */ import org.springframework.format.annotation.DateTimeFormat;
/*  7:   */ 
/*  8:   */ public class PayslipContainer
/*  9:   */   implements Serializable
/* 10:   */ {
/* 11:   */   private Integer employeeId;
/* 12:   */   private List<MonthlyPayslips> monthlyPayslipList;
/* 13:   */   @DateTimeFormat(pattern="dd/MM/yyyy")
/* 14:   */   private Date salaryDate;
/* 15:   */   
/* 16:   */   public Integer getEmployeeId()
/* 17:   */   {
/* 18:26 */     return this.employeeId;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setEmployeeId(Integer employeeId)
/* 22:   */   {
/* 23:30 */     this.employeeId = employeeId;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public List<MonthlyPayslips> getMonthlyPayslipList()
/* 27:   */   {
/* 28:34 */     return this.monthlyPayslipList;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setMonthlyPayslipList(List<MonthlyPayslips> monthlyPayslipList)
/* 32:   */   {
/* 33:38 */     this.monthlyPayslipList = monthlyPayslipList;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Date getSalaryDate()
/* 37:   */   {
/* 38:42 */     return this.salaryDate;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setSalaryDate(Date salaryDate)
/* 42:   */   {
/* 43:46 */     this.salaryDate = salaryDate;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public String toString()
/* 47:   */   {
/* 48:51 */     return "PayslipContainer{employeeId=" + this.employeeId + ", monthlyPayslipList=" + this.monthlyPayslipList + ", salaryDate=" + this.salaryDate + '}';
/* 49:   */   }
/* 50:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.PayslipContainer
 * JD-Core Version:    0.7.1
 */