/*   1:    */ package com.tss.ocean.pojo;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ 
/*   6:    */ public class ApplyLeaves
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9:    */   private Integer id;
/*  10:    */   private Integer employeeId;
/*  11:    */   private Integer employeeLeaveTypesId;
/*  12:    */   private Boolean isHalfDay;
/*  13:    */   private Date startDate;
/*  14:    */   private Date endDate;
/*  15:    */   private String reason;
/*  16:    */   private Boolean approved;
/*  17:    */   private Boolean viewedByManager;
/*  18:    */   private String managerRemark;
/*  19:    */   
/*  20:    */   public ApplyLeaves() {}
/*  21:    */   
/*  22:    */   public ApplyLeaves(Integer employeeId, Integer employeeLeaveTypesId, Boolean isHalfDay, Date startDate, Date endDate, String reason, Boolean approved, Boolean viewedByManager, String managerRemark)
/*  23:    */   {
/*  24: 28 */     this.employeeId = employeeId;
/*  25: 29 */     this.employeeLeaveTypesId = employeeLeaveTypesId;
/*  26: 30 */     this.isHalfDay = isHalfDay;
/*  27: 31 */     this.startDate = startDate;
/*  28: 32 */     this.endDate = endDate;
/*  29: 33 */     this.reason = reason;
/*  30: 34 */     this.approved = approved;
/*  31: 35 */     this.viewedByManager = viewedByManager;
/*  32: 36 */     this.managerRemark = managerRemark;
/*  33:    */   }
/*  34:    */   
/*  35:    */   public Integer getId()
/*  36:    */   {
/*  37: 40 */     return this.id;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public void setId(Integer id)
/*  41:    */   {
/*  42: 44 */     this.id = id;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public Integer getEmployeeId()
/*  46:    */   {
/*  47: 47 */     return this.employeeId;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public void setEmployeeId(Integer employeeId)
/*  51:    */   {
/*  52: 51 */     this.employeeId = employeeId;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public Integer getEmployeeLeaveTypesId()
/*  56:    */   {
/*  57: 54 */     return this.employeeLeaveTypesId;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public void setEmployeeLeaveTypesId(Integer employeeLeaveTypesId)
/*  61:    */   {
/*  62: 58 */     this.employeeLeaveTypesId = employeeLeaveTypesId;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public Boolean getIsHalfDay()
/*  66:    */   {
/*  67: 61 */     return this.isHalfDay;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public void setIsHalfDay(Boolean isHalfDay)
/*  71:    */   {
/*  72: 65 */     this.isHalfDay = isHalfDay;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public Date getStartDate()
/*  76:    */   {
/*  77: 68 */     return this.startDate;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public void setStartDate(Date startDate)
/*  81:    */   {
/*  82: 72 */     this.startDate = startDate;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public Date getEndDate()
/*  86:    */   {
/*  87: 75 */     return this.endDate;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public void setEndDate(Date endDate)
/*  91:    */   {
/*  92: 79 */     this.endDate = endDate;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public String getReason()
/*  96:    */   {
/*  97: 82 */     return this.reason;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public void setReason(String reason)
/* 101:    */   {
/* 102: 86 */     this.reason = reason;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public Boolean getApproved()
/* 106:    */   {
/* 107: 89 */     return this.approved;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public void setApproved(Boolean approved)
/* 111:    */   {
/* 112: 93 */     this.approved = approved;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public Boolean getViewedByManager()
/* 116:    */   {
/* 117: 96 */     return this.viewedByManager;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public void setViewedByManager(Boolean viewedByManager)
/* 121:    */   {
/* 122:100 */     this.viewedByManager = viewedByManager;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public String getManagerRemark()
/* 126:    */   {
/* 127:103 */     return this.managerRemark;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public void setManagerRemark(String managerRemark)
/* 131:    */   {
/* 132:107 */     this.managerRemark = managerRemark;
/* 133:    */   }
/* 134:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.ApplyLeaves
 * JD-Core Version:    0.7.1
 */