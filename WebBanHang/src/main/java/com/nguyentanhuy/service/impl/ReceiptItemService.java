package com.nguyentanhuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyentanhuy.dao.IGennericDAO;
import com.nguyentanhuy.entity.ReceiptItem;
import com.nguyentanhuy.service.IGennericService;

@Service
public class ReceiptItemService implements IGennericService<ReceiptItem> {

	@Autowired
	private IGennericDAO<ReceiptItem> receiptItemDAO;
	
	public boolean create(ReceiptItem object) {
		return receiptItemDAO.create(object);
	}

	public boolean update(ReceiptItem object) {
		return receiptItemDAO.update(object);
	}

	public boolean delete(ReceiptItem object) {
		return receiptItemDAO.delete(object);
	}

	public ReceiptItem findById(Long id) {
		return receiptItemDAO.findById(id);
	}

	public List<ReceiptItem> getAll() {
		return receiptItemDAO.getAll();
	}

}
