package com.nguyentanhuy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nguyentanhuy.entity.Category;
import com.nguyentanhuy.entity.Product;
import com.nguyentanhuy.service.IGennericService;

@org.springframework.stereotype.Controller
public class Controller {

	@Autowired
	private IGennericService<Product> productService;
	@Autowired
	private IGennericService<Category> categoryService;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		model.addAttribute("product", productService.getAll());
		return "home";
	}

	@RequestMapping(value = "product/{url}/{id}", method = RequestMethod.GET)
	public String product(ModelMap model,
			@PathVariable("id") Long id) {
		model.addAttribute("product", productService.findById(id));
		return "item";
	}
	
	@RequestMapping(value = "category/{url}/{id}", method = RequestMethod.GET)
	public String category(ModelMap model,
			@PathVariable("id") Long id) {
		model.addAttribute("product", categoryService.findById(id).getListProduct());
		return "home";
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public String checkOut() {
		return "checkout";
	}
}
