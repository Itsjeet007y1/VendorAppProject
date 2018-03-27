package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.service.ILocationService;
import com.app.util.LocationUtil;

@Controller
public class LocationController {
	
	@Autowired
	private ILocationService service;
	@Autowired
	private ServletContext sc;
	@Autowired
	private LocationUtil util;
	
	// 1. To show Registration Page
	@RequestMapping("/regLocation")
	public String showRegister(){
		return "LocationRegistration";
	}
	
	// 2. To Save the Data into Database
	@RequestMapping(value="/saveLocation",method=RequestMethod.POST)
	public String insertLocation(@ModelAttribute("location")Location loc,ModelMap map) {
		int locId=service.saveLocation(loc);
		String message="Location inserted with id:"+locId;
		map.addAttribute("msg",message);
		return "LocationRegistration";
	}
	
	// 3. To get all the data from the Database
	@RequestMapping("/getLocations")
	public String getAllLocations(ModelMap map) {
		List<Location> locList=new ArrayList<>();
		locList=service.getAllLocations();
		map.addAttribute("locs", locList);
		return "LocationData";
	}
	
	// 4. To delete one row from the data
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("locId")int lid) {
		service.deleteLocation(lid);
		return "redirect: getLocations";
	}
	
	// 5. To show the Edit page to edit the data
	@RequestMapping("/editLocation")
	public String getLocationEditPage(@RequestParam("locId")int locId,ModelMap map)  {
		Location loc=service.getLocationById(locId);
		map.addAttribute("loc",loc);
		return "LocationDataEdit";
	}
	
	// 6. To update edited data to database
	@RequestMapping(value="/updateLocation",method=RequestMethod.POST)
	public String updateLocation(@ModelAttribute("location")Location loc) {
		service.updateLocation(loc);
		return "redirect:getLocations";
	}
	
	//7. Location Excel Export
	@RequestMapping("/locExcel")
	public String doExcelExport(ModelMap map) {
		List<Location> locList=service.getAllLocations();
		map.addAttribute("locList",locList);
		return "LocExcelView";
	}
	
	//8. Location PDF Export
	@RequestMapping("/locPdf")
	public String doPdfExport(ModelMap map){
		List<Location> locList=service.getAllLocations();
		map.addAttribute("locList",locList);
		return "LocPdfView";
	}
	
	//9. Chart creation pie/bar
	@RequestMapping("/locReport")
	public String generateCharts(){
		//path to save image
		String path=sc.getRealPath("/");
		//data to create chart
		List<Object[]> data=service.getLocationCountAndType();
		//call chart method
		util.generatePieChart(path, data);
		util.generateBarChart(path, data);
		//UI page to show chart
		return "LocationReports";
	}
}
