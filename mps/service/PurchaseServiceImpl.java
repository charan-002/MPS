package com.cg.mps.service;

import com.cg.mps.bean.Mobile;
import com.cg.mps.dao.IPurchaseDAO;
import com.cg.mps.dao.MobileDAOImpl;
import com.cg.mps.dao.PurchaseDAOImpl;
import com.cg.mps.exception.MobilePurchaseSystemException;

public class PurchaseServiceImpl implements IPurchaseservice{
	private IPurchaseDAO purchaseDAO=new PurchaseDAOImpl();
	@Override
	public Long addPurchaseDetails(String name, String emailId,
			Long phoneNumber, Integer mobileId,Integer quantity)
					throws MobilePurchaseSystemException {
		try{
		Mobile mobile=new MobileDAOImpl().getMobileDetails(mobileId);
		if(mobile.getQuantity()>0){
		Long purchaseid=purchaseDAO.addPurchaseDetails(name, emailId, phoneNumber, mobileId,quantity);
		return purchaseid;
	}else{
		
		throw new MobilePurchaseSystemException("Out of Stock..");
	}
		}catch(MobilePurchaseSystemException e){
			throw new MobilePurchaseSystemException();
		}
		
	}
}