package com.nguyentanhuy.service;

import java.util.List;

public interface IGennericService<T> {
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
