package com.cg.mps.dao;

import com.cg.mps.exception.MobilePurchaseSystemException;

public interface IPurchaseDAO {
	public abstract Long addPurchaseDetails(String name,String emailId,Long phoneNumber,Integer mobileId,Integer quantity)throws MobilePurchaseSystemException;
}