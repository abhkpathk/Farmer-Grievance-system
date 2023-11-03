package com.farmers.Entity;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

//import org.hibernate.annotations.Entity;
//@Table(name="Newgriev")
@Entity
public class NewGriev {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger grievId;
	private String grievType;
	private String textGriev;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	private Date date;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String ansimage;
	private String anstextGriev;
	private Date ansdate;
	
	
	public String getAnsimage() {
		return ansimage;
	}
	public void setAnsimage(String ansimage) {
		this.ansimage = ansimage;
	}
	public String getAnstextGriev() {
		return anstextGriev;
	}
	public void setAnstextGriev(String anstextGriev) {
		this.anstextGriev = anstextGriev;
	}
	public Date getAnsdate() {
		return ansdate;
	}
	public void setAnsdate(Date ansdate) {
		this.ansdate = ansdate;
	}
	public void setTextGriev(String textGriev) {
		this.textGriev = textGriev;
	}

	public BigInteger getGrievId() {
		return grievId;
	}
	public void setGrievId(BigInteger grievId) {
		this.grievId = grievId;
	}
	public String getGrievType() {
		return grievType;
	}
	public void setGrievType(String grievType) {
		this.grievType = grievType;
	}
	public String getTextGriev() {
		return textGriev;
	}
	public void setTextgriev(String textgriev) {
		this.textGriev = textgriev;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		
		this.date =date;
	}
	
	public NewGriev(String grievType, String textGriev, String image,Date date) {
		super();
		this.grievType = grievType;
		this.textGriev = textGriev;
		this.image = image;
		this.date = date;
	}
	
	public NewGriev() {
		super();
	}
		
}