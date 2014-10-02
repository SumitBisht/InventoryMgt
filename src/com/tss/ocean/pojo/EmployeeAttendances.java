/*   1:    */ package com.tss.ocean.pojo;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Date;
/*   5:    */ import javax.validation.constraints.NotNull;
/*   6:    */ import org.springframework.format.annotation.DateTimeFormat;
/*   7:    */ 
/*   8:    */ public class EmployeeAttendances
/*   9:    */   implements Serializable
/*  10:    */ {
/*  11:    */   private Integer id;
/*  12:    */   @DateTimeFormat(pattern="dd/MM/yyyy")
/*  13:    */   @NotNull
/*  14:    */   private Date attendanceDate;
/*  15:    */   private Integer employeeId;
/*  16:    */   private Integer employeeLeaveTypeId;
/*  17:    */   private String reason;
/*  18:    */   private Boolean isHalfDay;
/*  19:    */   private String inTime;
/*  20:    */   private String outTime;
/*  21:    */   private Integer inHour;
/*  22:    */   private Integer inMinutes;
/*  23:    */   private Integer outHour;
/*  24:    */   private Integer outMinutes;
/*  25:    */   private Boolean isLeave;
/*  26:    */   
/*  27:    */   public EmployeeAttendances() {}
/*  28:    */   
/*  29:    */   public EmployeeAttendances(Date attendanceDate, Integer employeeId, Integer employeeLeaveTypeId, String reason, Boolean isHalfDay)
/*  30:    */   {
/*  31: 33 */     this.attendanceDate = attendanceDate;
/*  32: 34 */     this.employeeId = employeeId;
/*  33: 35 */     this.employeeLeaveTypeId = employeeLeaveTypeId;
/*  34: 36 */     this.reason = reason;
/*  35: 37 */     this.isHalfDay = isHalfDay;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public Integer getId()
/*  39:    */   {
/*  40: 41 */     return this.id;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public void setId(Integer id)
/*  44:    */   {
/*  45: 45 */     this.id = id;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public Date getAttendanceDate()
/*  49:    */   {
/*  50: 49 */     return this.attendanceDate;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public void setAttendanceDate(Date attendanceDate)
/*  54:    */   {
/*  55: 53 */     this.attendanceDate = attendanceDate;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public Integer getEmployeeId()
/*  59:    */   {
/*  60: 57 */     return this.employeeId;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public void setEmployeeId(Integer employeeId)
/*  64:    */   {
/*  65: 61 */     this.employeeId = employeeId;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public Integer getEmployeeLeaveTypeId()
/*  69:    */   {
/*  70: 65 */     return this.employeeLeaveTypeId;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public void setEmployeeLeaveTypeId(Integer employeeLeaveTypeId)
/*  74:    */   {
/*  75: 69 */     this.employeeLeaveTypeId = employeeLeaveTypeId;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public String getReason()
/*  79:    */   {
/*  80: 73 */     return this.reason;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public void setReason(String reason)
/*  84:    */   {
/*  85: 77 */     this.reason = reason;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public Boolean getIsHalfDay()
/*  89:    */   {
/*  90: 81 */     return this.isHalfDay;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public void setIsHalfDay(Boolean isHalfDay)
/*  94:    */   {
/*  95: 85 */     this.isHalfDay = isHalfDay;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public String getInTime()
/*  99:    */   {
/* 100: 89 */     return this.inTime;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public void setInTime(String inTime)
/* 104:    */   {
/* 105: 93 */     this.inTime = inTime;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public String getOutTime()
/* 109:    */   {
/* 110: 97 */     return this.outTime;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public void setOutTime(String outTime)
/* 114:    */   {
/* 115:101 */     this.outTime = outTime;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public Integer getInHour()
/* 119:    */   {
/* 120:105 */     return this.inHour;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public void setInHour(Integer inHour)
/* 124:    */   {
/* 125:109 */     this.inHour = inHour;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public Integer getInMinutes()
/* 129:    */   {
/* 130:113 */     return this.inMinutes;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public void setInMinutes(Integer inMinutes)
/* 134:    */   {
/* 135:117 */     this.inMinutes = inMinutes;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public Integer getOutHour()
/* 139:    */   {
/* 140:121 */     return this.outHour;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public void setOutHour(Integer outHour)
/* 144:    */   {
/* 145:125 */     this.outHour = outHour;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public Integer getOutMinutes()
/* 149:    */   {
/* 150:129 */     return this.outMinutes;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public void setOutMinutes(Integer outMinutes)
/* 154:    */   {
/* 155:133 */     this.outMinutes = outMinutes;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public Boolean getIsLeave()
/* 159:    */   {
/* 160:137 */     return this.isLeave;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public void setIsLeave(Boolean isLeave)
/* 164:    */   {
/* 165:141 */     this.isLeave = isLeave;
/* 166:    */   }
/* 167:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.EmployeeAttendances
 * JD-Core Version:    0.7.1
 */