package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.exception.AccountNotFoundException;
import com.org.exception.InsufficientBalanceException;
import com.org.model.beans.Account;
import com.org.model.service.AccountService;
import com.org.model.util.ObjectFactory;

public class MainViewController {

	public static void main(String[] args) {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		AccountService service = ObjectFactory.getAccountServiceInstance();
		do {
			System.out.println("1: Create Account 2: Check Balance");
			System.out.println("3: Transfer Amount 4: Sort Accounts by name 5: Sort Accounts by account number 0: Exit");
			option = scanner.nextInt();
			List<Account> list = null;
			switch(option) {
			case 1: 
				System.out.println("Enter name");
				Account account = new Account(scanner.next());
				try {
				Account createdAccount = service.createAccount(account);
				System.out.println(createdAccount);
				}
				catch(AccountNotFoundException e)
				{
					System.out.println("Unable to create account" + e.getMessage());
				}
				
				break;
			case 2:
				try {
				System.out.println("Enter account number");
				double y=service.getBalance(scanner.nextInt());
					System.out.println(y);
				}
				catch(InsufficientBalanceException e)
				{
					System.out.println("Unable to fetch balance" + e.getMessage());
				}
			case 3:
				try {
				int sa=scanner.nextInt();
				int da=scanner.nextInt();
				double am=scanner.nextDouble();
				service.transfer(sa, da, am);
				System.out.println("Transfer successful.......");
				}
				catch(InsufficientBalanceException | AccountNotFoundException e)
				{
					System.out.println("Low funds" + e.getMessage());
				}
				break; 
			
			case 4: 
			
					list = service.getAccountsSortedByName();
				
				list.forEach(acc -> System.out.println(acc));
				break;
			case 5:
				
					list = service.getAccountsSortedByAccountNumber();
				list.forEach(acc -> System.out.println(acc));
				break;
			}
		} while(option != 0);
		
		scanner.close();
	}

}

