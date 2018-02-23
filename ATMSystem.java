package Homework2;

import java.util.Scanner;
import java.util.GregorianCalendar;

/**
 * Tester Class
 * 
 * @author Joshua Liang
 * @copyright: 9/24/2017
 * @version 1.5
 *
 */
public class ATMSystem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		BankAccount chase1 = new BankAccount(0, 40, "chase1");
		BankAccount chase2 = new BankAccount(1, 300, "chase2");
		BankAccount america1 = new BankAccount(1, 300, "america1");
		BankAccount america2 = new BankAccount(1, 300, "america2");
		CashCard chaseCard1 = new CashCard("Chase", 0);
		CashCard chaseCard2 = new CashCard("Chase", 1);
		chaseCard2.setDate(2017, 7, 23);
		CashCard americaCard1 = new CashCard("America", 0);
		CashCard americaCard2 = new CashCard("America", 1);
		Bank Chase = new Bank("Chase");
		Chase.addAccount(chase1);
		Chase.addAccount(chase2);
		Chase.addCard(chaseCard1);
		Chase.addCard(chaseCard2);
		Bank America = new Bank("America");
		America.addAccount(america1);
		America.addAccount(america2);
		America.addCard(americaCard1);
		America.addCard(americaCard2);
		ATM chaseATM1 = new ATM(Chase, "Chase");
		ATM chaseATM2 = new ATM(Chase, "Chase");
		ATM americaATM1 = new ATM(America, "America");
		ATM americaATM2 = new ATM(America, "America");
		System.out.println("States of two Banks\n");
		System.out.println("Bank Chase (" + Chase.getBankAccounts().size() + " customers)");
		for (int i = 0; i < Chase.getBankAccounts().size(); i++) {
			System.out.print("Customer - (BankID: " + Chase.getBankID() + ", " + "Account Number: "
					+ Chase.getBankAccounts().get(i).getAccountNumber() + ", " + "Balance: " + Chase.getBankAccounts().get(i).getBalance() + ", " + "Password: "
					+ Chase.getBankAccounts().get(i).getPassword() + ", CashCard expires on: ");
			Chase.getCards().get(i).printDate();
		}
		System.out.println();
		System.out.println("Bank America (" + America.getBankAccounts().size() + " customers)");
		for (int i = 0; i < America.getBankAccounts().size(); i++) {
			System.out.print("Customer - (BankID: " + America.getBankID() + ", " + "Account Number: "
					+ America.getBankAccounts().get(i).getAccountNumber() + ", " + "Balance: " + America.getBankAccounts().get(i).getBalance() + ", " + "Password: "
					+ America.getBankAccounts().get(i).getPassword() + ", CashCard expires on: ");
			America.getCards().get(i).printDate();
		}
		System.out.println();
		System.out.println("States of four ATMs (2 for each Bank \n");
		System.out.println("chaseATM1: (ATM1 for Bank Chase)");
		System.out.println("   " + "The maximum amount of cash a card can withdraw per day: $50\n");
		System.out.println("chaseATM2: (ATM2 for Bank Chase)");
		System.out.println("   " + "The maximum amount of cash a card can withdraw per day: $50\n");
		System.out.println("americaATM1: (ATM1 for Bank America)");
		System.out.println("   " + "The maximum amount of cash a card can withdraw per day: $50\n");
		System.out.println("americaATM2: (ATM2 for Bank America)");
		System.out.println("   " + "The maximum amount of cash a card can withdraw per day: $50\n");
		while (true) {
			System.out.println("Hello, would you like to access Chase or America?");
			String whichBank = in.nextLine();
			if (whichBank.equals("Chase")) {
				System.out.println("chaseATM1 and chaseATM2 are open. Please enter which ATM to use (case sensitive).");
				String whichATM = in.nextLine();
				if (whichATM.equals("chaseATM1")) {
					chaseATM1.displayMenu(in);
				} else if (whichATM.equals("chaseATM2")) {
					chaseATM2.displayMenu(in);
				} else {
					System.out.println("The ATM you entered isn't open. Good bye.");
				}
			} else if (whichBank.equals("America")) {
				System.out.println(
						"americaATM1 and americaATM2 are open. Please enter which ATM to use (case sensitive).");
				String whichATM = in.nextLine();
				if (whichATM.equals("americaATM1")) {
					americaATM1.displayMenu(in);
				} else if (whichATM.equals("americaATM2")) {
					americaATM2.displayMenu(in);
				} else {
					System.out.println("The ATM you entered isn't open. Good bye.");
				}
			} else {
				System.out.println("Sorry the bank you entered is not valid.");
			}
		}

	}

}
