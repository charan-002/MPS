package com.cg.mps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.cg.mps.exception.MobilePurchaseSystemException;
import com.cg.mps.util.DBConnection;
 
public class PurchaseDAOImpl implements IPurchaseDAO{
	@Override
	public Long addPurchaseDetails(String name, String emailId,
			Long phoneNumber, Integer mobileId,Integer quantity ) throws MobilePurchaseSystemException {
		try(
				Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO purchasedetails VALUES(purchase_sequence.NEXTVAL,?,?,?,SYSDATE,?)");
				PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT purchaseid FROM purchasedetails where phoneno=?");
				){
			preparedStatement.setString(1,name);
			preparedStatement.setString(2, emailId);
			preparedStatement.setLong(3,phoneNumber);
			preparedStatement.setInt(4,mobileId);
			preparedStatement2.setLong(1, phoneNumber);
			

			int n=preparedStatement.executeUpdate();
			if(n>0){
				new MobileDAOImpl().updateMobileQuantity(mobileId,quantity);
				ResultSet rs=preparedStatement2.executeQuery();
				if(rs.next()){
					
					 return rs.getLong(1);
				}
				
			
			
			}else{
				throw new MobilePurchaseSystemException("Technical error! Contact to log");
			}
		}catch(SQLException e){
			throw new MobilePurchaseSystemException("Technical Error! Contact to log ");
		}
		return null;
		

	}

}
