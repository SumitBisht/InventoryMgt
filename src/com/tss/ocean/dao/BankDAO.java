package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IBankDAO;
import com.tss.ocean.pojo.Bank;
import org.springframework.stereotype.Repository;

@Repository("bankDAO")
public class BankDAO
  extends GenericDAOImpl<Bank, Integer>
  implements IBankDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.BankDAO
 * JD-Core Version:    0.7.1
 */