package com.bank.service.exception;

public class BankException extends Exception {
	private String msg;
	public BankException(String msg) {
		this.msg = msg;
	}

	private static final long serialVersionUID = 1L;

}
