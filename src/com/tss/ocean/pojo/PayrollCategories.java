/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import org.hibernate.validator.constraints.NotEmpty;
/*  5:   */ 
/*  6:   */ public class PayrollCategories
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   @NotEmpty
/* 11:   */   private String name;
/* 12:   */   private Float percentage;
/* 13:   */   private Integer payrollCategoryId;
/* 14:   */   private Boolean isDeduction;
/* 15:   */   private Boolean status;
/* 16:   */   
/* 17:   */   public PayrollCategories() {}
/* 18:   */   
/* 19:   */   public PayrollCategories(String name, Float percentage, Integer payrollCategoryId, Boolean isDeduction, Boolean status)
/* 20:   */   {
/* 21:27 */     this.name = name;
/* 22:28 */     this.percentage = percentage;
/* 23:29 */     this.payrollCategoryId = payrollCategoryId;
/* 24:30 */     this.isDeduction = isDeduction;
/* 25:31 */     this.status = status;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public Integer getId()
/* 29:   */   {
/* 30:35 */     return this.id;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void setId(Integer id)
/* 34:   */   {
/* 35:39 */     this.id = id;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public String getName()
/* 39:   */   {
/* 40:42 */     return this.name;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public void setName(String name)
/* 44:   */   {
/* 45:46 */     this.name = name;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public Float getPercentage()
/* 49:   */   {
/* 50:49 */     return this.percentage;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public void setPercentage(Float percentage)
/* 54:   */   {
/* 55:53 */     this.percentage = percentage;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public Integer getPayrollCategoryId()
/* 59:   */   {
/* 60:56 */     return this.payrollCategoryId;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public void setPayrollCategoryId(Integer payrollCategoryId)
/* 64:   */   {
/* 65:60 */     this.payrollCategoryId = payrollCategoryId;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public Boolean getIsDeduction()
/* 69:   */   {
/* 70:63 */     return this.isDeduction;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public void setIsDeduction(Boolean isDeduction)
/* 74:   */   {
/* 75:67 */     this.isDeduction = isDeduction;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public Boolean getStatus()
/* 79:   */   {
/* 80:70 */     return this.status;
/* 81:   */   }
/* 82:   */   
/* 83:   */   public void setStatus(Boolean status)
/* 84:   */   {
/* 85:74 */     this.status = status;
/* 86:   */   }
/* 87:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.PayrollCategories
 * JD-Core Version:    0.7.1
 */