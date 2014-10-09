package com.eteligent.services.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.eteligent.accountservice.AccountDetailsRequest;
import com.eteligent.accountservice.AccountDetailsResponse;
import com.eteligent.services.AccountService;
import com.eteligent.webservices.Account;

public class AccountServiceEndpoint {

	private static final String TARGET_NAMESPACE = "http://com/eteligent/accountservice";
	
	@Autowired
	private AccountService accountServiceImpl;
	
	public void setAccountService(AccountService accountService){
		this.accountServiceImpl = accountService;
	}
	
	@PayloadRoot(localPart = "AccountDetailsRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload AccountDetailsResponse getAccountDetails(@RequestPayload AccountDetailsRequest request){
		AccountDetailsResponse response = new AccountDetailsResponse();
		Account account = accountServiceImpl.getAccountDetails(request.getAccountNumber());
		response.setAccountDetails(account);
		return response;
	}
}
