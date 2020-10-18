package BankHW;

import java.text.NumberFormat;
import java.util.Random;

import static BankHW.RandomSequence.intSequenceGen;

// A class to create Account objects for a bank program.
public class Account {

    private long accountNumber;
    private double accountBalance;
    private static final double MININUM_BALANCE = 1000.00;
    private static final double OVERDRAFT_FEE = 25.00;
    // A formatting object to return doubles for currency.
    private NumberFormat dollarFormat = NumberFormat.getCurrencyInstance();

    // Constructor sets acount balance at zero, and creates
    // a randomly generated account number of 9 digits.
    public Account() {
        this.accountBalance = 0.00;
        this.accountNumber = intSequenceGen(9);
    }
    // Account balance get method.
    public void getBalance() {
        System.out.println("Your current account balance is $" + dollarFormat.format(this.accountBalance) + ".");
    }

    // Account number get method.
    public long getAccountNumber() {
        return this.accountNumber;
    }

    // Unused account number set method.
    public void setAccountNumber() {
        this.accountNumber = intSequenceGen(9);
    }

    // A deposit method, adds amount to the account balance.
    public void depositFunds(double deposit) {
        this.accountBalance += deposit;
    }

    // A withdrawal method. Checks that balance is over zero, and
    // if so withdraws the amount. Then checks to see if this
    // overdrafted the account, and if so applies an overdraft
    // fee.
    public void withdrawFunds(double withdrawal) {
        if (this.accountBalance > 0) {
            this.accountBalance -= withdrawal;
            if (this.accountBalance < 0.00) {
                this.accountBalance -= OVERDRAFT_FEE;
                System.out.println("Your account has overdrafted and you have been charged an overdraft fee.");
            }
        } else {
            System.out.println("Your account balance is below zero and this transaction cannot be completed.");
        }
    }

    // Prints out the account number and balance.
    public void printAccountInfo() {
        System.out.println("This account's ID number is " + this.accountNumber + ".");
        System.out.println("Your current account balance is $" + dollarFormat.format(this.accountBalance) + ".");

    }
}
