package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.ICountryDAO;
import com.tss.ocean.pojo.Country;
import org.springframework.stereotype.Repository;

@Repository("countryDAO")
public class CountryDAO
  extends GenericDAOImpl<Country, Integer>
  implements ICountryDAO
{}


/* Location:           E:\proj\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.CountryDAO
 * JD-Core Version:    0.7.1
 */