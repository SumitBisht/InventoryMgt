package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IInvoiceDAO;
import com.tss.ocean.pojo.Invoice;

import org.springframework.stereotype.Repository;

@Repository("invoiceDAO")
public class InvoiceDAO
  extends GenericDAOImpl<Invoice, Integer>
  implements IInvoiceDAO
{}
