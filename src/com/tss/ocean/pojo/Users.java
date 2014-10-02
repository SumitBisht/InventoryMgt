/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Date;
/*  5:   */ 
/*  6:   */ public class Users
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   private String name;
/* 11:   */   private String password;
/* 12:   */   private Integer usertypeid;
/* 13:   */   private Boolean isactive;
/* 14:   */   private Date createdat;
/* 15:   */   private Date updateat;
/* 16:   */   private byte[] image;
/* 17:   */   
/* 18:   */   public Users() {}
/* 19:   */   
/* 20:   */   public Users(String name, Date createdat)
/* 21:   */   {
/* 22:27 */     this.name = name;
/* 23:28 */     this.createdat = createdat;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public Users(String name, String password, Integer usertypeid, Boolean isactive, Date createdat, Date updateat, byte[] image)
/* 27:   */   {
/* 28:31 */     this.name = name;
/* 29:32 */     this.password = password;
/* 30:33 */     this.usertypeid = usertypeid;
/* 31:34 */     this.isactive = isactive;
/* 32:35 */     this.createdat = createdat;
/* 33:36 */     this.updateat = updateat;
/* 34:37 */     this.image = image;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public Integer getId()
/* 38:   */   {
/* 39:41 */     return this.id;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setId(Integer id)
/* 43:   */   {
/* 44:45 */     this.id = id;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getName()
/* 48:   */   {
/* 49:48 */     return this.name;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setName(String name)
/* 53:   */   {
/* 54:52 */     this.name = name;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public String getPassword()
/* 58:   */   {
/* 59:55 */     return this.password;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setPassword(String password)
/* 63:   */   {
/* 64:59 */     this.password = password;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public Integer getUsertypeid()
/* 68:   */   {
/* 69:62 */     return this.usertypeid;
/* 70:   */   }
/* 71:   */   
/* 72:   */   public void setUsertypeid(Integer usertypeid)
/* 73:   */   {
/* 74:66 */     this.usertypeid = usertypeid;
/* 75:   */   }
/* 76:   */   
/* 77:   */   public Boolean getIsactive()
/* 78:   */   {
/* 79:69 */     return this.isactive;
/* 80:   */   }
/* 81:   */   
/* 82:   */   public void setIsactive(Boolean isactive)
/* 83:   */   {
/* 84:73 */     this.isactive = isactive;
/* 85:   */   }
/* 86:   */   
/* 87:   */   public Date getCreatedat()
/* 88:   */   {
/* 89:76 */     return this.createdat;
/* 90:   */   }
/* 91:   */   
/* 92:   */   public void setCreatedat(Date createdat)
/* 93:   */   {
/* 94:80 */     this.createdat = createdat;
/* 95:   */   }
/* 96:   */   
/* 97:   */   public Date getUpdateat()
/* 98:   */   {
/* 99:83 */     return this.updateat;
/* :0:   */   }
/* :1:   */   
/* :2:   */   public void setUpdateat(Date updateat)
/* :3:   */   {
/* :4:87 */     this.updateat = updateat;
/* :5:   */   }
/* :6:   */   
/* :7:   */   public byte[] getImage()
/* :8:   */   {
/* :9:90 */     return this.image;
/* ;0:   */   }
/* ;1:   */   
/* ;2:   */   public void setImage(byte[] image)
/* ;3:   */   {
/* ;4:94 */     this.image = image;
/* ;5:   */   }
/* ;6:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Users
 * JD-Core Version:    0.7.1
 */