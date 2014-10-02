package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IEmployeeDepartmentDAO;
import com.tss.ocean.pojo.EmployeeDepartment;
import org.springframework.stereotype.Repository;

@Repository("employeeDepartmentDAO")
public class EmployeeDepartmentDAO
  extends GenericDAOImpl<EmployeeDepartment, Integer>
  implements IEmployeeDepartmentDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.EmployeeDepartmentDAO
 * JD-Core Version:    0.7.1
 */