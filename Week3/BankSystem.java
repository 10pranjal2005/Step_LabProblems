package LabProblems;
class BankAccount {
    private String accountNumber, accountHolder;
    private double balance;
    private static int totalAccounts = 0;

    public BankAccount(String holder, double deposit) {
        if (deposit < 0) deposit = 0;
        totalAccounts++;
        this.accountNumber = "ACC" + String.format("%03d", totalAccounts);
        this.accountHolder = holder;
        this.balance = deposit;
    }

    public void deposit(double amt) {
        if (amt > 0) balance += amt;
    }

    public void withdraw(double amt) {
        if (amt > 0 && amt <= balance) balance -= amt;
    }

    public void checkBalance() {
        System.out.println(accountNumber + " Balance: " + balance);
    }

    public void displayInfo() {
        System.out.println(accountNumber + " | " + accountHolder + " | " + balance);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        BankAccount[] accs = new BankAccount[2];
        accs[0] = new BankAccount("Alice", 1000);
        accs[1] = new BankAccount("Bob", 500);

        accs[0].deposit(200);
        accs[1].withdraw(100);

        for (BankAccount a : accs) a.displayInfo();
        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}
