package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IItemtypeDAO;
import com.tss.ocean.pojo.Itemtype;
import org.springframework.stereotype.Repository;

@Repository("itemTypeDAO")
public class ItemtypeDAO
  extends GenericDAOImpl<Itemtype, Integer>
  implements IItemtypeDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.ItemtypeDAO
 * JD-Core Version:    0.7.1
 */