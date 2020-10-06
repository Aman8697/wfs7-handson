package com.org.exception;

public class AccountNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String msg)
	{
		super(msg);
	}
	public AccountNotFoundException(Throwable e)
	{
		super(e);
	}
	

}
