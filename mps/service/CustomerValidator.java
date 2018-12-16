package com.cg.mps.service;

import java.util.regex.Pattern;


public class CustomerValidator {
	public CustomerValidator(){
		
	}

	public Boolean isValidCustomerName(String name){
		String regex1="^[A-Z][a-zA-Z ]{0,19}$";	 
	 
		return Pattern.matches(regex1,name);
		
	}
	
	public Boolean isValidCustomerEmail(String email){
		String regex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		return Pattern.matches(regex,email);
	}
	
	public Boolean isValidCustomerMobile(Long phnnumber){
		String regex="^[1-9][0-9]{9}$";
		 String mobile= Long.toString(phnnumber);

		return Pattern.matches(regex,mobile);
	}
	public Boolean isValidMobileId(Integer mobileid){
		String regex="^[1-9][0-9]{3}$";
		String mobileidString= Long.toString(mobileid);
		return Pattern.matches(regex,mobileidString);
		
	}

}
