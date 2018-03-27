package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter writer, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {
			
		//get object from map
		List<Item> itmList=(List<Item>)map.get("itmList");
		
		//create Paragraph
		Paragraph p=new Paragraph("Welcome to PDF page of ITEMS");
		
		//create table
		
		PdfPTable table=new PdfPTable(7);
		table.addCell("ID");
		table.addCell("CODE");
		table.addCell("NAME");
		table.addCell("BASE COST");
		table.addCell("BAR CODE");
		table.addCell("DISCOUNT");
		table.addCell("MANUFACTURED");
		
		//add data to cells
		for(Item itm:itmList) {
			table.addCell(""+itm.getItemId());
			table.addCell(itm.getItemCode());
			table.addCell(itm.getItemName());
			table.addCell(""+itm.getBaseCost());
			table.addCell(itm.getBarCode());
			table.addCell(""+itm.getMaxDiscount());
			table.addCell(itm.getMfg());
		}
		
		//add to document table and paragraph
		document.add(p);
		document.add(table);
	}

}
