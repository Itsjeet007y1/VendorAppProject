package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDocumentsDao;
import com.app.model.Documents;
import com.app.service.IDocumentService;

@Service
public class DocumentsServiceImpl implements IDocumentService {

	@Autowired
	private IDocumentsDao dao;
	
	@Override
	public int saveDocuments(Documents doc) {
		return dao.saveDocuments(doc);
	}

	@Override
	public List<Object[]> getFilesAndNames() {
		return dao.getFilesAndNames();
	}

	@Override
	public Documents getDocumentById(int docId) {
		return dao.getDocumentById(docId);
	}
}
