package Homework2;

import java.util.Calendar;
import java.util.Scanner;

/**
 * An ATM that reads a cash card number and accesses the bank
 * 
 * @author Joshua Liang
 * @copyright: 9/23/2017
 * @version 1.1
 *
 */
public class ATM {
	private Bank bank;
	private String bankID;
	public Calendar today;

	/**
	 * Constructs an ATM that belongs to a bank
	 */
	public ATM(Bank bank, String bankID) {
		today = Calendar.getInstance();
		this.bank = bank;
		this.bankID = bankID;
	}

	/**
	 * Displays a Menu that read's user input to create or begin access to a
	 * bank account
	 * 
	 * @param in
	 *            user input
	 */
	public void displayMenu(Scanner in) {
		CashCard card;
		System.out.println("The maximum amount of cash a card can withdraw per transaction is $50");
		System.out.println("Hello, enter 'c' to create an account or enter 'a' to access your bank account");
		String choice = in.nextLine();
		if (choice.equals("c") || choice.equals("C")) {
			System.out.println("Please enter an account number");
			String number = in.nextLine();
			int accountNumber = Integer.parseInt(number);
			System.out.println("Please enter an account password");
			String password = in.nextLine();
			System.out.println("Please enter an amount of money to add to your Balance and insert the money.");
			String money = in.nextLine();
			int balance = Integer.parseInt(money);
			BankAccount account = new BankAccount(accountNumber, balance, password);
			bank.addAccount(account);
			card = new CashCard(bankID, accountNumber);
			bank.addCard(card);
			System.out.println("Thank you, your account has been created.");
			System.out.println("Here is your cashcard information");
			System.out.println("Bank ID: " + bankID);
			System.out.println("Account Number: " + accountNumber);
		} else if (choice.equals("a") || choice.equals("A")) {
			System.out.println("Enter your cash card Bank ID");
			String IDnumber = in.nextLine();
			System.out.println("Enter your Account Number");
			String number = in.nextLine();
			int accountNumber = Integer.parseInt(number);
			card = new CashCard(IDnumber, accountNumber);
			if (bank.getCards().contains(card)) {
				if (readCashCard(bank.getCards().indexOf(card)) == false) {
					System.out.println("Your card is invalid due to expiration. Please take your card. Good bye.");
				} else {
					authorizationDialog(accountNumber);
				}
			} else {
				System.out.println(
						"Your card is invalid due to incorrect bank id or associated account number. Good bye");

			}
		}
	}

	/**
	 * Checks if cash card is valid with a series of checks
	 * 
	 * @param cashCard
	 *            cash card to check
	 * @return true if valid
	 */
	public boolean readCashCard(int pos) {
		if (bank.getCards().get(pos).getBankID().equals(bankID)) {
			if (bank.getCards().get(pos).getDate().getTime().after(today.getTime())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * A sequence of messages/commands to grant customer authorization through
	 * correct password and legitimate cash card
	 * 
	 * @param accountNumber
	 */
	public void authorizationDialog(int accountNumber) {
		Scanner in = new Scanner(System.in);
		System.out.println("Your card is accepted. Please enter your password");
		String password = in.nextLine();
		boolean found = false;
		if (bank.getBankAccounts().get(accountNumber).getPassword().equals(password)) {
			found = true; // we found
			transactionDialog(accountNumber);

		} else {
			System.out.println("Sorry, you entered an incorrect password. Please take your card. Goodbye.");
		}
	}

	/**
	 * A sequence of messages/commands that will allow a customer to withdraw
	 * money from bank account
	 */
	public void transactionDialog(int accountNumber) {
		Scanner in = new Scanner(System.in);
		boolean transaction = true;
		while (transaction) {
			System.out.println("Authorization is accepted. Enter withdraw amount to begin transaction");
			String input = in.nextLine();
			int amount = Integer.parseInt(input);
			if (amount > 50) {
				System.out.println("The transaction limit is $50");
			} else if (amount < 1) {
				System.out.println("You must withdraw at least $1");
			} else {
				if (bank.getBankAccounts().get(accountNumber).getBalance() >= amount) {
					bank.getBankAccounts().get(accountNumber).reduceBalance(amount);
					System.out.println("Your new account balance is:");
					System.out.println(bank.getBankAccounts().get(accountNumber).getBalance());
					System.out.println("Please take your $" + amount);
					transaction = false;
				} else {
					System.out.println("Your account has insufficient funds.");
				}
			}
		}
	}
}
