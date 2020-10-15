package com.example.demo.service;

import com.example.demo.model.AccountDetails;
import com.example.demo.model.PersonalDetails;;

public interface AuthenticationService {
	
	PersonalDetails getDetails(AccountDetails account);

    boolean verifyToken(long accountNumber, String token);

	void getAccountNumber();

}
