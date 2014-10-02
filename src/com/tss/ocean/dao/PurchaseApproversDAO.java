package com.tss.ocean.dao;

import com.techshark.hibernate.base.GenericDAOImpl;
import com.tss.ocean.idao.IPurchaseApproverDAO;
import com.tss.ocean.pojo.PurordApprovers;
import org.springframework.stereotype.Repository;

@Repository("purchaseApproversDAO")
public class PurchaseApproversDAO
  extends GenericDAOImpl<PurordApprovers, Integer>
  implements IPurchaseApproverDAO
{}


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.dao.PurchaseApproversDAO
 * JD-Core Version:    0.7.1
 */