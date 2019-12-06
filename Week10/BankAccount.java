public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean hasOverdraft;
    private double interestRate;

    public BankAccount(String accountNumber, String accountHolder, double balance, boolean hasOverdraft, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.hasOverdraft = hasOverdraft;
        this.interestRate = interestRate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isHasOverdraft() {
        return hasOverdraft;
    }

    public void setHasOverdraft(boolean hasOverdraft) {
        this.hasOverdraft = hasOverdraft;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        else  {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            this.balance -= amount;
            return true;
        }
        else  {
            return false;
        }
    }

    public boolean addInterest (double interestRate) {
        if (balance > 0) {
            this.balance += (this.balance * interestRate);
            return true;
        }
        else {
            return false;
        }
    }
    // Constructor Here.
// Code -> Generate -> Constructor

// Getters and Setters Here.
// Code -> Generate -> Getters and Setters

// Deposit Method Here

// Withdraw Method Here.

// AddInterest Method Here.

// toString Method Here.
// Code -> Generate -> ...

}
