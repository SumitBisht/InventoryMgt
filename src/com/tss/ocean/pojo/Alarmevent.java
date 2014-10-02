/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class Alarmevent
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   private int alarmid;
/* 11:   */   private Integer value;
/* 12:   */   private String description;
/* 13:   */   private byte[] attributes;
/* 14:   */   private Date expirydate;
/* 15:   */   
/* 16:   */   public Alarmevent() {}
/* 17:   */   
/* 18:   */   public Alarmevent(int alarmid)
/* 19:   */   {
/* 20:25 */     this.alarmid = alarmid;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public Alarmevent(int alarmid, Integer value, String description, byte[] attributes, Date expirydate)
/* 24:   */   {
/* 25:28 */     this.alarmid = alarmid;
/* 26:29 */     this.value = value;
/* 27:30 */     this.description = description;
/* 28:31 */     this.attributes = attributes;
/* 29:32 */     this.expirydate = expirydate;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public Integer getId()
/* 33:   */   {
/* 34:36 */     return this.id;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setId(Integer id)
/* 38:   */   {
/* 39:40 */     this.id = id;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public int getAlarmid()
/* 43:   */   {
/* 44:43 */     return this.alarmid;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setAlarmid(int alarmid)
/* 48:   */   {
/* 49:47 */     this.alarmid = alarmid;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public Integer getValue()
/* 53:   */   {
/* 54:50 */     return this.value;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public void setValue(Integer value)
/* 58:   */   {
/* 59:54 */     this.value = value;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public String getDescription()
/* 63:   */   {
/* 64:57 */     return this.description;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public void setDescription(String description)
/* 68:   */   {
/* 69:61 */     this.description = description;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public byte[] getAttributes()
/* 73:   */   {
/* 74:64 */     return this.attributes;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public void setAttributes(byte[] attributes)
/* 78:   */   {
/* 79:68 */     this.attributes = attributes;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public Date getExpirydate()
/* 83:   */   {
/* 84:71 */     return this.expirydate;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public void setExpirydate(Date expirydate)
/* 88:   */   {
/* 89:75 */     this.expirydate = expirydate;
/* 90:   */   }
/* 91:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Alarmevent
 * JD-Core Version:    0.7.1
 */