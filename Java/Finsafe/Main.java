package Java.Finsafe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account myAccount = new Account("Nani", 500.0); 

        System.out.println("Welcome to FinSafe Digital Wallet");

        while (true) {
            System.out.println("1. Deposit | 2. Withdraw | 3. Mini Statement | 4. Exit");
            System.out.print("Select Option: ");
            int choice = scanner.nextInt();

            if (choice == 4) break;

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        myAccount.deposit(scanner.nextDouble());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        myAccount.processTransaction(scanner.nextDouble());
                        break;
                    case 3:
                        myAccount.printMiniStatement();
                        break;
                    default:
                        System.out.println("Invalid Option.");
                }
            } catch (InSufficientFundsException | IllegalArgumentException e) {
                System.out.println("ERROR: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("General Error: Invalid input.");
                scanner.nextLine(); 
            }
        }
        scanner.close();
        System.out.println("Thank you for using FinSafe!");
    }
}
