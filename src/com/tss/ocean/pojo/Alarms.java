/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ 
/*  5:   */ public class Alarms
/*  6:   */   implements Serializable
/*  7:   */ {
/*  8:   */   private Integer id;
/*  9:   */   private String name;
/* 10:   */   private String description;
/* 11:   */   private Boolean active;
/* 12:   */   private Integer createdat;
/* 13:   */   private Integer updatedat;
/* 14:   */   private Integer createdby;
/* 15:   */   
/* 16:   */   public Alarms() {}
/* 17:   */   
/* 18:   */   public Alarms(String name)
/* 19:   */   {
/* 20:25 */     this.name = name;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public Alarms(String name, String description, Boolean active, Integer createdat, Integer updatedat, Integer createdby)
/* 24:   */   {
/* 25:28 */     this.name = name;
/* 26:29 */     this.description = description;
/* 27:30 */     this.active = active;
/* 28:31 */     this.createdat = createdat;
/* 29:32 */     this.updatedat = updatedat;
/* 30:33 */     this.createdby = createdby;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public Integer getId()
/* 34:   */   {
/* 35:37 */     return this.id;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setId(Integer id)
/* 39:   */   {
/* 40:41 */     this.id = id;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public String getName()
/* 44:   */   {
/* 45:44 */     return this.name;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public void setName(String name)
/* 49:   */   {
/* 50:48 */     this.name = name;
/* 51:   */   }
/* 52:   */   
/* 53:   */   public String getDescription()
/* 54:   */   {
/* 55:51 */     return this.description;
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void setDescription(String description)
/* 59:   */   {
/* 60:55 */     this.description = description;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public Boolean getActive()
/* 64:   */   {
/* 65:58 */     return this.active;
/* 66:   */   }
/* 67:   */   
/* 68:   */   public void setActive(Boolean active)
/* 69:   */   {
/* 70:62 */     this.active = active;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public Integer getCreatedat()
/* 74:   */   {
/* 75:65 */     return this.createdat;
/* 76:   */   }
/* 77:   */   
/* 78:   */   public void setCreatedat(Integer createdat)
/* 79:   */   {
/* 80:69 */     this.createdat = createdat;
/* 81:   */   }
/* 82:   */   
/* 83:   */   public Integer getUpdatedat()
/* 84:   */   {
/* 85:72 */     return this.updatedat;
/* 86:   */   }
/* 87:   */   
/* 88:   */   public void setUpdatedat(Integer updatedat)
/* 89:   */   {
/* 90:76 */     this.updatedat = updatedat;
/* 91:   */   }
/* 92:   */   
/* 93:   */   public Integer getCreatedby()
/* 94:   */   {
/* 95:79 */     return this.createdby;
/* 96:   */   }
/* 97:   */   
/* 98:   */   public void setCreatedby(Integer createdby)
/* 99:   */   {
/* :0:83 */     this.createdby = createdby;
/* :1:   */   }
/* :2:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Alarms
 * JD-Core Version:    0.7.1
 */