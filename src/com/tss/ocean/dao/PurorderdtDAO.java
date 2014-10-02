package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IPurorderdtDAO;
import com.tss.ocean.pojo.Purorderdt;
import org.springframework.stereotype.Repository;

@Repository("purorderdtDAO")
public class PurorderdtDAO
  extends GenericDAOImpl<Purorderdt, Integer>
  implements IPurorderdtDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.PurorderdtDAO
 * JD-Core Version:    0.7.1
 */