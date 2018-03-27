package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.util.CoDecUtil;

@Component
public class CustomerValidator {
	@Autowired
	private CoDecUtil codecUtil;
	
	public boolean isPwdAndTokenValide(String reqPwd,String reqToken, Customer cust) {
		boolean isValid=false;

		//read encoded value from DB object
		String encPwd=cust.getPwd();
		String encToken=cust.getToken();
		
		//do decode db password
		String dbPwd=codecUtil.doDecode(encPwd);
		String dbToken=codecUtil.doDecode(encToken);
		
		//do decode requested password
		String rpwd=codecUtil.doDecode(reqPwd);
		String rtok=codecUtil.doDecode(reqToken);
	
		//compare request and db values
		if(dbPwd.equals(rpwd) && dbToken.equals(rtok)) {
			isValid=true;
		}
		return isValid;
	}
	
	public boolean isCustomerSeller(Customer cust){
		return "Seller".equalsIgnoreCase(cust.getCustType());
	}
	
	public boolean isCustomerConsumer(Customer cust){
		return "Consumer".equalsIgnoreCase(cust.getCustType());
	}
}
