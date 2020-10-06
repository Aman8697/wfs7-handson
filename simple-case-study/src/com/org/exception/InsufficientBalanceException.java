package com.org.exception;

public class InsufficientBalanceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InsufficientBalanceException(String msg)
	{
		super(msg);
	}
	public InsufficientBalanceException(Throwable e)
	{
		super(e);
	}

}
