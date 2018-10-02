package com.dev.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "Cart")
public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * private fields for Cart
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	/*@Column(name="user_id")
	private int userId;*/
	
	//linking the Cart with a User
	@OneToOne
	//@JoinColumn(name="uId")
	private User user;
	
	@Column(name="grand_total")
	private double grandTotal;
	@Column(name="cart_lines")
	private int cartLines;
	
	// setter and getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/*public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}*/
	
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", grandTotal="
				+ grandTotal + ", cartLines=" + cartLines + "]";
	}
}
