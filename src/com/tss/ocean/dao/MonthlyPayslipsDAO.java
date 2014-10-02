package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IMonthlyPayslipsDAO;
import com.tss.ocean.pojo.MonthlyPayslips;
import org.springframework.stereotype.Repository;

@Repository("monthlyPayslipsDAO")
public class MonthlyPayslipsDAO
  extends GenericDAOImpl<MonthlyPayslips, Integer>
  implements IMonthlyPayslipsDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.MonthlyPayslipsDAO
 * JD-Core Version:    0.7.1
 */