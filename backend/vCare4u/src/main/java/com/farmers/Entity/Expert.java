package com.farmers.Entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Expert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;
	
	
	private String name;
	
	
	private String email;
	
	
	private String phone;
	
	
	private String aadhar;

	private String password;
	
	//private double rating;
	
	private boolean isActivated;
	
	private String activationCode;
	
	private String expertisefield;
	
	private String specialization;
	
	private String description;
	
	
	public Expert() {
		super();
	}


	public Expert(BigInteger id, String name, String email, String phone, String aadhar, String password,
			boolean isActivated, String activationCode, String expertisefield, String specialization,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.aadhar = aadhar;
		this.password = password;
		//this.rating = rating;
		this.isActivated = isActivated;
		this.activationCode = activationCode;
		this.expertisefield = expertisefield;
		this.specialization = specialization;
		this.description = description;
	}


	public BigInteger getId() {
		return id;
	}


	public void setId(BigInteger id) {
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAadhar() {
		return aadhar;
	}


	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


//	public double getRating() {
//		return rating;
//	}
//
//
//	public void setRating(double rating) {
//		this.rating = rating;
//	}


	public boolean isActivated() {
		return isActivated;
	}


	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}


	public String getActivationCode() {
		return activationCode;
	}


	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}


	public String getExpertisefield() {
		return expertisefield;
	}


	public void setExpertisefield(String expertisefield) {
		this.expertisefield = expertisefield;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
