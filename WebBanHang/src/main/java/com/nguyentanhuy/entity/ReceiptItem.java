package com.nguyentanhuy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "receipt_item")
public class ReceiptItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "receipt_id")
	private Receipt receipt;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(name = "item_quantity")
	private int itemQuantity;
	
	@Column(name = "item_price")
	private double itemPrice;
	
	@Column(name = "item_sale")
	private int itemSale;
	
	@Column(name = "item_status")
	private int itemStatus;

	public ReceiptItem() {
	}

	public ReceiptItem(Long id, Receipt receipt, Product product, int itemQuantity, double itemPrice, int itemSale,
			int itemStatus) {
		this.id = id;
		this.receipt = receipt;
		this.product = product;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
		this.itemSale = itemSale;
		this.itemStatus = itemStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemSale() {
		return itemSale;
	}

	public void setItemSale(int itemSale) {
		this.itemSale = itemSale;
	}

	public int getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}
}
