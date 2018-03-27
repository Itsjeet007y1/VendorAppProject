package com.app.provider;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Order;
import com.app.service.ICustomerService;
import com.app.service.IOrderService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Component
@Path("/order")
public class OrderServiceProvider {
	
	@Autowired
	private ICustomerService custService;
	@Autowired
	private CustomerValidator custValidator;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IOrderService OrderService;

	@Path("/saveOrder")
	@POST
	public String saveOrder(
								@HeaderParam("user")String  email,
								@HeaderParam("pwd")String password,
								@HeaderParam("token")String accToken,
								String orderJson) {
		
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
		
		if(null==orderJson || "".equals(orderJson.trim())){
			return "Empty Order Details (JSON) provided";
		}
		
		//read customer based on email ID
		Customer cust=custService.getCustomerByEmail(email);
		
		if(cust==null){
			return "User not exist in application";
		}
		
		// is type seller??
		if(!custValidator.isCustomerConsumer(cust)){
			return "Customer can not perform this operation (Customer has no authority)";
		}
		
		//check password and token
		if(!custValidator.isPwdAndTokenValide(password, accToken, cust)){
			return "Invailid Password/Token details in request";
		}
		
		//Order save process
		Object ob=jsonUtil.convertJsonToObject(orderJson, Order.class);
		
		if(ob==null){
			return "Invalid Order-JSON format is provided";
		}
		
		//if valid continue
		Order order=null;
		if(ob instanceof Order){
			order=(Order)ob;
		}
		
		if(order==null){
			return "Data may not be Order..";
		}
		
		//set custID to Order object
		order.setOrderId(cust.getCustId());
		
		int orderId=OrderService.saveOrder(order);
		return "Order saved with id:"+orderId;
	}
}
