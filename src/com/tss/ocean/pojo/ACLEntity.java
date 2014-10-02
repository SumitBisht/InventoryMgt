/*   1:    */ package com.tss.ocean.pojo;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.util.Objects;
/*   5:    */ 
/*   6:    */ public class ACLEntity
/*   7:    */   implements Serializable
/*   8:    */ {
/*   9:    */   private Integer Id;
/*  10:    */   private String aclId;
/*  11:    */   private Integer entityId;
/*  12:    */   private Integer entityType;
/*  13:    */   private Integer permissionLevel;
/*  14:    */   
/*  15:    */   public ACLEntity() {}
/*  16:    */   
/*  17:    */   public ACLEntity(Integer Id, String aclId, Integer entityId, Integer entityType, Integer permissionlevel)
/*  18:    */   {
/*  19: 28 */     this.Id = Id;
/*  20: 29 */     this.aclId = aclId;
/*  21: 30 */     this.entityId = entityId;
/*  22: 31 */     this.entityType = entityType;
/*  23: 32 */     this.permissionLevel = permissionlevel;
/*  24:    */   }
/*  25:    */   
/*  26:    */   public Integer getId()
/*  27:    */   {
/*  28: 36 */     return this.Id;
/*  29:    */   }
/*  30:    */   
/*  31:    */   public void setId(Integer Id)
/*  32:    */   {
/*  33: 40 */     this.Id = Id;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public String getAclId()
/*  37:    */   {
/*  38: 44 */     return this.aclId;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public void setAclId(String aclId)
/*  42:    */   {
/*  43: 48 */     this.aclId = aclId;
/*  44:    */   }
/*  45:    */   
/*  46:    */   public Integer getEntityId()
/*  47:    */   {
/*  48: 52 */     return this.entityId;
/*  49:    */   }
/*  50:    */   
/*  51:    */   public void setEntityId(Integer entiyId)
/*  52:    */   {
/*  53: 56 */     this.entityId = entiyId;
/*  54:    */   }
/*  55:    */   
/*  56:    */   public Integer getEntityType()
/*  57:    */   {
/*  58: 60 */     return this.entityType;
/*  59:    */   }
/*  60:    */   
/*  61:    */   public void setEntityType(Integer entityType)
/*  62:    */   {
/*  63: 64 */     this.entityType = entityType;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Integer getPermissionLevel()
/*  67:    */   {
/*  68: 68 */     return this.permissionLevel;
/*  69:    */   }
/*  70:    */   
/*  71:    */   public void setPermissionLevel(Integer permissionLevel)
/*  72:    */   {
/*  73: 72 */     this.permissionLevel = permissionLevel;
/*  74:    */   }
/*  75:    */   
/*  76:    */   public String toString()
/*  77:    */   {
/*  78: 77 */     return "ACLEntity{Id=" + this.Id + ", aclId=" + this.aclId + ", entityId=" + this.entityId + ", entityType=" + this.entityType + ", permissionlevel=" + this.permissionLevel + '}';
/*  79:    */   }
/*  80:    */   
/*  81:    */   public int hashCode()
/*  82:    */   {
/*  83: 82 */     int hash = 5;
/*  84: 83 */     hash = 53 * hash + Objects.hashCode(this.Id);
/*  85: 84 */     hash = 53 * hash + Objects.hashCode(this.aclId);
/*  86: 85 */     hash = 53 * hash + Objects.hashCode(this.entityId);
/*  87: 86 */     hash = 53 * hash + Objects.hashCode(this.entityType);
/*  88: 87 */     hash = 53 * hash + Objects.hashCode(this.permissionLevel);
/*  89: 88 */     return hash;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public boolean equals(Object obj)
/*  93:    */   {
/*  94: 93 */     if (obj == null) {
/*  95: 94 */       return false;
/*  96:    */     }
/*  97: 96 */     if (getClass() != obj.getClass()) {
/*  98: 97 */       return false;
/*  99:    */     }
/* 100: 99 */     ACLEntity other = (ACLEntity)obj;
/* 101:100 */     if (!Objects.equals(this.Id, other.Id)) {
/* 102:101 */       return false;
/* 103:    */     }
/* 104:103 */     if (!Objects.equals(this.aclId, other.aclId)) {
/* 105:104 */       return false;
/* 106:    */     }
/* 107:106 */     if (!Objects.equals(this.entityId, other.entityId)) {
/* 108:107 */       return false;
/* 109:    */     }
/* 110:109 */     if (!Objects.equals(this.entityType, other.entityType)) {
/* 111:110 */       return false;
/* 112:    */     }
/* 113:112 */     if (!Objects.equals(this.permissionLevel, other.permissionLevel)) {
/* 114:113 */       return false;
/* 115:    */     }
/* 116:115 */     return true;
/* 117:    */   }
/* 118:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.ACLEntity
 * JD-Core Version:    0.7.1
 */