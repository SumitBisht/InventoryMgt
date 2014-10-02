package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IItemunitDAO;
import com.tss.ocean.pojo.Itemunit;
import org.springframework.stereotype.Repository;

@Repository("itemunitDAO")
public class ItemunitDAO
  extends GenericDAOImpl<Itemunit, Integer>
  implements IItemunitDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.ItemunitDAO
 * JD-Core Version:    0.7.1
 */