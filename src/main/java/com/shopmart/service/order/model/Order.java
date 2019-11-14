package com.shopmart.service.order.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "seq_gen")
	@Column(length = 100)
	@GenericGenerator(name="seq_gen",strategy= "com.shopmart.service.order.utility.SequenceGenerator")
	private String transId;

	@NotNull
	private Integer cardId;

	@NotNull
	private Integer amount;

	private Date date;

	@NotNull
	@ElementCollection
	@CollectionTable(name = "order_product_details",joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "products")
	private List<Product> products;

	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id")
	@NotNull
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
