package com.app.dao;

import java.util.List;

import com.app.model.Documents;


public interface IDocumentsDao{
	public int saveDocuments(Documents doc);
	public List<Object[]> getFilesAndNames();
	public Documents getDocumentById(int docId);
}
