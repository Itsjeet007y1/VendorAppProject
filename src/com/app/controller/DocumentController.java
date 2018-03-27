package com.app.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.app.model.Documents;
import com.app.service.IDocumentService;

@Controller
public class DocumentController {

	@Autowired
	private IDocumentService service;
	
	//1. To show the Registration
	@RequestMapping("/regDocument")
	public String regDocument(ModelMap map) {
		List<Object[]> list=service.getFilesAndNames();
		map.addAttribute("list",list);
		return "Documents";
	}
	
	//2.To upload the file
	@RequestMapping(value="/uploadDocument",method=RequestMethod.POST)
	public String uploadDocument(@RequestParam("fileId")int fileId, @RequestParam("fileOb")CommonsMultipartFile cmf) {
		if(cmf!=null){
			Documents doc=new Documents();
			doc.setFileId(fileId);
			doc.setFileName(cmf.getOriginalFilename());
			doc.setFileData(cmf.getBytes());
			service.saveDocuments(doc);
		}
		return "redirect:regDocument";
	}
	
	//3. Download the document
	@RequestMapping("/downloadDocument")
	public void downloadDocument(@RequestParam("fileId")int docId,HttpServletResponse res,ModelMap map){
		Documents doc=new Documents();
		doc=service.getDocumentById(docId);
		String fileName=doc.getFileName();	
		byte[] fileData=doc.getFileData();
		//add 
		res.addHeader("Content-Disposition", "attachment;filename="+fileName);
		try {
			FileCopyUtils.copy(fileData, res.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
