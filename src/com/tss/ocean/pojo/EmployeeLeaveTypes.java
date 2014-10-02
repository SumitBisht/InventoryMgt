/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import org.hibernate.validator.constraints.NotEmpty;
/*  5:   */ 
/*  6:   */ public class EmployeeLeaveTypes
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   @NotEmpty
/* 11:   */   private String name;
/* 12:   */   @NotEmpty
/* 13:   */   private String code;
/* 14:   */   private Boolean status;
/* 15:   */   private String maxLeaveCount;
/* 16:   */   private boolean carryForward;
/* 17:   */   
/* 18:   */   public EmployeeLeaveTypes() {}
/* 19:   */   
/* 20:   */   public EmployeeLeaveTypes(boolean carryForward)
/* 21:   */   {
/* 22:29 */     this.carryForward = carryForward;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public EmployeeLeaveTypes(String name, String code, Boolean status, String maxLeaveCount, boolean carryForward)
/* 26:   */   {
/* 27:32 */     this.name = name;
/* 28:33 */     this.code = code;
/* 29:34 */     this.status = status;
/* 30:35 */     this.maxLeaveCount = maxLeaveCount;
/* 31:36 */     this.carryForward = carryForward;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public Integer getId()
/* 35:   */   {
/* 36:40 */     return this.id;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setId(Integer id)
/* 40:   */   {
/* 41:44 */     this.id = id;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getName()
/* 45:   */   {
/* 46:47 */     return this.name;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setName(String name)
/* 50:   */   {
/* 51:51 */     this.name = name;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public String getCode()
/* 55:   */   {
/* 56:54 */     return this.code;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setCode(String code)
/* 60:   */   {
/* 61:58 */     this.code = code;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public Boolean getStatus()
/* 65:   */   {
/* 66:61 */     return this.status;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setStatus(Boolean status)
/* 70:   */   {
/* 71:65 */     this.status = status;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public String getMaxLeaveCount()
/* 75:   */   {
/* 76:68 */     return this.maxLeaveCount;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public void setMaxLeaveCount(String maxLeaveCount)
/* 80:   */   {
/* 81:72 */     this.maxLeaveCount = maxLeaveCount;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public boolean isCarryForward()
/* 85:   */   {
/* 86:75 */     return this.carryForward;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public void setCarryForward(boolean carryForward)
/* 90:   */   {
/* 91:79 */     this.carryForward = carryForward;
/* 92:   */   }
/* 93:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.EmployeeLeaveTypes
 * JD-Core Version:    0.7.1
 */