package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IPrstatusDAO;
import com.tss.ocean.pojo.Prstatus;
import org.springframework.stereotype.Repository;

@Repository("prstatusDAO")
public class PrstatusDAO
  extends GenericDAOImpl<Prstatus, Integer>
  implements IPrstatusDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.PrstatusDAO
 * JD-Core Version:    0.7.1
 */