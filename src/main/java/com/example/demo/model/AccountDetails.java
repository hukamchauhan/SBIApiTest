package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "account_details")
public class AccountDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1923044987772360855L;

	@Id
	@GeneratedValue
	@Column(name = "account_id")
	private Long accountId;
	
	@Column(name = "account_number", nullable=false)
	private String accountNumber;
	
	@Column(name = "card_type", nullable=false)
	private String cardType;
	
	@Column(name = "card_number", nullable=false)
	@JsonProperty("debitCardNumber")
	private String debitCardNumber;
	
	@Column(name = "card_status", nullable=false)
	@JsonProperty("cardStatus")
	private String cardStatus;
	
	@Column(name = "code", nullable=false)
	private String code;
	
	@ManyToOne
	@JoinColumn(name="personal_details_pk", nullable=false)
	private PersonalDetails personalDetails;
	
	@JsonIgnoreProperties({"accountId"})
	@OneToMany(mappedBy = "accountId", fetch = FetchType.EAGER)
	private List<AccountCurrentBalance> currentBalanceList;
	
	@Transient
	@JsonProperty("amount")
	int amount;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getDebitCardNumber() {
		return debitCardNumber;
	}

	public void setDebitCardNumber(String debitCardNumber) {
		this.debitCardNumber = debitCardNumber;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public List<AccountCurrentBalance> getCurrentBalanceList() {
		return currentBalanceList;
	}

	public void setCurrentBalanceList(List<AccountCurrentBalance> currentBalanceList) {
		this.currentBalanceList = currentBalanceList;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
