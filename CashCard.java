package Homework2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * CashCard that each bank account has
 * 
 * @author Joshua Liang
 * @copyright: 9/23/2017
 * @version 1.1
 */
public class CashCard {
	private String bankID;
	private int accountNumber;
	public Calendar expirationDate;

	/**
	 * Constructs a Cashcard with card number, account number, and expiration
	 * date
	 */
	public CashCard(String bankID, int accountNumber) {
		this.bankID = bankID;
		this.accountNumber = accountNumber;
		expirationDate = Calendar.getInstance();
		expirationDate.add(Calendar.MONTH, 1);
		expirationDate.add(Calendar.YEAR, 4);
	}

	/**
	 * Gets the bankID of the cash card
	 * 
	 * @return bankID
	 */
	public String getBankID() {
		return bankID;
	}

	/**
	 * Gets the account number of the cash card
	 * 
	 * @return account number
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Gets the expiration date
	 * 
	 * @return expiration date
	 */
	public Calendar getDate() {
		return expirationDate;
	}

	
	/**
	 * Equals method which satisfies compareTo to make Cashcards comparable
	 */
	public boolean equals(Object x) {
		CashCard that = (CashCard) x;
		return this.compareTo(that) == 0;

	}

	/**
	 * CompareTo method that satisfies equals method
	 * 
	 * @param that
	 *            the cash card to compare
	 * @return the difference in comparison
	 */
	public int compareTo(CashCard that) {
		int deflineCmp = this.bankID.compareTo(that.bankID);
		if (deflineCmp != 0) {
			return deflineCmp;
		}
		return this.accountNumber - (that.accountNumber);
	}

	/**
	 * Set and change the expiration date manually. Each cash card expiration
	 * date is already set in constructor. This can be to renew a date or also
	 * make a date expired on purpose to test in tester.
	 */
	public void setDate(int year, int month, int date) {
		expirationDate.clear();
		expirationDate.set(year, month, date);
	}

	/**
	 * Print method for the expiration date of a cash card
	 */
	public void printDate() {
		System.out.println(expirationDate.get(Calendar.MONTH) + "/" + expirationDate.get(Calendar.DAY_OF_MONTH) + "/"
				+ expirationDate.get(Calendar.YEAR));
	}
}
