/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.List;
/*  5:   */ 
/*  6:   */ public class Payslip
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer employeeId;
/* 10:   */   private String firstName;
/* 11:   */   private String lastName;
/* 12:   */   private String employeeNumber;
/* 13:   */   private Double salary;
/* 14:   */   private Double deductions;
/* 15:   */   private Double total;
/* 16:   */   private List<MonthlyPayslips> salaryList;
/* 17:   */   private List<MonthlyPayslips> deductionList;
/* 18:   */   
/* 19:   */   public Integer getEmployeeId()
/* 20:   */   {
/* 21:29 */     return this.employeeId;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setEmployeeId(Integer employeeId)
/* 25:   */   {
/* 26:33 */     this.employeeId = employeeId;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getFirstName()
/* 30:   */   {
/* 31:37 */     return this.firstName;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void setFirstName(String firstName)
/* 35:   */   {
/* 36:41 */     this.firstName = firstName;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public String getLastName()
/* 40:   */   {
/* 41:45 */     return this.lastName;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public void setLastName(String lastName)
/* 45:   */   {
/* 46:49 */     this.lastName = lastName;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public String getEmployeeNumber()
/* 50:   */   {
/* 51:53 */     return this.employeeNumber;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public void setEmployeeNumber(String employeeNumber)
/* 55:   */   {
/* 56:57 */     this.employeeNumber = employeeNumber;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public Double getSalary()
/* 60:   */   {
/* 61:61 */     return this.salary;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public void setSalary(Double salary)
/* 65:   */   {
/* 66:65 */     this.salary = salary;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public Double getDeductions()
/* 70:   */   {
/* 71:69 */     return this.deductions;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public void setDeductions(Double deductions)
/* 75:   */   {
/* 76:73 */     this.deductions = deductions;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public Double getTotal()
/* 80:   */   {
/* 81:77 */     return this.total;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public void setTotal(Double total)
/* 85:   */   {
/* 86:81 */     this.total = total;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public List<MonthlyPayslips> getSalaryList()
/* 90:   */   {
/* 91:85 */     return this.salaryList;
/* 92:   */   }
/* 93:   */   
/* 94:   */   public void setSalaryList(List<MonthlyPayslips> salaryList)
/* 95:   */   {
/* 96:89 */     this.salaryList = salaryList;
/* 97:   */   }
/* 98:   */   
/* 99:   */   public List<MonthlyPayslips> getDeductionList()
/* :0:   */   {
/* :1:93 */     return this.deductionList;
/* :2:   */   }
/* :3:   */   
/* :4:   */   public void setDeductionList(List<MonthlyPayslips> deductionList)
/* :5:   */   {
/* :6:97 */     this.deductionList = deductionList;
/* :7:   */   }
/* :8:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Payslip
 * JD-Core Version:    0.7.1
 */