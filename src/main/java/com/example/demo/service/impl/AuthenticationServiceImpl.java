package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jparepositories.AccountCurrentBalanceRepository;
import com.example.demo.jparepositories.AccountDetailsRepository;
import com.example.demo.model.AccountCurrentBalance;
import com.example.demo.model.AccountDetails;
import com.example.demo.model.PersonalDetails;
import com.example.demo.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	@Autowired
	AccountCurrentBalanceRepository accountCurrentBalanceRepository;

	Map<String, String> authDetails = new HashMap<String, String>();
	
	@Override
	public PersonalDetails getDetails(AccountDetails account) {
		PersonalDetails token = null;
		try {
			token = accountDetailsRepository.getAccountDetails(account.getDebitCardNumber());
		} catch(Exception e) {
			e.printStackTrace();
		}
		return token;
	}

	@Transactional
	public String withdraw(PersonalDetails pd, int amount) {
		String status = "";
		try {
			AccountCurrentBalance acb = pd.getAccountList().get(0).getCurrentBalanceList().get(0);
			acb.setCurrent_balance(acb.getCurrent_balance().subtract(BigDecimal.valueOf(amount)));
			accountCurrentBalanceRepository.save(acb);
			status="success";
		} catch(Exception e) {
			throw new RuntimeException("Internal Error");
		}
		return status;
	}

	@Transactional
	public String deposit(PersonalDetails pd, int amount) {
		String status = "";
		try {
		AccountCurrentBalance acb = pd.getAccountList().get(0).getCurrentBalanceList().get(0);
		acb.setCurrent_balance(acb.getCurrent_balance().add(BigDecimal.valueOf(amount)));
		accountCurrentBalanceRepository.save(acb);
		status = "success";
		} catch(Exception e) {
			throw new RuntimeException("Internal Error");
		}
		return status;
	}


}
