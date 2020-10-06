package com.org.model.service;

import java.util.List;

import com.org.exception.AccountNotFoundException;
import com.org.exception.InsufficientBalanceException;
import com.org.model.beans.Account;

public interface AccountService {
	public Account createAccount(Account account) throws AccountNotFoundException;
	public double getBalance(int accountNumber) throws InsufficientBalanceException;
	// call updateBalance() on source & destination account
	public void transfer(int sourceAccount, int destincationAccount, double amount) throws InsufficientBalanceException;
	public List<Account> getAccountsSortedByName() ;
	public List<Account> getAccountsSortedByAccountNumber();
}
