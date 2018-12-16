package com.cg.mps.service;

import com.cg.mps.exception.MobilePurchaseSystemException;

public interface IPurchaseservice {
	public abstract Long addPurchaseDetails(String name,String emailId,Long phoneNumber,Integer mobileId,Integer quantity)throws MobilePurchaseSystemException;
}