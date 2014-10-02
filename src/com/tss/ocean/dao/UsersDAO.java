package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IUsersDAO;
import com.tss.ocean.pojo.Users;
import org.springframework.stereotype.Repository;

@Repository("usersDAO")
public class UsersDAO
  extends GenericDAOImpl<Users, Integer>
  implements IUsersDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.UsersDAO
 * JD-Core Version:    0.7.1
 */