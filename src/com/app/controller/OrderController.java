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

import com.app.model.Order;
import com.app.service.IOrderService;


@Controller
public class OrderController {
	
	@Autowired
	private IOrderService service;
	
	//1. Get Order register page
	@RequestMapping("/regOrder")
	public String showRegisterOrderPage(){
		return "OrderRegister";
	}
	
	//2. Save Order
	@RequestMapping(value="/saveOrder",method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order")Order order,ModelMap map){
		int orderId=service.saveOrder(order);
		String msg="Order saved with id:"+orderId;
		map.addAttribute("msg",msg);
		return "OrderRegister";
	}
	
	//3. Get all the Orders
	@RequestMapping("/getAllOrders")
	public String getAllOrders(ModelMap map) {
		List<Order> orders=new ArrayList<Order>();
		orders=service.getAllOrders();
		map.addAttribute("orders",orders);
		return "OrderData";
	}
	
	//4. Delete one Order
	@RequestMapping("/deleteOrder")
	public String deletOrder(@RequestParam("orderId")int orderId) {
		service.deleteOrder(orderId);
		return "redirect:getAllOrders";
	}
	
	//5. Show Order data edit page
	@RequestMapping("/editOrder")
	public String editOrder(@RequestParam("orderId")int orderId,ModelMap map) {
		Order order=new Order();
		order=service.getOrderById(orderId);
		map.addAttribute("order",order);
		return "OrderDataEdit";
	}
	
	//6.update Order
	@RequestMapping("/updateOrder")
	public String updateOrder(@ModelAttribute("order")Order order) {
		service.updateOrder(order);
		return "redirect:getAllOrders";
	}
	
	//7. Excel Export
	@RequestMapping("/orderExcel")
	public String doExcelExport(ModelMap map) {
		List<Order> orderList=service.getAllOrders();
		map.addAttribute("orderList",orderList);
		return "OrderExcelView";
	}
	
	//8. Pdf Export
	@RequestMapping("/orderPdf")
	public String doPdfExport(ModelMap map) {
		List<Order> orderList=service.getAllOrders();
		map.addAttribute("orderList",orderList);
		return "OrderPdfView";
	}
}
