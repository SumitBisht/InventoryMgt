package com.tss.ocean.dao;

import java.util.List;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IInvoiceDAO;
import com.tss.ocean.pojo.Invoice;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
/**
 * Modifies the facility to get invoices on the basis of cash/bank mode
 * of payment of the invoice in addition to the available methods.
 * @author sumit bisht
 *
 */
@Repository("invoiceDAO")
public class InvoiceDAO
  extends GenericDAOImpl<Invoice, Integer>
  implements IInvoiceDAO
{

	static final Logger log = LoggerFactory.getLogger(GenericDAOImpl.class);
	@Override
	public List<Invoice> getCollectionByType(Boolean isCashMode) {
		Session session = getSession();
		List<Invoice> invoices = null;
		try {
			invoices = session.createQuery("from Invoice i where i.boxMode=:modeType").setParameter("modeType", isCashMode).list();
		} catch (HibernateException e) {
			log.error("error occured in fetching the data: "+e);
		} finally{
			if(session.isOpen()){
				session.close();
			}
		}
		return invoices;
	}
}
