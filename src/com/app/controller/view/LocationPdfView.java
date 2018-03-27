package com.app.controller.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocationPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document doc,
			PdfWriter arg2, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
			List<Location> locList=(List<Location>)map.get("locList");
			
			//create paragraph
			Paragraph p=new Paragraph("Welcome to Location Data Page.");
			
			//create element
			PdfPTable table=new PdfPTable(4);		
			table.addCell("ID");
			table.addCell("CODE");
			table.addCell("NAME");
			table.addCell("TYPE");
			
			//adding data to table
			//1 object= 1 row in table
			for(Location loc:locList) {
				table.addCell(""+loc.getLocId());
				table.addCell(loc.getLocCode());
				table.addCell(loc.getLocName());
				table.addCell(loc.getLocType());
			}
			//add element to document
			doc.add(p);
			doc.add(table);
	}
}
