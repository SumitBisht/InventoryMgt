/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.util.Date;
/*  4:   */ import org.springframework.format.annotation.DateTimeFormat;
/*  5:   */ 
/*  6:   */ public class AttendanceDate
/*  7:   */ {
/*  8:   */   @DateTimeFormat(pattern="dd/MM/yyyy")
/*  9:   */   private Date fromDate;
/* 10:   */   @DateTimeFormat(pattern="dd/MM/yyyy")
/* 11:   */   private Date toDate;
/* 12:   */   private String employee;
/* 13:   */   private Integer presentDays;
/* 14:   */   private Integer absentDays;
/* 15:   */   private Integer totalDays;
/* 16:   */   
/* 17:   */   public Date getFromDate()
/* 18:   */   {
/* 19:27 */     return this.fromDate;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public void setFromDate(Date fromDate)
/* 23:   */   {
/* 24:31 */     this.fromDate = fromDate;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public Date getToDate()
/* 28:   */   {
/* 29:35 */     return this.toDate;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setToDate(Date toDate)
/* 33:   */   {
/* 34:39 */     this.toDate = toDate;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getEmployee()
/* 38:   */   {
/* 39:43 */     return this.employee;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setEmployee(String employee)
/* 43:   */   {
/* 44:47 */     this.employee = employee;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public Integer getPresentDays()
/* 48:   */   {
/* 49:51 */     return this.presentDays;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setPresentDays(Integer presentDays)
/* 53:   */   {
/* 54:55 */     this.presentDays = presentDays;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public Integer getAbsentDays()
/* 58:   */   {
/* 59:59 */     return this.absentDays;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setAbsentDays(Integer absentDays)
/* 63:   */   {
/* 64:63 */     this.absentDays = absentDays;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public Integer getTotalDays()
/* 68:   */   {
/* 69:67 */     return this.totalDays;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setTotalDays(Integer totalDays)
/* 73:   */   {
/* 74:71 */     this.totalDays = totalDays;
/* 75:   */   }
/* 76:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.AttendanceDate
 * JD-Core Version:    0.7.1
 */