package com.example.pharmacy.pharmacyservice;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="pharmacy")
class Pharmacy {

	@Id
	String NPID;

	String name;

	Date effectiveDate;

	Date expirationDate;

	public Pharmacy() {
		super();
	}

	public Pharmacy(String nPID, String name, Date effectiveDate, Date expirationDate) {
		super();
		NPID = nPID;
		this.name = name;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
	}

	public String getNPID() {
		return NPID;
	}

	public void setNPID(String nPID) {
		NPID = nPID;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}