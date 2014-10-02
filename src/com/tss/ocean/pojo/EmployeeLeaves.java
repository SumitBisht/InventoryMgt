/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class EmployeeLeaves
/*  8:   */   implements Serializable
/*  9:   */ {
/* 10:   */   private Integer id;
/* 11:   */   private Integer employeeId;
/* 12:   */   private Integer employeeLeaveTypeId;
/* 13:   */   private BigDecimal leaveCount;
/* 14:   */   private BigDecimal leaveTaken;
/* 15:   */   private Date resetDate;
/* 16:   */   private Date createdAt;
/* 17:   */   private Date updatedAt;
/* 18:   */   
/* 19:   */   public EmployeeLeaves() {}
/* 20:   */   
/* 21:   */   public EmployeeLeaves(Integer employeeId, Integer employeeLeaveTypeId, BigDecimal leaveCount, BigDecimal leaveTaken, Date resetDate, Date createdAt, Date updatedAt)
/* 22:   */   {
/* 23:27 */     this.employeeId = employeeId;
/* 24:28 */     this.employeeLeaveTypeId = employeeLeaveTypeId;
/* 25:29 */     this.leaveCount = leaveCount;
/* 26:30 */     this.leaveTaken = leaveTaken;
/* 27:31 */     this.resetDate = resetDate;
/* 28:32 */     this.createdAt = createdAt;
/* 29:33 */     this.updatedAt = updatedAt;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public Integer getId()
/* 33:   */   {
/* 34:37 */     return this.id;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setId(Integer id)
/* 38:   */   {
/* 39:41 */     this.id = id;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public Integer getEmployeeId()
/* 43:   */   {
/* 44:44 */     return this.employeeId;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setEmployeeId(Integer employeeId)
/* 48:   */   {
/* 49:48 */     this.employeeId = employeeId;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public Integer getEmployeeLeaveTypeId()
/* 53:   */   {
/* 54:51 */     return this.employeeLeaveTypeId;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public void setEmployeeLeaveTypeId(Integer employeeLeaveTypeId)
/* 58:   */   {
/* 59:55 */     this.employeeLeaveTypeId = employeeLeaveTypeId;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public BigDecimal getLeaveCount()
/* 63:   */   {
/* 64:58 */     return this.leaveCount;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setLeaveCount(BigDecimal leaveCount)
/* 68:   */   {
/* 69:62 */     this.leaveCount = leaveCount;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public BigDecimal getLeaveTaken()
/* 73:   */   {
/* 74:65 */     return this.leaveTaken;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public void setLeaveTaken(BigDecimal leaveTaken)
/* 78:   */   {
/* 79:69 */     this.leaveTaken = leaveTaken;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public Date getResetDate()
/* 83:   */   {
/* 84:72 */     return this.resetDate;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void setResetDate(Date resetDate)
/* 88:   */   {
/* 89:76 */     this.resetDate = resetDate;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public Date getCreatedAt()
/* 93:   */   {
/* 94:79 */     return this.createdAt;
/* 95:   */   }
/* 96:   */   
/* 97:   */   public void setCreatedAt(Date createdAt)
/* 98:   */   {
/* 99:83 */     this.createdAt = createdAt;
/* :0:   */   }
/* :1:   */   
/* :2:   */   public Date getUpdatedAt()
/* :3:   */   {
/* :4:86 */     return this.updatedAt;
/* :5:   */   }
/* :6:   */   
/* :7:   */   public void setUpdatedAt(Date updatedAt)
/* :8:   */   {
/* :9:90 */     this.updatedAt = updatedAt;
/* ;0:   */   }
/* ;1:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.EmployeeLeaves
 * JD-Core Version:    0.7.1
 */