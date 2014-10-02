package com.tss.ocean.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.Employees;
import com.tss.ocean.pojo.Item;

@Repository("employeesDAO")
public class EmployeesDAO
  extends GenericDAOImpl<Employees, Integer>
  implements IEmployeesDAO
{
	@Override
	public List<Employees> getAlarm() {

		Session session = getSession();
		
		session.beginTransaction();
	return	session.createQuery("from Employees e where e.currstock < 15 ").list();
		
	}

}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.EmployeesDAO
 * JD-Core Version:    0.7.1
 */