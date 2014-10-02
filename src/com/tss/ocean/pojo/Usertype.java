/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class Usertype
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   private String usertype;
/* 11:   */   private String description;
/* 12:   */   private Date createdat;
/* 13:   */   private Date updateat;
/* 14:   */   
/* 15:   */   public Usertype() {}
/* 16:   */   
/* 17:   */   public Usertype(String usertype, Date createdat)
/* 18:   */   {
/* 19:24 */     this.usertype = usertype;
/* 20:25 */     this.createdat = createdat;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public Usertype(String usertype, String description, Date createdat, Date updateat)
/* 24:   */   {
/* 25:28 */     this.usertype = usertype;
/* 26:29 */     this.description = description;
/* 27:30 */     this.createdat = createdat;
/* 28:31 */     this.updateat = updateat;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public Integer getId()
/* 32:   */   {
/* 33:35 */     return this.id;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public void setId(Integer id)
/* 37:   */   {
/* 38:39 */     this.id = id;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public String getUsertype()
/* 42:   */   {
/* 43:42 */     return this.usertype;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setUsertype(String usertype)
/* 47:   */   {
/* 48:46 */     this.usertype = usertype;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public String getDescription()
/* 52:   */   {
/* 53:49 */     return this.description;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public void setDescription(String description)
/* 57:   */   {
/* 58:53 */     this.description = description;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public Date getCreatedat()
/* 62:   */   {
/* 63:56 */     return this.createdat;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public void setCreatedat(Date createdat)
/* 67:   */   {
/* 68:60 */     this.createdat = createdat;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public Date getUpdateat()
/* 72:   */   {
/* 73:63 */     return this.updateat;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public void setUpdateat(Date updateat)
/* 77:   */   {
/* 78:67 */     this.updateat = updateat;
/* 79:   */   }
/* 80:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Usertype
 * JD-Core Version:    0.7.1
 */