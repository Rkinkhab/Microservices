package com.example.member.memberservice;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
class Members {

	@Id
	public String id;

	String name;

	Date effectiveDate;

	Date expirationDate;

	public Members() {
		super();
	}

	public Members(String id, String name, Date effectiveDate, Date expirationDate) {
		super();
		this.id = id;
		this.name = name;
		this.effectiveDate = effectiveDate;
		this.expirationDate = expirationDate;
	}

	public String get_id() {
		return id;
	}

	public void set_id(String _id) {
		this.id = _id;
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
