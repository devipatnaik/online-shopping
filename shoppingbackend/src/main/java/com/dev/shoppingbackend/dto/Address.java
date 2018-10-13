package com.dev.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
//@Table(name="Address")
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private fields for Address
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="address_line_one")
	@NotBlank(message = "Please enter address one!")
	private String addressLineOne;
	
	@Column(name="address_line_two")
	@NotBlank(message = "Please enter address two!")
	private String addressLineTwo;
	
	@NotBlank(message = "Please enter city name!")
	private String city;
	
	@NotBlank(message = "Please enter state name!")
	private String state;
	
	@NotBlank(message = "Please enter country name!")
	private String country;
	
	@Column(name="postal_code")
	@NotBlank(message = "Please enter postal code!")
	private String postalCode;
	
	private boolean billing;
	private boolean shipping;
	
	/*@Column(name="user_id")
	private int userId;*/
	
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	/*public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}*/
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	
	/*toString for logging and debugging activity.
	 * */
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineOne="
				+ addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", country="
				+ country + ", postalCode=" + postalCode + ", billing="
				+ billing + ", shipping=" + shipping + "]";
	}
}
