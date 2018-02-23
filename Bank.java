package Homework2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A bank that holds accounts and can be accessed by the ATM
 * 
 * @author Joshua Liang
 * @copyright: 9/23/2017
 * @version 1.1
 */

public class Bank {
	private String bankID;
	private ArrayList<CashCard> cards; // A bank has an arraylist of cashcard
	private ArrayList<BankAccount> bankWithAccounts; // A bank has an arraylist
														// of bank accounts

	/**
	 * Constructs a bank with an id and an ArrayList of banks
	 * 
	 * @param bankID
	 *            the identity of the bank
	 */
	public Bank(String bankID) {
		this.bankID = bankID;
		bankWithAccounts = new ArrayList<BankAccount>();
		cards = new ArrayList<CashCard>();
	}

	/**
	 * Gets the bankID
	 * 
	 * @return the bankID
	 */
	public String getBankID() {
		return this.bankID;
	}

	/**
	 * Adds a bank account to a bank
	 * 
	 * @param account
	 *            account to be added
	 */
	public void addAccount(BankAccount account) {
		this.bankWithAccounts.add(account);
	}

	/**
	 * Gets the bank accounts of a bank
	 * 
	 * @return the bank accounts
	 */
	public ArrayList<BankAccount> getBankAccounts() {
		return this.bankWithAccounts;
	}

	/**
	 * Gets the cash cards of a bank
	 * 
	 * @return the the cash cards
	 */
	public ArrayList<CashCard> getCards() {
		return this.cards;
	}

	/**
	 * Adds a cash card to a bank
	 * 
	 * @param cashCard
	 *            cash card to be added
	 */
	public void addCard(CashCard cashCard) {
		this.cards.add(cashCard);
	}

}
