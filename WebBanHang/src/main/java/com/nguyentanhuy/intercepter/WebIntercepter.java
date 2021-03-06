package com.nguyentanhuy.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nguyentanhuy.entity.Category;
import com.nguyentanhuy.service.IGennericService;

@Component
public class WebIntercepter extends HandlerInterceptorAdapter {

	@Autowired
	private IGennericService<Category> categoryService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("category", categoryService.getAll());
		return true;
	}	
}
