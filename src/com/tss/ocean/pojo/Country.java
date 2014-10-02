/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class Country
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   private String name;
/* 11:   */   private String code;
/* 12:   */   private String createdby;
/* 13:   */   private Date createdate;
/* 14:   */   
/* 15:   */   public Integer getId()
/* 16:   */   {
/* 17:24 */     return this.id;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public void setId(Integer id)
/* 21:   */   {
/* 22:28 */     this.id = id;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public String getName()
/* 26:   */   {
/* 27:32 */     return this.name;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setName(String name)
/* 31:   */   {
/* 32:36 */     this.name = name;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public String getCode()
/* 36:   */   {
/* 37:40 */     return this.code;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void setCode(String code)
/* 41:   */   {
/* 42:44 */     this.code = code;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public String toString()
/* 46:   */   {
/* 47:49 */     return "Country{id=" + this.id + ", name=" + this.name + ", code=" + this.code + '}';
/* 48:   */   }
/* 49:   */   
/* 50:   */   public String getCreatedby()
/* 51:   */   {
/* 52:53 */     return this.createdby;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public void setCreatedby(String createdby)
/* 56:   */   {
/* 57:57 */     this.createdby = createdby;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public Date getCreatedate()
/* 61:   */   {
/* 62:61 */     return this.createdate;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public void setCreatedate(Date createdate)
/* 66:   */   {
/* 67:65 */     this.createdate = createdate;
/* 68:   */   }
/* 69:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Country
 * JD-Core Version:    0.7.1
 */