package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	public IVendorDao dao;
	
	@Override
	public int saveVendor(Vendor ven) {
		return dao.saveVendor(ven);
	}

	@Override
	public void updateVendor(Vendor ven) {
		dao.updateVendor(ven);

	}

	@Override
	public void deleteVendor(int venId) {
		dao.deleteVendor(venId);

	}

	@Override
	public Vendor getVendorById(int venId) {
		return dao.getVendorById(venId);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return dao.getAllVendors();
	}

}
