package com.example.prescribe.prescribeservice;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "prescribe")
class Prescribe {

	@Id
	String NPID;

	Date effectiveDate;

	Date expirationDate;

	public Prescribe() {
		super();
	}

	public Prescribe(String nPID, Date effectiveDate, Date expirationDate) {
		super();
		NPID = nPID;
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

}