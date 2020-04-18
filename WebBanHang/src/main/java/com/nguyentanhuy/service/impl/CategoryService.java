package com.nguyentanhuy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyentanhuy.dao.IGennericDAO;
import com.nguyentanhuy.entity.Category;
import com.nguyentanhuy.service.IGennericService;

@Service
public class CategoryService implements IGennericService<Category>{

	@Autowired
	private IGennericDAO<Category> categoryDAO;
	
	public boolean create(Category object) {
		return categoryDAO.create(object);
	}

	public boolean update(Category object) {
		return categoryDAO.update(object);
	}

	public boolean delete(Category object) {
		return categoryDAO.delete(object);
	}

	public Category findById(Long id) {
		return categoryDAO.findById(id);
	}

	public List<Category> getAll() {
		return categoryDAO.getAll();
	}

}
