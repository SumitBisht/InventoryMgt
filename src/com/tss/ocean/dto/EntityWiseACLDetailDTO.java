/*  1:   */ package com.tss.ocean.dto;
/*  2:   */ 
/*  3:   */ public class EntityWiseACLDetailDTO
/*  4:   */ {
/*  5:   */   private int aclEntityId;
/*  6:   */   private String aclId;
/*  7:   */   private String aclModule;
/*  8:   */   private Integer permissionLevel;
/*  9:   */   
/* 10:   */   public int getAclEntityId()
/* 11:   */   {
/* 12:20 */     return this.aclEntityId;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public void setAclEntityId(int aclEntityId)
/* 16:   */   {
/* 17:24 */     this.aclEntityId = aclEntityId;
/* 18:   */   }
/* 19:   */   
/* 20:   */   public String getAclId()
/* 21:   */   {
/* 22:28 */     return this.aclId;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public void setAclId(String aclId)
/* 26:   */   {
/* 27:32 */     this.aclId = aclId;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public String getAclModule()
/* 31:   */   {
/* 32:36 */     return this.aclModule;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public void setAclModule(String aclModule)
/* 36:   */   {
/* 37:40 */     this.aclModule = aclModule;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public Integer getPermissionLevel()
/* 41:   */   {
/* 42:44 */     return this.permissionLevel;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void setPermissionLevel(Integer permissionLevel)
/* 46:   */   {
/* 47:48 */     this.permissionLevel = permissionLevel;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public String toString()
/* 51:   */   {
/* 52:53 */     return "EntityWiseACLDetailDTO{aclEntityId=" + this.aclEntityId + ", aclId=" + this.aclId + ", aclModule=" + this.aclModule + ", permissionLevel=" + this.permissionLevel + '}';
/* 53:   */   }
/* 54:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dto.EntityWiseACLDetailDTO
 * JD-Core Version:    0.7.1
 */