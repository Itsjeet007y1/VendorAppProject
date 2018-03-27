package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.util.CommonUtil;

@Controller
public class VendorController {
	
	@Autowired
	private IVendorService service;
	@Autowired
	private CommonUtil commonUtil;
	
	//1. To show Registration Page
	@RequestMapping("/regVendor")
	public String showVendorPage() {
		return "VendorRegistration";
	}
	
	// 2. To Save the Data into Database
	@RequestMapping(value="/saveVendor",method=RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor")Vendor ven,ModelMap map,@RequestParam("fobj")CommonsMultipartFile file) {
		String msg;
		int venId=service.saveVendor(ven);
		boolean flag=commonUtil.sendMail(ven.getVenEmail(), "Hello Vendor", "Your Id is:+"+venId, file);
		if(flag==true)
			msg="Vendor data saved with id:"+venId+" And Email send Successfully to "+ven.getVenEmail();
		else
			msg="Vendor data saved with id:"+venId;
		map.addAttribute("msg",msg);
		return "VendorRegistration";
	}
	
	//3. To show The Data of database
	 @RequestMapping("/getAll")
	public String showVendor(ModelMap map) {
		 List<Vendor> venList=null;
		 venList=service.getAllVendors();
		 map.addAttribute("vens",venList);
		return "VendorData";
	}
	 
	 //4. To Delete one vendor
	 @RequestMapping("/deleteVendor")
	 public String deleteVendor(@RequestParam("venId")int venId) {
		 service.deleteVendor(venId);
		 return "redirect:getAll";
	 }
	 
	 //5. To show Vendor Edit Page
	 @RequestMapping("/editVendor")
	 public String showEditPage(@RequestParam("venId")int venId,ModelMap map) {
		 Vendor ven=service.getVendorById(venId);
		 map.addAttribute("ven",ven);
		 return "VendorDataEdit";
	 }
	 
	 //6. To update Vendor Data
	 @RequestMapping("/updateVendor")
	 public String updateVendor(@ModelAttribute("vendor")Vendor ven) {
		 service.updateVendor(ven);
		 return "redirect:getAll";
	 }
	 
	 //7. Location Excel Export
	 @RequestMapping("/venExcel")
	 public String doExcelExport(ModelMap map){
		 List<Vendor> venList=service.getAllVendors();
		 map.addAttribute("venList",venList);
		 return "VenExcelView";
	 }
	 
	 //8. Location Pdf Export
	 @RequestMapping("/venPdf")
	 public String doPdfExport(ModelMap map){
		 List<Vendor> venList=service.getAllVendors();
		 map.addAttribute("venList",venList);
		 return "VenPdfView";
	 }
}
