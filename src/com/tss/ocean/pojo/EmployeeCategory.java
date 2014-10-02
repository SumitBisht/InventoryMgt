/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import org.hibernate.validator.constraints.NotEmpty;
/*  5:   */ 
/*  6:   */ public class EmployeeCategory
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   @NotEmpty
/* 11:   */   private String category;
/* 12:   */   @NotEmpty
/* 13:   */   private String prefix;
/* 14:   */   private Integer isActive;
/* 15:   */   
/* 16:   */   public Integer getId()
/* 17:   */   {
/* 18:25 */     return this.id;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setId(Integer id)
/* 22:   */   {
/* 23:29 */     this.id = id;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getCategory()
/* 27:   */   {
/* 28:33 */     return this.category;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setCategory(String category)
/* 32:   */   {
/* 33:37 */     this.category = category;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public String getPrefix()
/* 37:   */   {
/* 38:41 */     return this.prefix;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setPrefix(String prefix)
/* 42:   */   {
/* 43:45 */     this.prefix = prefix;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public Integer getIsActive()
/* 47:   */   {
/* 48:49 */     return this.isActive;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setIsActive(Integer isActive)
/* 52:   */   {
/* 53:53 */     this.isActive = isActive;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public String toString()
/* 57:   */   {
/* 58:58 */     return "EmployeeCategory{id=" + this.id + ", category=" + this.category + ", prefix=" + this.prefix + ", isActive=" + this.isActive + '}';
/* 59:   */   }
/* 60:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.EmployeeCategory
 * JD-Core Version:    0.7.1
 */