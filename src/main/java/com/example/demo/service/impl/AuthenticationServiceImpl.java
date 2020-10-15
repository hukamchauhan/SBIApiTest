package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jparepositories.AccountDetailsRepository;
import com.example.demo.model.AccountDetails;
import com.example.demo.model.PersonalDetails;
import com.example.demo.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

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

	@Override
	public boolean verifyToken(long accountNumber, String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void getAccountNumber() {
		
	}

}
