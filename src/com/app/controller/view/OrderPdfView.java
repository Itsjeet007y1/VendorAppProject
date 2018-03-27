package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Order;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter writer, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {
			
		//get object from map
		List<Order> orderList=(List<Order>)map.get("orderList");
		
		//create Paragraph
		Paragraph p=new Paragraph("Welcome to PDF page of Orders");
		
		//create table
		
		PdfPTable table=new PdfPTable(4);
		table.addCell("ID");
		table.addCell("CODE");
		table.addCell("ORDER COST");
		table.addCell("MAX DISCOUNT");
		//add data to cells
		for(Order order:orderList) {
			table.addCell(""+order.getOrderId());
			table.addCell(order.getOrderCode());
			table.addCell(""+order.getOrderCost());
			table.addCell(""+order.getMaxDiscount());
		}
		
		//add to document table and paragraph
		document.add(p);
		document.add(table);
	}

}
