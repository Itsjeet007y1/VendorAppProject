package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomerPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter arg2, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
			List<Customer> custList=(List<Customer>)map.get("custList");
			
			//create element
			Paragraph p=new Paragraph("Welcome to Customer Data Page.");
			
			//create element
			PdfPTable table=new PdfPTable(10);		
			table.addCell("ID");
			table.addCell("CODE");
			table.addCell("NAME");
			table.addCell("Contract Time");
			table.addCell("Percent");
			table.addCell("Mode");
			table.addCell("Email");
			table.addCell("Type");
			table.addCell("Address");
			table.addCell("Description");
			
			//adding data to table
			//1 object= 1 row in table
			for(Customer cust:custList) {
				table.addCell(""+cust.getCustId());
				table.addCell(cust.getCustCode());
				table.addCell(cust.getCustName());
				table.addCell(""+cust.getContractTime());
				table.addCell(""+cust.getPercent());
				table.addCell(cust.getCustMode());
				table.addCell(cust.getCustEmail());
				table.addCell(cust.getCustType());
				table.addCell(cust.getDescription());
			}
			//add element to document
			doc.add(p);
			doc.add(table);
	}
}
