package org.cdac.ankit.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // To Denote as Value Object not an Entity Object
public class Address {
	
	@Column(name="Street_Name")
	private String street;
	
	@Column(name="City_Name")
	private String city;
	
	@Column(name="State_Name")
	private String state;
	
	@Column(name="Country_Name")
	private String country;
	
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
}
