package com.techshark.hibernate.ibase;

import java.io.Serializable;
import java.util.List;

public abstract interface GenericDAO<DomainObject extends Serializable, KeyType extends Serializable>
{
  public abstract List<DomainObject> getList();
  
  public abstract int getRecordBySQLQuery(String paramString);
  
  public abstract DomainObject getRecordByKeyandValue(String paramString, Object paramObject);
  
  public abstract List getRecordListByKeyandValue(String paramString, Object paramObject);
  
  public abstract List<DomainObject> getListByKeyandValue(String paramString, List<Object> paramList);
  
  public abstract List<DomainObject> getListByCondition(String paramString);
  
  public abstract DomainObject getRecordByPrimaryKey(KeyType paramKeyType);
  
  public abstract List<KeyType> getPrimaryKeyCollection(String paramString);
  
  public abstract KeyType insert(DomainObject paramDomainObject);
  
  public abstract int update(DomainObject paramDomainObject);
  
  public abstract int delete(DomainObject paramDomainObject);
  
  public abstract void deleteById(KeyType paramKeyType);
  
  public abstract int count();
  
  public abstract int count(String paramString);
  
  public abstract List<DomainObject> getListByKeyandValue(String paramString, Object paramObject);
  
  public abstract int getExecuteUpdate(String paramString);
  
  public abstract List getListBySQLQuery(String paramString);
  
  public abstract List getListByHQLQuery(String paramString);
  
  public abstract List getListByFromClause(String paramString);
  
  public abstract List getListByPage(String paramString, int paramInt1, int paramInt2);
  
  public abstract String getJsonPageData(int paramInt1, int paramInt2, String paramString1, String paramString2);
  
  public abstract List<DomainObject> getListByPage(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract String getJson(int paramInt1, int paramInt2, String paramString1, String paramString2, List<DomainObject> paramList);
  
  public abstract void insertOrUpdate(DomainObject paramDomainObject);
}


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.techshark.hibernate.ibase.GenericDAO
 * JD-Core Version:    0.7.1
 */