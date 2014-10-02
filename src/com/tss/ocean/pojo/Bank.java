/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ 
/*  5:   */ public class Bank
/*  6:   */   implements Serializable
/*  7:   */ {
/*  8:   */   private Integer id;
/*  9:   */   private String name;
/* 10:   */   private String address1;
/* 11:   */   private String address2;
/* 12:   */   private String city;
/* 13:   */   private Integer countryId;
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
/* 35:   */   public String getAddress1()
/* 36:   */   {
/* 37:40 */     return this.address1;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void setAddress1(String address1)
/* 41:   */   {
/* 42:44 */     this.address1 = address1;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public String getAddress2()
/* 46:   */   {
/* 47:48 */     return this.address2;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setAddress2(String address2)
/* 51:   */   {
/* 52:52 */     this.address2 = address2;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public String getCity()
/* 56:   */   {
/* 57:56 */     return this.city;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setCity(String city)
/* 61:   */   {
/* 62:60 */     this.city = city;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public Integer getCountryId()
/* 66:   */   {
/* 67:64 */     return this.countryId;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setCountryId(Integer countryId)
/* 71:   */   {
/* 72:68 */     this.countryId = countryId;
/* 73:   */   }
/* 74:   */   
/* 75:   */   public String toString()
/* 76:   */   {
/* 77:73 */     return "Bank{id=" + this.id + ", name=" + this.name + ", address1=" + this.address1 + ", address2=" + this.address2 + ", city=" + this.city + ", countryId=" + this.countryId + '}';
/* 78:   */   }
/* 79:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Bank
 * JD-Core Version:    0.7.1
 */