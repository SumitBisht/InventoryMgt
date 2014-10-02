package com.tss.ocean.dao;

import java.util.List;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IItemDAO;
import com.tss.ocean.pojo.Item;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("itemDAO")
public class ItemDAO
  extends GenericDAOImpl<Item, Integer>
  implements IItemDAO
{

	@Override
	public List<Item> getAlarm() {

		Session session = getSession();
		
		session.beginTransaction();
	return	session.createQuery("from Item itm where itm.currstock < 15 ").list();
		
	}
	



}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.ItemDAO
 * JD-Core Version:    0.7.1
 */