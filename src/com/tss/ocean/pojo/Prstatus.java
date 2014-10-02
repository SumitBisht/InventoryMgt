/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ 
/*  5:   */ public class Prstatus
/*  6:   */   implements Serializable
/*  7:   */ {
/*  8:   */   private Integer id;
/*  9:   */   private String status;
/* 10:   */   private String description;
/* 11:   */   private int order;
/* 12:   */   private int usertype;
/* 13:   */   
/* 14:   */   public Prstatus() {}
/* 15:   */   
/* 16:   */   public Prstatus(String status, int order, int usertype)
/* 17:   */   {
/* 18:23 */     this.status = status;
/* 19:24 */     this.order = order;
/* 20:25 */     this.usertype = usertype;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public Prstatus(String status, String description, int order, int usertype)
/* 24:   */   {
/* 25:28 */     this.status = status;
/* 26:29 */     this.description = description;
/* 27:30 */     this.order = order;
/* 28:31 */     this.usertype = usertype;
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
/* 41:   */   public String getStatus()
/* 42:   */   {
/* 43:42 */     return this.status;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public void setStatus(String status)
/* 47:   */   {
/* 48:46 */     this.status = status;
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
/* 61:   */   public int getOrder()
/* 62:   */   {
/* 63:56 */     return this.order;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public void setOrder(int order)
/* 67:   */   {
/* 68:60 */     this.order = order;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public int getUsertype()
/* 72:   */   {
/* 73:63 */     return this.usertype;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public void setUsertype(int usertype)
/* 77:   */   {
/* 78:67 */     this.usertype = usertype;
/* 79:   */   }
/* 80:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Prstatus
 * JD-Core Version:    0.7.1
 */