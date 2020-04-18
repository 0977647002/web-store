package com.nguyentanhuy.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "receipt")
public class Receipt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "date")
	@UpdateTimestamp
	private Timestamp date;
	
	@Column(name = "status")
	private int status;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "receipt")
	private List<ReceiptItem> listReceiptItem;

	public Receipt() {
	}

	public Receipt(Long id, String name, String email, String address, Timestamp date, int status,
			List<ReceiptItem> listReceiptItem) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.date = date;
		this.status = status;
		this.listReceiptItem = listReceiptItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<ReceiptItem> getListReceiptItem() {
		return listReceiptItem;
	}

	public void setListReceiptItem(List<ReceiptItem> listReceiptItem) {
		this.listReceiptItem = listReceiptItem;
	}
}
