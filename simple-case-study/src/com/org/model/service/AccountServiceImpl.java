package com.org.model.service;

import java.util.List;
import java.util.stream.Collectors;

import com.org.exception.AccountNotFoundException;
import com.org.exception.InsufficientBalanceException;
import com.org.model.beans.Account;
import com.org.model.dao.AccountDao;
import com.org.model.util.ObjectFactory;

public class AccountServiceImpl implements AccountService {

	
	private AccountDao accountDao = null;
	public AccountServiceImpl() {
		accountDao = ObjectFactory.getAccountDaoInstance();
	}
	
	
	@Override
	public Account createAccount(Account account) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		return accountDao.createAccount(account);
	}

	@Override
	public double getBalance(int accountNumber) throws InsufficientBalanceException {
		
		Account a;
		try {
			a = accountDao.getAccount(accountNumber);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a.getBalance();
	}

	@Override
	public void transfer(int sourceAccount, int destincationAccount, double amount) throws InsufficientBalanceException {
		
		Account sa;
		try {
			sa = accountDao.getAccount(sourceAccount);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Account da;
		try {
			da = accountDao.getAccount(destincationAccount);
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double sab=sa.getBalance();
		double dab=sa.getBalance();
		
		sab=sab-amount;
		dab=dab+amount;
		
		sa.setBalance(sab);
		da.setBalance(dab);
	}

	@Override
	public List<Account> getAccountsSortedByName() {
		List<Account> accounts;
		try {
			accounts = accountDao.getAccounts();
			List<Account> sortedAccount = accounts.stream()
					.sorted((account1, account2) -> account1.getCustomerName().compareTo(account2.getCustomerName()))
					.collect(Collectors.toList());
			return sortedAccount;
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Account> getAccountsSortedByAccountNumber(){
		// TODO Auto-generated method stub
		List<Account> accounts;
		try {
			accounts = accountDao.getAccounts();
			List<Account> sortedAccount = accounts.stream()
					.sorted((account1, account2) -> account1.getAccountNumber()-(account2.getAccountNumber()))
					.collect(Collectors.toList());
			return sortedAccount;
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
