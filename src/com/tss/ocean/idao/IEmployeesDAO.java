package com.tss.ocean.idao;

import java.util.List;

import com.techshark.hibernate.ibase.GenericDAO;
import com.tss.ocean.pojo.Employees;

public abstract interface IEmployeesDAO
  extends GenericDAO<Employees, Integer>
{
	public List<Employees> getAlarm();	
}


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.idao.IEmployeesDAO
 * JD-Core Version:    0.7.1
 */