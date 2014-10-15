package com.tss.ocean.idao;

import java.util.List;

import com.techshark.hibernate.ibase.GenericDAO;
import com.tss.ocean.pojo.Invoice;

public abstract interface IInvoiceDAO
	extends GenericDAO<Invoice, Integer>{

	public List<Invoice> getCollectionByType(Boolean isCashMode);

}
