/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Objects;
/*  5:   */ 
/*  6:   */ public class ACL
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private String aclId;
/* 10:   */   private String aclModule;
/* 11:   */   private String parentAclId;
/* 12:   */   
/* 13:   */   public String getAclId()
/* 14:   */   {
/* 15:23 */     return this.aclId;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public void setAclId(String aclId)
/* 19:   */   {
/* 20:27 */     this.aclId = aclId;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public String getAclModule()
/* 24:   */   {
/* 25:31 */     return this.aclModule;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public void setAclModule(String aclModule)
/* 29:   */   {
/* 30:35 */     this.aclModule = aclModule;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public String getParentAclId()
/* 34:   */   {
/* 35:39 */     return this.parentAclId;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public void setParentAclId(String parentAclId)
/* 39:   */   {
/* 40:43 */     this.parentAclId = parentAclId;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public String toString()
/* 44:   */   {
/* 45:48 */     return "ACL{aclId=" + this.aclId + ", aclModule=" + this.aclModule + ", parentAclId=" + this.parentAclId + '}';
/* 46:   */   }
/* 47:   */   
/* 48:   */   public ACL(String aclId, String aclModule, String parentAclId)
/* 49:   */   {
/* 50:52 */     this.aclId = aclId;
/* 51:53 */     this.aclModule = aclModule;
/* 52:54 */     this.parentAclId = parentAclId;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public ACL() {}
/* 56:   */   
/* 57:   */   public int hashCode()
/* 58:   */   {
/* 59:63 */     int hash = 7;
/* 60:64 */     return hash;
/* 61:   */   }
/* 62:   */   
/* 63:   */   public boolean equals(Object obj)
/* 64:   */   {
/* 65:69 */     if (obj == null) {
/* 66:70 */       return false;
/* 67:   */     }
/* 68:72 */     if (getClass() != obj.getClass()) {
/* 69:73 */       return false;
/* 70:   */     }
/* 71:75 */     ACL other = (ACL)obj;
/* 72:76 */     if (!Objects.equals(this.aclId, other.aclId)) {
/* 73:77 */       return false;
/* 74:   */     }
/* 75:79 */     if (!Objects.equals(this.aclModule, other.aclModule)) {
/* 76:80 */       return false;
/* 77:   */     }
/* 78:82 */     if (!Objects.equals(this.parentAclId, other.parentAclId)) {
/* 79:83 */       return false;
/* 80:   */     }
/* 81:85 */     return true;
/* 82:   */   }
/* 83:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.ACL
 * JD-Core Version:    0.7.1
 */