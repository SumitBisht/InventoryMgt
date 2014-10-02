package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IEmployeeLeaveTypesDAO;
import com.tss.ocean.pojo.EmployeeLeaveTypes;
import org.springframework.stereotype.Repository;

@Repository("employeeLeaveTypesDAO")
public class EmployeeLeaveTypesDAO
  extends GenericDAOImpl<EmployeeLeaveTypes, Integer>
  implements IEmployeeLeaveTypesDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.EmployeeLeaveTypesDAO
 * JD-Core Version:    0.7.1
 */