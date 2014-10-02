package com.tss.ocean.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tss.ocean.idao.IUsersDAO;
import com.tss.ocean.pojo.Users;


@Service("userService")
public class Userservice implements IUserservice
{
	
	@Autowired
	IUsersDAO userDao;
	
	
	

	@Override
	public List<Users> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRecordBySQLQuery(String paramString) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public Users getRecordByKeyandValue(String paramString, Object paramObject) {

		return   userDao.getRecordByKeyandValue(paramString, paramObject);
			}

	@Override
	public List getRecordListByKeyandValue(String paramString,
			Object paramObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getListByKeyandValue(String paramString,
			List<Object> paramList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getListByCondition(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getRecordByPrimaryKey(Integer paramKeyType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getPrimaryKeyCollection(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(Users paramDomainObject) {

		userDao.insert(paramDomainObject);
		
		return null;
	}

	@Override
	public int update(Users paramDomainObject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Users paramDomainObject) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer paramKeyType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count(String paramString) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Users> getListByKeyandValue(String paramString,
			Object paramObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getExecuteUpdate(String paramString) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getListBySQLQuery(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getListByHQLQuery(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getListByFromClause(String paramString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getListByPage(String paramString, int paramInt1, int paramInt2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJsonPageData(int paramInt1, int paramInt2,
			String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getListByPage(String paramString1, String paramString2,
			int paramInt1, int paramInt2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJson(int paramInt1, int paramInt2, String paramString1,
			String paramString2, List<Users> paramList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOrUpdate(Users paramDomainObject) {
		// TODO Auto-generated method stub
		
	}

}
