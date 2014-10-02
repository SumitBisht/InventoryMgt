package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IACLDAO;
import com.tss.ocean.pojo.ACL;
import org.springframework.stereotype.Repository;

@Repository("aclDAO")
public class ACLDAO
  extends GenericDAOImpl<ACL, String>
  implements IACLDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.ACLDAO
 * JD-Core Version:    0.7.1
 */