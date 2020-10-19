package com.example.demo.controllers;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.jparepositories.AccountCurrentBalanceRepository;
import com.example.demo.model.AccountCurrentBalance;
import com.example.demo.model.AccountDetails;
import com.example.demo.model.PersonalDetails;
import com.example.demo.service.AuthenticationService;

@Controller
@RequestMapping("/SBIRestAPI")
public class SBIRestController{
	
	@Autowired
	AuthenticationService authenticationService;
	
	@RequestMapping(value = "/getAccountDetails", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PersonalDetails authorize(@RequestBody AccountDetails basicDetails) {
		PersonalDetails pd = authenticationService.getDetails(basicDetails);
		if(pd==null) {
			pd = new PersonalDetails();
			pd.setMsg("No Record Found");
		}
		return pd;
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String withdraw(@RequestBody AccountDetails basicDetails) {
		String status = "";
		PersonalDetails pd = authenticationService.getDetails(basicDetails);
		if(pd==null) {
			pd = new PersonalDetails();
			status = "No Record Found";
		} else {
			try {
				status = authenticationService.withdraw(pd, basicDetails.getAmount());
			} catch(Exception e) {
				return e.getMessage();
			}
		}
		return status;
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String deposit(@RequestBody AccountDetails basicDetails) {
		String status = "";
		PersonalDetails pd = authenticationService.getDetails(basicDetails);
		if(pd==null) {
			pd = new PersonalDetails();
			status = "No Record Found";
		} else {
			try {
				status = authenticationService.deposit(pd, basicDetails.getAmount());
			} catch(Exception e) {
				return e.getMessage();
			}
		}
		return status;
	}
	

}
