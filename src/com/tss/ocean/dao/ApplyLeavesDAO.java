package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IApplyLeavesDAO;
import com.tss.ocean.pojo.ApplyLeaves;
import org.springframework.stereotype.Repository;

@Repository("applyLeavesDAO")
public class ApplyLeavesDAO
  extends GenericDAOImpl<ApplyLeaves, Integer>
  implements IApplyLeavesDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.ApplyLeavesDAO
 * JD-Core Version:    0.7.1
 */