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

import com.app.model.Item;
import com.app.service.IItemService;


@Controller
public class ItemController {
	
	@Autowired
	private IItemService service;
	
	//1. Get Item register page
	@RequestMapping("/regItem")
	public String showRegisterItemPage(){
		return "ItemRegister";
	}
	
	//2. Save item
	@RequestMapping(value="/saveItem",method=RequestMethod.POST)
	public String saveItem(@ModelAttribute("item")Item itm,ModelMap map){
		int itemId=service.saveItem(itm);
		String msg="Item saved with id:"+itemId;
		map.addAttribute("msg",msg);
		return "ItemRegister";
	}
	
	//3. Get all the items
	@RequestMapping("/getAllItems")
	public String getAllItems(ModelMap map) {
		List<Item> itms=new ArrayList<Item>();
		itms=service.getAllItems();
		map.addAttribute("itms",itms);
		return "ItemData";
	}
	
	//4. Delete one item
	@RequestMapping("/deleteItem")
	public String deletItem(@RequestParam("itemId")int itemId) {
		service.deleteItem(itemId);
		return "redirect:getAllItems";
	}
	
	//5. Show Item data edit page
	@RequestMapping("/editItem")
	public String editItem(@RequestParam("itemId")int itemId,ModelMap map) {
		Item itm=new Item();
		itm=service.getItemById(itemId);
		map.addAttribute("itm",itm);
		return "ItemDataEdit";
	}
	
	//6.update Item
	@RequestMapping("/updateItem")
	public String updateItem(@ModelAttribute("item")Item item) {
		service.updateItem(item);
		return "redirect:getAllItems";
	}
	
	//7. Excel Export
	@RequestMapping("/itmExcel")
	public String doExcelExport(ModelMap map) {
		List<Item> itmList=service.getAllItems();
		map.addAttribute("itmList",itmList);
		return "ItmExcelView";
	}
	
	//8. Pdf Export
	@RequestMapping("/itmPdf")
	public String doPdfExport(ModelMap map) {
		List<Item> itmList=service.getAllItems();
		map.addAttribute("itmList",itmList);
		return "ItmPdfView";
	}
}
