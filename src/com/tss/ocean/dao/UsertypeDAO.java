/*  1:   */ package com.tss.ocean.dao;
/*  2:   */ 
/*  3:   */ import com.techshark.hibernate.base.GenericDAOImpl;
/*  4:   */ import com.tss.ocean.idao.IACLDAO;
/*  5:   */ import com.tss.ocean.idao.IACLEntityDAO;
/*  6:   */ import com.tss.ocean.idao.IUsertypeDAO;
/*  7:   */ import com.tss.ocean.pojo.ACL;
/*  8:   */ import com.tss.ocean.pojo.ACLEntity;
/*  9:   */ import com.tss.ocean.pojo.Usertype;
/* 10:   */ import java.util.List;
/* 11:   */ import org.springframework.beans.factory.annotation.Autowired;
/* 12:   */ import org.springframework.stereotype.Repository;
/* 13:   */ import org.springframework.transaction.annotation.Transactional;
/* 14:   */ 
/* 15:   */ @Repository("usertypeDAO")
/* 16:   */ public class UsertypeDAO
/* 17:   */   extends GenericDAOImpl<Usertype, Integer>
/* 18:   */   implements IUsertypeDAO
/* 19:   */ {
/* 20:   */   @Autowired
/* 21:   */   IACLEntityDAO aclEntityDAO;
/* 22:   */   @Autowired
/* 23:   */   IACLDAO aclDAO;
/* 24:   */   
/* 25:   */   @Transactional
/* 26:   */   public Integer insert(Usertype object)
/* 27:   */   {
/* 28:28 */     int status = ((Integer)super.insert(object)).intValue();
/* 29:29 */     List<ACL> aclList = this.aclDAO.getList();
/* 30:31 */     for (ACL acl : aclList)
/* 31:   */     {
/* 32:32 */       ACLEntity aclEntity = new ACLEntity();
/* 33:33 */       aclEntity.setAclId(acl.getAclId());
/* 34:34 */       aclEntity.setEntityId(object.getId());
/* 35:35 */       aclEntity.setEntityType(Integer.valueOf(2));
/* 36:36 */       aclEntity.setPermissionLevel(Integer.valueOf(0));
/* 37:37 */       this.aclEntityDAO.insert(aclEntity);
/* 38:   */     }
/* 39:39 */     return Integer.valueOf(status);
/* 40:   */   }
/* 41:   */ }


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.UsertypeDAO
 * JD-Core Version:    0.7.1
 */