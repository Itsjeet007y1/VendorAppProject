package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Location;

public class LocationExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		// file name for excel view
		res.addHeader("Content-Disposition",
				"attachment;filename=locations.xls");

		// data reading from model map
		List<Location> locList = (List<Location>) map.get("locList");

		// create sheet
		HSSFSheet sheet = book.createSheet("LOCATIONS");

		// method call=setHead
		setHead(sheet);

		// method call=setBody
		setBody(sheet, locList);
	}

	// set head row=0
	public void setHead(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Code");
		row.createCell(2).setCellValue("Name");
		row.createCell(3).setCellValue("Type");
	}
	
	//set body Row>=1
	public void setBody(HSSFSheet sheet, List<Location> locList) {
		int rowNum=1;
		for(Location loc:locList) {
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(loc.getLocId());
			row.createCell(1).setCellValue(loc.getLocCode());
			row.createCell(2).setCellValue(loc.getLocName());
			row.createCell(3).setCellValue(loc.getLocType());
		}
	}

}
