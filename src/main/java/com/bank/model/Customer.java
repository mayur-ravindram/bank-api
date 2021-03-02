package com.bank.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Customer {
	private String id;
	private String uid;
	private String firstName;
	private String middleName;
	private String lastName;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;
	private Gender gender;
	private String orchestrationId;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrchestrationId() {
		return orchestrationId;
	}
	public void setOrchestrationId(String orchestrationId) {
		this.orchestrationId = orchestrationId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
