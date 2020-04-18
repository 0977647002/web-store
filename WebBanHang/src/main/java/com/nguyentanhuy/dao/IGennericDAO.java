package com.nguyentanhuy.dao;

import java.util.List;

public interface IGennericDAO<T> {
	// create
	public boolean create(T object);

	// update
	public boolean update(T object);

	// delete
	public boolean delete(T object);

	// find by id
	public T findById(Long id);

	// load list category
	public List<T> getAll();
}
