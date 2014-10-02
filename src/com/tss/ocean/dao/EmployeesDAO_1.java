package com.tss.ocean.dao;

import java.util.List;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.Employees;

import org.springframework.stereotype.Repository;

@Repository("employeesDAO_1")
public class EmployeesDAO_1
  extends GenericDAOImpl<Employees, Integer>
  implements IEmployeesDAO
{

	@Override
	public List<Employees> getAlarm() {
		// TODO Auto-generated method stub
		return null;
	}}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.EmployeesDAO_1
 * JD-Core Version:    0.7.1
 */