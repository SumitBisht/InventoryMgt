package com.tss.ocean.idao;

import java.util.List;

import com.techshark.hibernate.ibase.GenericDAO;
import com.tss.ocean.pojo.Item;

public abstract interface IItemDAO
  extends GenericDAO<Item, Integer>
{
	public List<Item> getAlarm();

}


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.idao.IItemDAO
 * JD-Core Version:    0.7.1
 */