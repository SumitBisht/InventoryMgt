package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IPurrequisitionDAO;
import com.tss.ocean.pojo.Purrequisition;
import org.springframework.stereotype.Repository;

@Repository("purrequisitionDAO")
public class PurrequisitionDAO
  extends GenericDAOImpl<Purrequisition, Integer>
  implements IPurrequisitionDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.PurrequisitionDAO
 * JD-Core Version:    0.7.1
 */