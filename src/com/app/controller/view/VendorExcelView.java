package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Vendor;

public class VendorExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		//file name for excel view
		res.addHeader("Content-Disposition", "attachment;filename=vendors.xls");
		
		//read data from modem map
		List<Vendor> venList=(List<Vendor>)map.get("venList");
		
		//create sheet
		HSSFSheet sheet=book.createSheet("VENDORS");
		
		// call setHead
		setHead(sheet);
		//call setBody
		setBody(sheet,venList);
	}
	
	//set head
	public void setHead(HSSFSheet sheet) {
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("NAME");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("CONTACT");
		row.createCell(6).setCellValue("ADDRESS");
	}
	
	//set body row>=1
	public void setBody(HSSFSheet sheet,List<Vendor> venList) {
		int rowNum=1;
		for(Vendor ven:venList) {
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(ven.getVenId());
			row.createCell(1).setCellValue(ven.getVenCode());
			row.createCell(2).setCellValue(ven.getVenName());
			row.createCell(3).setCellValue(ven.getVenType());
			row.createCell(4).setCellValue(ven.getVenEmail());
			row.createCell(5).setCellValue(ven.getVenContact());
			row.createCell(6).setCellValue(ven.getVenAddress());
		}
	}
	
}
