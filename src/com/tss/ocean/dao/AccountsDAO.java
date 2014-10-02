package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IAccountsDAO;
import com.tss.ocean.pojo.Accounts;
import org.springframework.stereotype.Repository;

@Repository("accountsDAO")
public class AccountsDAO
  extends GenericDAOImpl<Accounts, Integer>
  implements IAccountsDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.AccountsDAO
 * JD-Core Version:    0.7.1
 */