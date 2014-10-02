/*  1:   */ package com.tss.ocean.service;
/*  2:   */ 
/*  3:   */ import com.tss.ocean.idao.IACLEntityDAO;
/*  4:   */ import com.tss.ocean.pojo.ACLEntity;
/*  5:   */ import java.util.List;
/*  6:   */ import org.springframework.beans.factory.annotation.Autowired;
/*  7:   */ import org.springframework.stereotype.Service;
/*  8:   */ import org.springframework.transaction.annotation.Transactional;
/*  9:   */ 
/* 10:   */ @Service("aclEntityService")
/* 11:   */ public class ACLEntityService
/* 12:   */   implements IACLEntiyService
/* 13:   */ {
/* 14:   */   @Autowired
/* 15:   */   IACLEntityDAO aclEntityDAO;
/* 16:   */   
/* 17:   */   @Transactional
/* 18:   */   public int assignACL(int entityId, int entityType, String aclId, int permissionlevel)
/* 19:   */   {
/* 20:29 */     revokeACL(entityId, entityType, aclId);
/* 21:30 */     ACLEntity aCLEntity = new ACLEntity();
/* 22:31 */     aCLEntity.setAclId(aclId);
/* 23:32 */     aCLEntity.setEntityId(Integer.valueOf(entityId));
/* 24:33 */     aCLEntity.setEntityType(Integer.valueOf(entityType));
/* 25:34 */     aCLEntity.setPermissionLevel(Integer.valueOf(permissionlevel));
/* 26:35 */     return ((Integer)this.aclEntityDAO.insert(aCLEntity)).intValue();
/* 27:   */   }
/* 28:   */   
/* 29:   */   @Transactional
/* 30:   */   public void revokeACL(int entityId, int entityType, String aclId)
/* 31:   */   {
/* 32:41 */     List<ACLEntity> aclEntityList = this.aclEntityDAO.getListByCondition(" WHERE entityid=" + entityId + " AND entitytype=" + entityType + " AND aclId='" + aclId + "'");
/* 33:42 */     for (ACLEntity aCLEntity : aclEntityList) {
/* 34:43 */       this.aclEntityDAO.delete(aCLEntity);
/* 35:   */     }
/* 36:   */   }
/* 37:   */   
/* 38:   */   @Transactional
/* 39:   */   public void revokeAllACL(int entityId, int entityType)
/* 40:   */   {
/* 41:50 */     List<ACLEntity> aclEntityList = this.aclEntityDAO.getListByCondition(" WHERE entityid=" + entityId + " AND entitytype=" + entityType);
/* 42:51 */     for (ACLEntity aCLEntity : aclEntityList) {
/* 43:52 */       this.aclEntityDAO.delete(aCLEntity);
/* 44:   */     }
/* 45:   */   }
/* 46:   */   
/* 47:   */   @Transactional
/* 48:   */   public void revokeAllACL(String aclId)
/* 49:   */   {
/* 50:59 */     List<ACLEntity> aclEntityList = this.aclEntityDAO.getListByCondition(" WHERE aclid='" + aclId + "'");
/* 51:60 */     for (ACLEntity aCLEntity : aclEntityList) {
/* 52:61 */       this.aclEntityDAO.delete(aCLEntity);
/* 53:   */     }
/* 54:   */   }
/* 55:   */   
/* 56:   */   public boolean hasACL(int entityId, int entityType, String aclId, int permissionLevel)
/* 57:   */   {
/* 58:67 */     int count = this.aclEntityDAO.count(" WHERE entityid=" + entityId + " AND entitytype=" + entityType + " AND permissionlevel>=" + permissionLevel + " AND aclid='" + aclId + "'");
/* 59:68 */     return count > 0;
/* 60:   */   }
/* 61:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.service.ACLEntityService
 * JD-Core Version:    0.7.1
 */