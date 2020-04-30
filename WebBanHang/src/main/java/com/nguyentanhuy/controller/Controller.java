package com.nguyentanhuy.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
		try {
			Document doc = Jsoup.connect("https://vnexpress.net").get();
			Elements elements = doc.getElementsByTag("a");
			for (Element element : elements) {
				String href = element.attr("href");
				String text = element.text();
				System.out.println(text);
				System.out.println("\t" + href);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(value = "product/{url}/{id}", method = RequestMethod.GET)
	public String product(ModelMap model, @PathVariable("id") Long id) {
		model.addAttribute("product", productService.findById(id));
		return "item";
	}

	@RequestMapping(value = "category/{url}/{id}", method = RequestMethod.GET)
	public String category(ModelMap model, @PathVariable("id") Long id) {
		model.addAttribute("product", categoryService.findById(id).getListProduct());
		return "home";
	}

	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public String checkOut() {
		return "checkout";
	}
}
