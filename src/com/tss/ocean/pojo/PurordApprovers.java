/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class PurordApprovers
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   private int userid;
/* 11:   */   private int level;
/* 12:   */   private int createdby;
/* 13:   */   private Date createdat;
/* 14:   */   
/* 15:   */   public PurordApprovers() {}
/* 16:   */   
/* 17:   */   public PurordApprovers(int userid, int level, int createdby, Date createdat)
/* 18:   */   {
/* 19:23 */     this.userid = userid;
/* 20:24 */     this.level = level;
/* 21:25 */     this.createdby = createdby;
/* 22:26 */     this.createdat = createdat;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public Integer getId()
/* 26:   */   {
/* 27:30 */     return this.id;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setId(Integer id)
/* 31:   */   {
/* 32:34 */     this.id = id;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public int getUserid()
/* 36:   */   {
/* 37:37 */     return this.userid;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void setUserid(int userid)
/* 41:   */   {
/* 42:41 */     this.userid = userid;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public int getLevel()
/* 46:   */   {
/* 47:44 */     return this.level;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setLevel(int level)
/* 51:   */   {
/* 52:48 */     this.level = level;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public int getCreatedby()
/* 56:   */   {
/* 57:51 */     return this.createdby;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setCreatedby(int createdby)
/* 61:   */   {
/* 62:55 */     this.createdby = createdby;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Date getCreatedat()
/* 66:   */   {
/* 67:58 */     return this.createdat;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setCreatedat(Date createdat)
/* 71:   */   {
/* 72:62 */     this.createdat = createdat;
/* 73:   */   }
/* 74:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.PurordApprovers
 * JD-Core Version:    0.7.1
 */