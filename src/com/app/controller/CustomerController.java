package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CodeUtil;
import com.app.util.CoDecUtil;
import com.app.util.CommonUtil;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerService service;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CoDecUtil codecUtil;
	@Autowired
	private CommonUtil commonUtil;
	
	//1. To show Registration page
	@RequestMapping("/regCustomer")
	public String showRegPage() {
		return "CustomerRegistration";
	}
	
	/*//2. To save Customer Data
	@RequestMapping(value="/saveCustomer",method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer")Customer cust,ModelMap map){
		int custId=service.saveCustomer(cust);
		String msg="Customer Saved with id :"+custId;
		map.addAttribute("msg", msg);
		return "CustomerRegistration";
	}*/
	
	//2. To save Customer Data
		@RequestMapping(value="/saveCustomer",method=RequestMethod.POST)
		public String saveCustomer(@ModelAttribute("customer")Customer cust,ModelMap map){
			//generate password and token
			String pwd=codeUtil.getPassword();
			String token=codeUtil.getTocken();
			//do encode password and token
			String encPwd=codecUtil.doEncode(pwd);
			String encToken=codecUtil.doEncode(token);
			//set encoded value to customer object
			cust.setPwd(encPwd);
			cust.setToken(encToken);
			//save the customer object
			service.saveCustomer(cust);
			//send email
			String text="ID is: "+cust.getCustId()+" Username is: "+cust.getCustEmail()+" Password is: "+pwd+" Toekn is: "+token;
			boolean flag=commonUtil.sendMail(cust.getCustEmail(), "Registered as Customer", text,null);
			//send message to UI
			String message=cust.getCustId()+" Registered";
			if(flag){
				message+=" Email also Sent";
			}
			map.addAttribute("msg",message);
			return "CustomerRegistration";
		}
	
	//3. To show all the customers
	@RequestMapping("/getAllCustomers")
	public String getAllCustomers(ModelMap map){
		List<Customer> custList=new ArrayList<Customer>();
		custList=service.getAllCustomers();
		map.addAttribute("custs",custList);
		return "CustomerData";
	}
	
	//4. To Delete one Customer
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("custId")int custId) {
		service.deleteCustomer(custId);
		return "redirect:getAllCustomers";
	}
	
	//5. To show Data edit page
	@RequestMapping("/editCustomer")
	public String editCustomer(@RequestParam("custId")int custId,ModelMap map) {
		Customer cust=new Customer();
		cust=service.getCustomerById(custId);
		map.addAttribute("cust",cust);
		return "CustomerDataEdit";
	}
	
	//6. To update the details
	@RequestMapping(value="/updateCustomer",method=RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer")Customer cust){
		service.updateCustomer(cust);
		return "redirect:getAllCustomers";
	}
	
	//7. Location Excel Export
		@RequestMapping("/custExcel")
		public String doExcelExport(ModelMap map) {
			List<Customer> custList=service.getAllCustomers();
			map.addAttribute("custList",custList);
			return "CustExcelView";
		}
		
		//8. Location PDF Export
		@RequestMapping("/custPdf")
		public String doPdfExport(ModelMap map){
			List<Customer> custList=service.getAllCustomers();
			map.addAttribute("custList",custList);
			return "CustPdfView";
		}
}
