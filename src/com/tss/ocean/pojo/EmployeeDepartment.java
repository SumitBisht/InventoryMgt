/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import org.hibernate.validator.constraints.NotEmpty;
/*  5:   */ 
/*  6:   */ public class EmployeeDepartment
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   @NotEmpty
/* 11:   */   private String department;
/* 12:   */   @NotEmpty
/* 13:   */   private String code;
/* 14:   */   private Integer isActive;
/* 15:   */   
/* 16:   */   public Integer getId()
/* 17:   */   {
/* 18:26 */     return this.id;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setId(Integer id)
/* 22:   */   {
/* 23:30 */     this.id = id;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getDepartment()
/* 27:   */   {
/* 28:34 */     return this.department;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setDepartment(String department)
/* 32:   */   {
/* 33:38 */     this.department = department;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public String getCode()
/* 37:   */   {
/* 38:42 */     return this.code;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setCode(String code)
/* 42:   */   {
/* 43:46 */     this.code = code;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public Integer getIsActive()
/* 47:   */   {
/* 48:50 */     return this.isActive;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setIsActive(Integer isActive)
/* 52:   */   {
/* 53:54 */     this.isActive = isActive;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public String toString()
/* 57:   */   {
/* 58:59 */     return "EmployeeDepartment{id=" + this.id + ", department=" + this.department + ", code=" + this.code + ", isActive=" + this.isActive + '}';
/* 59:   */   }
/* 60:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.EmployeeDepartment
 * JD-Core Version:    0.7.1
 */