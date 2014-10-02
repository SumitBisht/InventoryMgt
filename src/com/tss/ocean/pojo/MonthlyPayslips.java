/*   1:    */ package com.tss.ocean.pojo;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import org.hibernate.validator.constraints.NotEmpty;
/*   6:    */ 
/*   7:    */ public class MonthlyPayslips
/*   8:    */   implements Serializable
/*   9:    */ {
/*  10:    */   private Integer id;
/*  11:    */   @NotEmpty
/*  12:    */   private Date salaryDate;
/*  13:    */   @NotEmpty
/*  14:    */   private Integer employeeId;
/*  15:    */   private Integer payrollCategoryId;
/*  16:    */   private Double amount;
/*  17:    */   private boolean isApproved;
/*  18:    */   private Integer approverId;
/*  19:    */   private boolean isRejected;
/*  20:    */   private Integer rejectorId;
/*  21:    */   private String reason;
/*  22:    */   private String remark;
/*  23:    */   
/*  24:    */   public MonthlyPayslips() {}
/*  25:    */   
/*  26:    */   public MonthlyPayslips(boolean isApproved, boolean isRejected)
/*  27:    */   {
/*  28: 30 */     this.isApproved = isApproved;
/*  29: 31 */     this.isRejected = isRejected;
/*  30:    */   }
/*  31:    */   
/*  32:    */   public MonthlyPayslips(Date salaryDate, Integer employeeId, Integer payrollCategoryId, Double amount, boolean isApproved, Integer approverId, boolean isRejected, Integer rejectorId, String reason, String remark)
/*  33:    */   {
/*  34: 35 */     this.salaryDate = salaryDate;
/*  35: 36 */     this.employeeId = employeeId;
/*  36: 37 */     this.payrollCategoryId = payrollCategoryId;
/*  37: 38 */     this.amount = amount;
/*  38: 39 */     this.isApproved = isApproved;
/*  39: 40 */     this.approverId = approverId;
/*  40: 41 */     this.isRejected = isRejected;
/*  41: 42 */     this.rejectorId = rejectorId;
/*  42: 43 */     this.reason = reason;
/*  43: 44 */     this.remark = remark;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public Integer getId()
/*  47:    */   {
/*  48: 48 */     return this.id;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setId(Integer id)
/*  52:    */   {
/*  53: 52 */     this.id = id;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Date getSalaryDate()
/*  57:    */   {
/*  58: 56 */     return this.salaryDate;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setSalaryDate(Date salaryDate)
/*  62:    */   {
/*  63: 60 */     this.salaryDate = salaryDate;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Integer getEmployeeId()
/*  67:    */   {
/*  68: 64 */     return this.employeeId;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setEmployeeId(Integer employeeId)
/*  72:    */   {
/*  73: 68 */     this.employeeId = employeeId;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public Integer getPayrollCategoryId()
/*  77:    */   {
/*  78: 72 */     return this.payrollCategoryId;
/*  79:    */   }
/*  80:    */   
/*  81:    */   public void setPayrollCategoryId(Integer payrollCategoryId)
/*  82:    */   {
/*  83: 76 */     this.payrollCategoryId = payrollCategoryId;
/*  84:    */   }
/*  85:    */   
/*  86:    */   public Double getAmount()
/*  87:    */   {
/*  88: 80 */     return this.amount;
/*  89:    */   }
/*  90:    */   
/*  91:    */   public void setAmount(Double amount)
/*  92:    */   {
/*  93: 84 */     this.amount = amount;
/*  94:    */   }
/*  95:    */   
/*  96:    */   public boolean isIsApproved()
/*  97:    */   {
/*  98: 88 */     return this.isApproved;
/*  99:    */   }
/* 100:    */   
/* 101:    */   public void setIsApproved(boolean isApproved)
/* 102:    */   {
/* 103: 92 */     this.isApproved = isApproved;
/* 104:    */   }
/* 105:    */   
/* 106:    */   public Integer getApproverId()
/* 107:    */   {
/* 108: 96 */     return this.approverId;
/* 109:    */   }
/* 110:    */   
/* 111:    */   public void setApproverId(Integer approverId)
/* 112:    */   {
/* 113:100 */     this.approverId = approverId;
/* 114:    */   }
/* 115:    */   
/* 116:    */   public boolean isIsRejected()
/* 117:    */   {
/* 118:104 */     return this.isRejected;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public void setIsRejected(boolean isRejected)
/* 122:    */   {
/* 123:108 */     this.isRejected = isRejected;
/* 124:    */   }
/* 125:    */   
/* 126:    */   public Integer getRejectorId()
/* 127:    */   {
/* 128:112 */     return this.rejectorId;
/* 129:    */   }
/* 130:    */   
/* 131:    */   public void setRejectorId(Integer rejectorId)
/* 132:    */   {
/* 133:116 */     this.rejectorId = rejectorId;
/* 134:    */   }
/* 135:    */   
/* 136:    */   public String getReason()
/* 137:    */   {
/* 138:120 */     return this.reason;
/* 139:    */   }
/* 140:    */   
/* 141:    */   public void setReason(String reason)
/* 142:    */   {
/* 143:124 */     this.reason = reason;
/* 144:    */   }
/* 145:    */   
/* 146:    */   public String getRemark()
/* 147:    */   {
/* 148:128 */     return this.remark;
/* 149:    */   }
/* 150:    */   
/* 151:    */   public void setRemark(String remark)
/* 152:    */   {
/* 153:132 */     this.remark = remark;
/* 154:    */   }
/* 155:    */   
/* 156:    */   public String toString()
/* 157:    */   {
/* 158:137 */     return "MonthlyPayslips{id=" + this.id + ", salaryDate=" + this.salaryDate + ", employeeId=" + this.employeeId + ", payrollCategoryId=" + this.payrollCategoryId + ", amount=" + this.amount + ", isApproved=" + this.isApproved + ", approverId=" + this.approverId + ", isRejected=" + this.isRejected + ", rejectorId=" + this.rejectorId + ", reason=" + this.reason + ", remark=" + this.remark + '}';
/* 159:    */   }
/* 160:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.MonthlyPayslips
 * JD-Core Version:    0.7.1
 */