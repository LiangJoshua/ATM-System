package  Homework2;

import java.util.Scanner;

/**
 * A bank account that holds money and can be accessed by the bank
 * 
 * @author Joshua Liang
 * @copyright: 9/23/2017
 * @version 1.1
 *
 */
public class BankAccount {
	private int accountNumber;
	private int balance;
	private String password;

	/**
	 * Constructs a bank account with associated number and a balance of amount
	 * of money
	 * 
	 * @param accountNumber
	 *            associated number for account
	 * @param balance
	 *            amount of money in account
	 */
	public BankAccount(int accountNumber, int balance, String password) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.password = password;
	}
	
	/**
	 * Gets the account number of an account
	 * 
	 * @return the account number
	 */
	public int getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * Gets the amount of money in an account
	 * 
	 * @return amount of money
	 */
	public int getBalance() {
		return this.balance;
	}

	/**
	 * Withdraws an amount of money from an account
	 * 
	 * @param amount
	 *            amount of money to withdraw
	 */
	public void reduceBalance(int amount) {
		balance = balance - amount;
	}

	/**
	 * Gets the password of an account
	 * 
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}

}
