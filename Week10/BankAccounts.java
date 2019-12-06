import java.util.Random;

public class BankAccounts {

    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean hasOverdraft;
    private double interestRate = 0.025;



    private String generateAccountNumber() {
        String acc = "";
        Random rg = new Random();
        for (int i = 0; i < 9; i++) {
            acc += rg.nextInt(10);
        }
        return acc;
    }

    public BankAccounts(String accountNumber, String accountHolder, double balance, boolean hasOverdraft, double interestRate) {
        this.accountNumber = generateAccountNumber();
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
        if (balance > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (balance > 0 || hasOverdraft == true) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean addInterest() {
        if (balance > 0) {
            this.balance += (this.balance * interestRate);
            return true;
        } else {
            return false;
        }
    }
}
