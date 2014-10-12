package com.tss.ocean.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IEmployeesDAO;
import com.tss.ocean.pojo.Employees;

@Repository("employeesDAO")
public class EmployeesDAO
  extends GenericDAOImpl<Employees, Integer>
  implements IEmployeesDAO
{
	
	
	Date today=new Date();
	 String strDate=today.toString();
	 String result2;
	private Object startdate;
	 //Date result;
	
	@Override
	public List<Employees> getAlarm() {

		Session session = getSession();
		
		session.beginTransaction();
	//return	session.createQuery("from Employees e where e.currstock < 15 ").list();
	//return	session.createQuery("Now() + interval 1 day from Employees e where WHERE passportExpiryDate = Now() + interval 1 day ").list();
		SimpleDateFormat sdfSource = new SimpleDateFormat("dd/MM/yyyy") ;
	    
	    //parse the string into Date object
		try {
			today = sdfSource.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    //create SimpleDateFormat object with desired date format
	    SimpleDateFormat sdfDestination = new SimpleDateFormat("dd/MM/yyyy");
	   
	    //parse the date into another format
	    strDate = sdfDestination.format(today);
	    try {
			 startdate=sdfDestination.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
			
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, +1);
		Date	 result = cal.getTime();
		System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"+result);
		try {
			result2=result.toString();
			result= sdfSource.parse(result2);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		  result2=sdfDestination.format(result);
		 System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN"+result2);
		
String hql = "from Employees e where e.passportExpiryDate BETWEEN ?   AND  ?";
					
	Query query = session.createQuery(hql)
	.setParameter(0, startdate)
	.setParameter(1, result);
	
	List results = query.list();
	System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK"+results.size());

	return results;
	}
	

}




/* Location:           E:\proj\WEB-INF\classes\

 * Qualified Name:     com.tss.ocean.dao.EmployeesDAO

 * JD-Core Version:    0.7.1

 */