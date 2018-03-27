package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentsDao;
import com.app.model.Documents;

@Repository
public class DocumentDaoImpl implements IDocumentsDao {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveDocuments(Documents doc) {
		return (Integer)ht.save(doc);
	}

	@Override
	public List<Object[]> getFilesAndNames() {
		String query="select fileId, fileName from com.app.model.Documents";
		List<Object[]> list=ht.find(query);
		return list;
	}

	@Override
	public Documents getDocumentById(int docId) {
		return ht.get(Documents.class, docId);
	}	
}
