package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IAlarmsDAO;
import com.tss.ocean.pojo.Alarms;
import org.springframework.stereotype.Repository;

@Repository("alarmsDAO")
public class AlarmsDAO
  extends GenericDAOImpl<Alarms, Integer>
  implements IAlarmsDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.AlarmsDAO
 * JD-Core Version:    0.7.1
 */