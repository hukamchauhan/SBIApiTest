package com.example.demo.service;

import com.example.demo.model.AccountDetails;
import com.example.demo.model.PersonalDetails;;

public interface AuthenticationService {
	
	PersonalDetails getDetails(AccountDetails account);

	String withdraw(PersonalDetails pd, int amount);
	
	String deposit(PersonalDetails pd, int amount);
}
