package com.nguyentanhuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyentanhuy.dao.IGennericDAO;
import com.nguyentanhuy.entity.Product;
import com.nguyentanhuy.service.IGennericService;

@Service
public class ProductService implements IGennericService<Product> {

	@Autowired
	private IGennericDAO<Product> productDAO;

	public boolean create(Product object) {
		return productDAO.create(object);
	}

	public boolean update(Product object) {
		return productDAO.update(object);
	}

	public boolean delete(Product object) {
		return productDAO.delete(object);
	}

	public Product findById(Long id) {
		return productDAO.findById(id);
	}

	public List<Product> getAll() {
		return productDAO.getAll();
	}
}
