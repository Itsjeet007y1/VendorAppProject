package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/item")
public class ItemServiceProvider {
	
	@Autowired
	private ICustomerService custService;
	@Autowired
	private CustomerValidator custValidator;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IItemService itemService;

	@Path("/saveItem")
	@POST
	public String saveItem(
								@HeaderParam("user")String  email,
								@HeaderParam("pwd")String password,
								@HeaderParam("token")String accToken,
								String itemJson) {
		
		//reject empty or null values
		if(null==email || "".equals(email.trim())) {
			return "Invalid UserName Provided";
		}
		
		if(null==password || "".equals(password.trim())){
			return "Invalid Password Provided";
		}
		
		if(null==accToken || "".equals(accToken.trim())){
			return "Invalid Access Token Provided";
		}
		
		if(null==itemJson || "".equals(itemJson.trim())){
			return "Empty Item Details (JSON) provided";
		}
		
		//read customer based on email ID
		Customer cust=custService.getCustomerByEmail(email);
		
		if(cust==null){
			return "User not exist in application";
		}
		
		// is type seller??
		if(!custValidator.isCustomerSeller(cust)){
			return "Customer can not perform this operation (Customer has no authority)";
		}
		
		//check password and token
		if(!custValidator.isPwdAndTokenValide(password, accToken, cust)){
			return "Invailid Password/Token details in request";
		}
		
		//ITEM save process
		Object ob=jsonUtil.convertJsonToObject(itemJson, Item.class);
		
		if(ob==null){
			return "Invalid Item-JSON format is provided";
		}
		
		//if valid continue
		Item itm=null;
		if(ob instanceof Item){
			itm=(Item)ob;
		}
		
		if(itm==null){
			return "Data may not be item..";
		}
		
		//set custID to item object
		itm.setItemId(cust.getCustId());
		
		int itemId=itemService.saveItem(itm);
		return "Item saved with id:"+itemId;
	}
}
