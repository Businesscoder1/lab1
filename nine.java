// Account.java

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Abstract class Account
abstract class Account {
    // Instance variables
    protected String customerName;
    protected String accountNumber;
    protected double balance;

    // Static variable to generate unique account numbers
    private static int accountCounter = 1000;

    // Static constant for minimum balance
    protected static final double MIN_BALANCE = 1000;

    // Constructor
    public Account(String customerName) {
        this.customerName = customerName;
        this.accountNumber = generateAccountNumber();
        this.balance = 0;
    }

    // Method to generate unique account number
    private static String generateAccountNumber() {
        return "ACC" + accountCounter++;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void deposit(double amount);

    public abstract void displayBalance();

    public abstract void displayBankBalances();

    public abstract void computeAndDepositInterest();

    public abstract void withdraw(double amount);

    public abstract void checkMinimumBalance();

    // Method to mark account as duplicate
    public void markAsDuplicate() {
        this.customerName += " (Duplicate)";
    }

    // Method to check if two customers contain the same details
    public static boolean isDuplicate(Account account1, Account account2) {
        return account1.customerName.equals(account2.customerName) &&
               account1.accountNumber.equals(account2.accountNumber);
    }

    // Method to assign system-generated account number
    protected void assignAccountNumber() {
        this.accountNumber = generateAccountNumber();
    }
}

// SavingAccount class extending Account
class SavingAccount extends Account {
    // Constructor
    public SavingAccount(String customerName) {
        super(customerName);
    }

    // Method to deposit money
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    // Method to display balance
    @Override
    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    // Method to display bank balances
    @Override
    public void displayBankBalances() {
        // Assuming bank opening balance is 0
        double openingBalance = 0;
        // Assuming bank closing balance includes balances of all accounts
        double closingBalance = balance;
        System.out.println("Bank Opening Balance: " + openingBalance);
        System.out.println("Bank Closing Balance: " + closingBalance);
    }

    // Method to compute and deposit interest
    @Override
    public void computeAndDepositInterest() {
        // Assuming interest rate for saving account is fixed at 5% annually
        double interestRate = 0.05;
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest computed and deposited: " + interest);
    }

    // Method to withdraw money
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to check minimum balance and impose penalty if necessary
    @Override
    public void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            double penalty = 100; // Assuming penalty amount
            balance -= penalty;
            System.out.println("Minimum balance not maintained. Penalty imposed: " + penalty);
        }
    }
}

// CurrentAccount class extending Account
class CurrentAccount extends Account {
    // Constructor
    public CurrentAccount(String customerName) {
        super(customerName);
    }

    // Method to deposit money
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    // Method to display balance
    @Override
    public void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    // Method to display bank balances
    @Override
    public void displayBankBalances() {
        // Assuming bank opening balance is 0
        double openingBalance = 0;
        // Assuming bank closing balance includes balances of all accounts
        double closingBalance = balance;
        System.out.println("Bank Opening Balance: " + openingBalance);
        System.out.println("Bank Closing Balance: " + closingBalance);
    }

    // Method to compute and deposit interest (no interest for current account)
    @Override
    public void computeAndDepositInterest() {
        System.out.println("No interest for current account.");
    }

    // Method to withdraw money
    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to check minimum balance and impose penalty if necessary
    @Override
    public void checkMinimumBalance() {
        if (balance < MIN_BALANCE) {
            double penalty = 500; // Assuming penalty amount
            balance -= penalty;
            System.out.println("Minimum balance not maintained. Penalty imposed: " + penalty);
        }
    }
}

public class nine {
    public static void main(String[] args) {
        // Create SavingAccount and CurrentAccount objects
        SavingAccount savingAccount = new SavingAccount("John Doe");
        CurrentAccount currentAccount = new CurrentAccount("Jane Smith");

        // Test methods
        savingAccount.deposit(5000);
        savingAccount.computeAndDepositInterest();
        savingAccount.displayBalance();
        savingAccount.checkMinimumBalance();

        currentAccount.deposit(3000);
        currentAccount.withdraw(2000);
        currentAccount.displayBalance();
        currentAccount.checkMinimumBalance();

        // Checking duplicate account
        SavingAccount duplicateAccount = new SavingAccount("John Doe");
        if (Account.isDuplicate(savingAccount, duplicateAccount)) {
            duplicateAccount.markAsDuplicate();
            System.out.println("Duplicate account found. Marked as duplicate.");
        }
    }
}

