package Java.Finsafe;

import java.util.ArrayList;

public class Account {
    private String accountHolder; // Encapsulation 
    private double balance;
    private ArrayList<Double> transactionHistory; // Collections :- To store last 5 transactions 

    public Account(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public void processTransaction(double amount) throws InSufficientFundsException {
        
        if (amount <= 0) {
            // throwing Built In Exception
            throw new IllegalArgumentException("Transaction amount must be positive.");
        }

        
        if (amount > balance) {
            // Throwing User Defined Exception
            throw new InSufficientFundsException("Insufficient Funds! Current Balance: $" + balance);
        }

        
        balance -= amount;
        logTransaction(-amount); 
        System.out.println("Withdrawal Successful. Remaining Balance: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            logTransaction(amount);
            System.out.println("Deposit Successful. New Balance: $" + balance);
        }
    }

    
    private void logTransaction(double amount) {
        transactionHistory.add(amount);
        if (transactionHistory.size() > 5) {
            transactionHistory.remove(0); // Maintaining only last 5  transactions
        }
    }

    public void printMiniStatement() {
        System.out.println("\n--- Mini Statement for " + accountHolder + " ---");
        for (Double tx : transactionHistory) {
            String type ;
            if (tx > 0)
                type = "Deposit";
            else 
                type = "Withdraw";
            System.out.println(type +" " +Math.abs(tx));
        }
        System.out.println("Final Balance: $" + balance + "\n");
    }
}
