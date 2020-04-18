package com.nguyentanhuy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyentanhuy.entity.Cart;
import com.nguyentanhuy.entity.Product;
import com.nguyentanhuy.entity.Receipt;
import com.nguyentanhuy.entity.ReceiptItem;
import com.nguyentanhuy.service.IGennericService;

@Controller
@RequestMapping(value = "cart")
public class ControllerCart {
	
	@Autowired
	private IGennericService<Product> productService;
	
	@Autowired
	private IGennericService<Receipt> receiptService;
	
	@Autowired
	private IGennericService<ReceiptItem> receiptItemService;
	
	@RequestMapping(value = "add/{productId}", method = RequestMethod.GET)
	public String viewAdd(ModelMap model, HttpSession session, 
			@PathVariable("productId") Long id) {
		HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
			cartItems = new HashMap<Long, Cart>();
		}
		Product product = productService.findById(id);
		if (product != null) {
			if (cartItems.containsKey(id)) {
				Cart item = cartItems.get(id);
				item.setProduct(product);
				item.setQuantity(item.getQuantity() + 1);
				cartItems.put(id, item);
			} else {
				Cart item = new Cart();
				item.setProduct(product);
				item.setQuantity(1);
				cartItems.put(id, item);
			}
		}
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("myCartTotal", totalPrice(cartItems));
		session.setAttribute("myCartNum", cartItems.size());
		return "checkout";
	}
	
	@RequestMapping(value = "sub/{productId}", method = RequestMethod.GET)
	public String viewUpdate(ModelMap model, HttpSession session,
			@PathVariable("productId") Long id) {
		HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
			cartItems = new HashMap<Long, Cart>();
		}
		session.setAttribute("cartItems", cartItems);
		return "checkout";
	}
	
	@RequestMapping(value = "remove/{productId}", method = RequestMethod.GET)
	public String viewRemove(ModelMap model, HttpSession session,
			@PathVariable("productId") Long id) {
		HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
			cartItems = new HashMap<Long, Cart>();
		}
		if (cartItems.containsKey(id)) {
			cartItems.remove(id);
		}
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("myCartTotal", totalPrice(cartItems));
		session.setAttribute("myCartNum", cartItems.size());
		return "checkout";
	}
	
	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String checkout(ModelMap model, HttpSession session,
			@RequestParam(name = "name") String name,
			@RequestParam(name = "email") String email,
			@RequestParam(name = "address") String address) {
		HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
		Receipt receipt = new Receipt();
		receipt.setName(name);
		receipt.setEmail(email);
		receipt.setAddress(address);
		receipt.setStatus(1);
        receiptService.create(receipt);
        for (Map.Entry<Long, Cart> entry : cartItems.entrySet()) {
            ReceiptItem receiptItem = new ReceiptItem();
            receiptItem.setReceipt(receipt);
            receiptItem.setProduct(entry.getValue().getProduct());
            receiptItem.setItemPrice(entry.getValue().getProduct().getPrice());
            receiptItem.setItemSale(entry.getValue().getProduct().getSale());
            receiptItem.setItemQuantity(entry.getValue().getQuantity());
            receiptItem.setItemStatus(1);
            receiptItemService.create(receiptItem);
        }
        cartItems = new HashMap<Long, Cart>();
        session.setAttribute("myCartItems", cartItems);
        session.setAttribute("myCartTotal", 0);
        session.setAttribute("myCartNum", 0);
        model.addAttribute("messenger", "Đã thanh toán thành công!!!!");
        return "checkout";
	}
	
	private double totalPrice(HashMap<Long, Cart> cartItems) {
		double count = 0;
		for (Map.Entry<Long, Cart> list : cartItems.entrySet()) {
			count += list.getValue().getProduct().getPrice() * list.getValue().getQuantity();
		}
		return count;
	}
	
}
