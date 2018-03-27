package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Order;

public class OrderExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
			
		//file name for excel view
		res.addHeader("Content-Disposition", "attachment;filename=Orders.xls");
		
		//data reading from model map
		List<Order> orderList=(List<Order>)map.get("orderList");
		
		//create sheet
		HSSFSheet sheet=book.createSheet("Orders");
		
		//call setHead() method
		setHead(sheet);
		//call setBody()	 method
		setBody(sheet,orderList);
	}
	public void setHead(HSSFSheet sheet){
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("ORDER COST");
		row.createCell(3).setCellValue("MAX DISCOUNT");
	}

	//set body row>=1
	public void setBody(HSSFSheet sheet, List<Order> orderList) {
		int rowNum=1;
		for(Order order:orderList) {
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(order.getOrderId());
			row.createCell(1).setCellValue(order.getOrderCode());
			row.createCell(2).setCellValue(order.getOrderCost());
			row.createCell(3).setCellValue(order.getMaxDiscount());
		}
	}
}
