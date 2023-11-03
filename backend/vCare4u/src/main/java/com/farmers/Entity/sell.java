package com.farmers.Entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Table(name="sell")
@Entity
public class sell {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger productid;
	private String productname;
	private String productdesc;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String productimage;
	private String mobilenu;
	 public BigInteger getProductid() {
		return productid;
	}
	public void setProductid(BigInteger productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getProductdesc() {
		return productdesc;
	}
	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}
	public String getProductimage() {
		return productimage;
	}
	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}
	public String getMobilenu() {
		return mobilenu;
	}
	public void setMobilenu(String mobilenu) {
		this.mobilenu = mobilenu;
	}
	public sell() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sell(String productname, String productdesc, String productimage, String mobilenu) {
		super();
		this.productname = productname;
		this.productdesc = productdesc;
		this.productimage = productimage;
		this.mobilenu = mobilenu;
	}
	
	
	

}
