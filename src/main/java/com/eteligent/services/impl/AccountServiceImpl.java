package com.eteligent.services.impl;

import com.eteligent.services.AccountService;
import com.eteligent.webservices.Account;
import com.eteligent.webservices.EnumAccountStatus;

public class AccountServiceImpl implements AccountService{

	public Account getAccountDetails(String accountNumber) {
		Account account = new Account();
		account.setAccountNumber("1234");
		account.setAccountName("JM Ramos");
		account.setAccountBalance(1500);
		account.setAccountStatus(EnumAccountStatus.ACTIVE);
		return account;
	}

}
