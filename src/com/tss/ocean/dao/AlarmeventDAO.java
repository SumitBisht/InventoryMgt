package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IAlarmeventDAO;
import com.tss.ocean.pojo.Alarmevent;
import org.springframework.stereotype.Repository;

@Repository("alarmeventDAO")
public class AlarmeventDAO
  extends GenericDAOImpl<Alarmevent, Integer>
  implements IAlarmeventDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.AlarmeventDAO
 * JD-Core Version:    0.7.1
 */