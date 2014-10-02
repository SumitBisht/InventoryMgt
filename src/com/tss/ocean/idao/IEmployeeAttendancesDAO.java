package com.tss.ocean.idao;

import com.techshark.hibernate.ibase.GenericDAO;
import com.tss.ocean.pojo.EmployeeAttendances;
import java.util.Date;
import java.util.List;

public abstract interface IEmployeeAttendancesDAO
  extends GenericDAO<EmployeeAttendances, Integer>
{
  public abstract List<EmployeeAttendances> getEmployeeAttendanceBetweenDates(Date paramDate1, Date paramDate2);
}


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.idao.IEmployeeAttendancesDAO
 * JD-Core Version:    0.7.1
 */