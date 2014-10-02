package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IEmployeeLeavesDAO;
import com.tss.ocean.pojo.EmployeeLeaves;
import org.springframework.stereotype.Repository;

@Repository("employeeLeavesDAO")
public class EmployeeLeavesDAO
  extends GenericDAOImpl<EmployeeLeaves, Integer>
  implements IEmployeeLeavesDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.EmployeeLeavesDAO
 * JD-Core Version:    0.7.1
 */