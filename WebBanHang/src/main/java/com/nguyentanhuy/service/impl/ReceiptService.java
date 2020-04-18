package com.nguyentanhuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyentanhuy.dao.IGennericDAO;
import com.nguyentanhuy.entity.Receipt;
import com.nguyentanhuy.service.IGennericService;

@Service
public class ReceiptService implements IGennericService<Receipt> {

	@Autowired
	private IGennericDAO<Receipt> receiptDAO;
	
	public boolean create(Receipt object) {
		return receiptDAO.create(object);
	}

	public boolean update(Receipt object) {
		return receiptDAO.update(object);
	}

	public boolean delete(Receipt object) {
		return receiptDAO.delete(object);
	}

	public Receipt findById(Long id) {
		return receiptDAO.findById(id);
	}

	public List<Receipt> getAll() {
		return receiptDAO.getAll();
	}

}
