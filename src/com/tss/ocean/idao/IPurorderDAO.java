package com.tss.ocean.idao;

import com.techshark.hibernate.ibase.GenericDAO;
import com.tss.ocean.pojo.Purorder;
import java.util.Date;
import java.util.List;

public abstract interface IPurorderDAO
  extends GenericDAO<Purorder, Integer>
{
  public abstract List<Purorder> getPurOrderList_dateRange(Date paramDate1, Date paramDate2);
}


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.idao.IPurorderDAO
 * JD-Core Version:    0.7.1
 */