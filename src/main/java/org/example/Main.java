package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = null;
        int id = 0;
        double initialDeposit = 0;
        UserAccount account = new UserAccount(username, id, initialDeposit);
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Print Account Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");


            int choice = scanner.nextInt();

            id = 1;
            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    username = scanner.next();
                    System.out.println("Enter account ID:"+ id);
                    System.out.print("Enter initial deposit amount: ");
                    initialDeposit = scanner.nextDouble();
                    account = new UserAccount(username, id, initialDeposit);
                    System.out.println("The Id is saved as: "+ id);
                    break;
                case 2:
                    System.out.print("Enter account ID: ");
                    id = scanner.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    id = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.print("Enter account ID: ");
                    id = scanner.nextInt();
                    System.out.println("Current balance: $" + account.checkBalance());
                    break;
                case 5:
                    account.printAccountInfo();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}