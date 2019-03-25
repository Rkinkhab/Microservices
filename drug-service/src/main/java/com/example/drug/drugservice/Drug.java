package com.example.drug.drugservice;

import java.util.Date;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drug")
class Drug {

	@Id
	String NDCID;

	String name;

	Date effectiveDate;

	Date expirationDate;

	public Drug() {
		super();
	}

	public Drug(String nDCID, String name, Date effectiveDate, Date expirationDate) {
		super();
		NDCID = nDCID;
		this.name = name;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
	}

	public String getNDCID() {
		return NDCID;
	}

	public void setNDCID(String nDCID) {
		NDCID = nDCID;
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