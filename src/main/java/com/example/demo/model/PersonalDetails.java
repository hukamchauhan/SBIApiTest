package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "personal_details")
public class PersonalDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7676118729248189592L;

	@Id
	@GeneratedValue
	@Column(name = "person_id")
	@JsonProperty("personId")
	private Long personId;
	
	@Column(name = "name", nullable=false)
	@JsonProperty("name")
	private String name;
	
	@Column(name = "contact_number", nullable=false)
	@JsonProperty("contactNumber")
	private String contactNumber;
	
	@Column(name = "pan_number", nullable=false)
	@JsonProperty("panNumber")
	private String panNumber;
	
	@Column(name = "aadhar_number", nullable=false)
	@JsonProperty("aadharNumber")
	private String aadharNumber;
	
	@Column(name = "address", nullable=false)
	@JsonProperty("address")
	private String address;
	
	@Column(name = "account_status", nullable=false)
	@JsonProperty("accountStatus")
	private String accountStatus;
	
	@JsonIgnoreProperties({"personalDetails"})
	@OneToMany(mappedBy = "personalDetails", fetch = FetchType.LAZY)
	@JsonProperty("accountList")
	private List<AccountDetails> accountList= new ArrayList<>();
	
	@Transient
	private String msg;
	
	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<AccountDetails> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<AccountDetails> accountList) {
		this.accountList = accountList;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
