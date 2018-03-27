package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Item;

public class ItemExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> map,
			HSSFWorkbook book, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
			
		//file name for excel view
		res.addHeader("Content-Disposition", "attachment;filename=items.xls");
		
		//data reading from modelmap
		List<Item> itmList=(List<Item>)map.get("itmList");
		
		//create sheet
		HSSFSheet sheet=book.createSheet("ITEMS");
		
		//call setHead() method
		setHead(sheet);
		//call setBody()	 method
		setBody(sheet,itmList);
	}
	public void setHead(HSSFSheet sheet){
		HSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("NAME");
		row.createCell(3).setCellValue("BASE COST");
		row.createCell(4).setCellValue("BAR CODE");
		row.createCell(5).setCellValue("DISCOUNT");
		row.createCell(6).setCellValue("MANUFACTURED");
	}

	//set body row>=1
	public void setBody(HSSFSheet sheet, List<Item> itmList) {
		int rowNum=1;
		for(Item itm:itmList) {
			HSSFRow row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(itm.getItemId());
			row.createCell(1).setCellValue(itm.getBarCode());
			row.createCell(2).setCellValue(itm.getItemName());
			row.createCell(3).setCellValue(itm.getBaseCost());
			row.createCell(4).setCellValue(itm.getBarCode());
			row.createCell(5).setCellValue(itm.getMaxDiscount());
			row.createCell(6).setCellValue(itm.getMfg());
		}
	}
}
