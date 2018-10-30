package com.iheart.iHeart.Media.model;

/*import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/


//@Entity
//@Data
public class Advertiser {

/*	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	@Setter
	private String contactName;
	
	@Getter
	@Setter
	private double creditLimit;*/

	private long id;
	private String name;
	private String contactName;
	private double creditLimit;
	
	public Advertiser() {
		super();
	}
	
	public Advertiser(Long id, String name, String contactName, double creditLimit) {
		super();
		this.id = id;
		this.name = name;
		this.contactName = contactName;
		this.creditLimit = creditLimit;
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

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	
	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	@Override
	public String toString() {
		return String.format("Student [id=%s, name=%s, passportNumber=%s]", id, name, contactName);
	}	
	
}
