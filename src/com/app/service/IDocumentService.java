package com.app.service;

import java.util.List;

import com.app.model.Documents;

public interface IDocumentService {
	public int saveDocuments(Documents doc);
	public List<Object[]> getFilesAndNames();
	public Documents getDocumentById(int docId);
}
