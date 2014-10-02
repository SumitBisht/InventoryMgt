package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IPayrollCategoriesDAO;
import com.tss.ocean.pojo.PayrollCategories;
import org.springframework.stereotype.Repository;

@Repository("payrollCategoriesDAO")
public class PayrollCategoriesDAO
  extends GenericDAOImpl<PayrollCategories, Integer>
  implements IPayrollCategoriesDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.PayrollCategoriesDAO
 * JD-Core Version:    0.7.1
 */