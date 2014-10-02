package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IACLEntityDAO;
import com.tss.ocean.pojo.ACLEntity;
import org.springframework.stereotype.Repository;

@Repository("aclEntityDAO")
public class ACLEntityDAO
  extends GenericDAOImpl<ACLEntity, Integer>
  implements IACLEntityDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.ACLEntityDAO
 * JD-Core Version:    0.7.1
 */