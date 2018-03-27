package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Customer;

public class CustomerExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		// file name for excel view
		res.addHeader("Content-Disposition",
				"attachment;filename=customers.xls");

		// data reading from model map
		List<Customer> custList = (List<Customer>) map.get("custList");

		// create sheet
		HSSFSheet sheet = book.createSheet("CUSTOMERS");

		// method call=setHead
		setHead(sheet);

		// method call=setBody
		setBody(sheet, custList);
	}

	// set head row=0
	public void setHead(HSSFSheet sheet) {
		HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Code");
		row.createCell(2).setCellValue("Name");
		row.createCell(3).setCellValue("Contract Time");
		row.createCell(4).setCellValue("Percent");
		row.createCell(5).setCellValue("Mode");
		row.createCell(6).setCellValue("Email");
		row.createCell(7).setCellValue("Type");
		row.createCell(8).setCellValue("Address");
		row.createCell(9).setCellValue("Description");
	}

	// set body Row>=1
	public void setBody(HSSFSheet sheet, List<Customer> custList) {
		int rowNum = 1;
		for (Customer cust : custList) {
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(cust.getCustId());
			row.createCell(1).setCellValue(cust.getCustCode());
			row.createCell(2).setCellValue(cust.getCustName());
			row.createCell(3).setCellValue(cust.getContractTime());
			row.createCell(4).setCellValue(cust.getPercent());
			row.createCell(5).setCellValue(cust.getCustMode());
			row.createCell(6).setCellValue(cust.getCustEmail());
			row.createCell(7).setCellValue(cust.getCustType());
			row.createCell(8).setCellValue(cust.getCustAddress());
			row.createCell(9).setCellValue(cust.getDescription());
		}
	}

}
